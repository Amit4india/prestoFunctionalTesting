package com.presto;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;


// Returing driver for BaseTestCase
public class WebDriverUtil {

    public static WebDriver driver = LaunchBrowser.getDriver();

    // Clicking on DropDown menu to view its content using below method
    public static void clickOnDropDown(String dropDown) {

    }
    // Insert value in any TextBox using this method identified by xpath
    public static void insertInTextBox(String textBoxId, String value) {
        findElementByXpath(textBoxId).sendKeys(value);
    }
    // Selecting any value from dropdown using visibleText
    public static void selectElementFromDropDownUsingVisibleText(String dropDownId, String selectedElement) {
        new Select(findElementByXpath(dropDownId)).selectByVisibleText(selectedElement);
    }
    // Selecting any value from dropdown using Index value
    public static void selectElementFromDropDownUsingIndex(String dropDownId, int index) {
        new Select(findElementByXpath(dropDownId)).selectByIndex(index);
    }
    // Extracting value of Dropdown item selected using Index
    public static String getElementFromDropDownUsingIndex(String dropDownId, int index) {
        return new Select(findElementByXpath(dropDownId)).getOptions().get(index).getText().toString();
    }

    // Clicking on any button using xpath
    public static void clickButtonUsingXpath(String buttonID) {
        findElementByXpath(buttonID).click();
    }


    // Clicking on radio button using Css

    public static void clickButtonUsingCss(String buttonID) {
        findElementByCss(buttonID).click();
    }
    // Clicking on any button identified by id
    public static void clickButtonUsingId(String buttonID) {
        findElementById(buttonID).click();
    }
    // Clicking on any button identified by Name
    public static void clickButtonUsingName(String buttonID) {
        findElementByName(buttonID).click();
    }
    // Finding Element using xpath
    public static WebElement findElementByXpath(String expression) {
        WebElement webElement = driver.findElement(By.xpath(expression));
        return webElement;
    }

    // Finding Element using css
    public static WebElement findElementByCss(String expression) {
        WebElement webElement = driver.findElement(By.cssSelector(expression));
        return webElement;
    }
    // Finding Element using Name
    public static WebElement findElementByName(String expression) {
        WebElement webElement = driver.findElement(By.name(expression));
        return webElement;

    }
    // Finding Element using ID
    public static WebElement findElementById(String expression) {
        WebElement webElement = driver.findElement(By.id(expression));
        return webElement;

    }
    // This method help us to find whether particular element is displayed or not . Also it has inbuilt waiting mechanism.
    public static boolean isElementDisplayed(String expression) {

        boolean isElementDisplayed = false;
        waitForElementToLoad(expression);
        try {
            isElementDisplayed = driver.findElement(By.xpath(expression)).isDisplayed();
        } catch (ElementNotVisibleException exception) {
            System.out.println("Exception occured while retrieving element");
            isElementDisplayed = false;
        }
        return isElementDisplayed;
    }
    // 	This method help us to find whether particular Radio button is selected or not . Also it has inbuilt waiting mechanism.
    public static boolean isRadioButtonSelected(String expression)
    {
        boolean isRadioButtonSelected = false;
        waitForElementToLoad(expression);
        try {
            isRadioButtonSelected = driver.findElement(By.cssSelector(expression)).isSelected();
        } catch (ElementNotVisibleException exception) {
            System.out.println("Exception occured while retrieving element");
            isRadioButtonSelected = false;
        }
        return isRadioButtonSelected;
    }
    // This method will help you to introduce wait . Means wait for particular element identified by xpath
    public static void waitForElementToLoad(String element) {
        int pageTimeOut=300;
        long endWaitTime = System.currentTimeMillis() + pageTimeOut;
        boolean isElementLoaded = false;

        while (System.currentTimeMillis() < endWaitTime && !isElementLoaded) {
            try {
                isElementLoaded = driver.findElement(By.xpath(element)).isDisplayed();
            } catch (Exception exception) {
                System.out.println("Page is not loaded yet.Waiting for page to load properly");
            }
            if (isElementLoaded) {
                break;
            } else {
                try {
                    // check for element in the interval of 0 and pagetimeout/2
                    // milliseconds
                    Thread.sleep(pageTimeOut / 2);
                } catch (InterruptedException e) {
                    System.out.println("Exception occured while waiting for an element");
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean isElementDisplayedByLink(String expression) {

        boolean isElementDisplayed = false;
        waitForElementToLoadByLink(expression);
        try {
            isElementDisplayed = driver.findElement(By.linkText(expression)).isDisplayed();
        } catch (ElementNotVisibleException exception) {
            System.out.println("Exception occured while retrieving element");
            isElementDisplayed = false;
        }
        return isElementDisplayed;
    }
    // Waiting Method by Link
    public static void waitForElementToLoadByLink(String element) {
        int pageTimeOut=300;
        long endWaitTime = System.currentTimeMillis() + pageTimeOut;
        boolean isElementLoaded = false;

        while (System.currentTimeMillis() < endWaitTime && !isElementLoaded) {
            try {
                isElementLoaded = driver.findElement(By.linkText(element)).isDisplayed();
            } catch (Exception exception) {
                System.out.println("Page is not loaded yet.Waiting for page to load properly");
            }
            if (isElementLoaded) {
                break;
            } else {
                try {
                    // check for element in the interval of 0 and pagetimeout/2 milliseconds
                    Thread.sleep(pageTimeOut/2);
                } catch (InterruptedException e) {
                    System.out.println("Exception occured while waiting for an element");
                    e.printStackTrace();
                }
            }
        }
    }
    // Provide generic wait for brower to wait for particular element get present before taking next action.
    public static void waitForElementToAppear() throws InterruptedException
    {
        Thread.sleep(3000);
    }

    public static void clickTabUsingByLink(String TabId) {
        findElementByLink(TabId).click();
    }

    public static WebElement findElementByLink(String expression) {
        WebElement webElement = driver.findElement(By.linkText(expression));
        return webElement;
    }

    public static String getTitle() {
        return driver.getTitle();
    }


    public static List<WebElement> getAllRows(WebElement table, String rowsPath)
    {
        List<WebElement> rowsCollection = table.findElements(By.xpath(rowsPath));
        return rowsCollection;
    }

    public static List<WebElement> getSingleRow(WebElement row)
    {
        List<WebElement> columns = row.findElements(By.xpath("td"));
        return columns;
    }

    public static List<WebElement> getFontElements(WebElement element)
    {
        List<WebElement> elements = element.findElements(By.xpath("font"));
        return elements;
    }
    public static List<WebElement> getHyperLinksElements(WebElement element)
    {
        List<WebElement> elements = element.findElements(By.xpath("a"));
        return elements;
    }


    public static String getTableColumnData(List<WebElement> columns,int index)
    {
        return columns.get(index).getText().toString();
    }


    public static void waitTillElementIsVisible(String Xpath)
    {
        WebDriverWait wait = new WebDriverWait(driver, 75);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));

    }

    public static List<WebElement> getTables(String xpath)
    {
        List<WebElement> tables = driver.findElements(By.xpath(xpath));
        return tables;
    }

    public static void quitBrowser()
    {
        driver.close();
    }

}

