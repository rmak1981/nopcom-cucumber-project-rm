package com.demo.nopcom.pages;

import com.cucumber.listener.Reporter;
import com.demo.nopcom.utility.UtilityRM;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Ravi's Creation
 * Date of Creation 27 Apr 20
 */
public class BooksPage extends UtilityRM {

    private static final Logger log = LogManager.getLogger(BooksPage.class.getName());

    @FindBy( xpath = "//select[@id='products-orderby']")
    WebElement _positionDropDownMenu;

    @FindBy(xpath = "//div[@class='product-grid']//h2/a")
    WebElement _sortAtoZResults;

    @FindBy(xpath = "//div[@class='prices']")
    WebElement _sortLowToHighResults;

    @FindBy(xpath = "//h1[contains(text(),'Books')]")
    WebElement _booksPageText;


    public void verifyBooksPageText(String booksMsg){
        Reporter.addStepLog("verify books msg"+_booksPageText.toString()+"<br>");
        verifyTextAssertMethod(_booksPageText,booksMsg);
        log.info("verify books msg"+_booksPageText.toString());

    }

    public void clickOnSortByAtoZ (){
        Reporter.addStepLog("select product order "+_positionDropDownMenu.toString()+"<br>");
        waitUntilElementToBeClickable(_positionDropDownMenu,10);
        selectByIndexFromDropDown(_positionDropDownMenu,1);
        log.info("select product order "+_positionDropDownMenu.toString());

    }
    public void clickOnPriceLowToHigh(){
        Reporter.addStepLog("select product price order "+_positionDropDownMenu.toString()+"<br>");
        waitUntilElementToBeClickable(_positionDropDownMenu,10);
        selectByIndexFromDropDown(_positionDropDownMenu,3);
        log.info("select product price order "+_positionDropDownMenu.toString());
    }

    // this method is for verification of books sort by A to Z

    public void verifySortByAtoZ() {

        List<String> booksNames = new ArrayList<>();

        Select select = new Select(driver.findElement(By.id("products-orderby")));
        select.selectByVisibleText("Name: A to Z");

        List<WebElement> booksList = driver.findElements(By.xpath("//div/div[2]/h2/a"));

        for (WebElement ele : booksList) {
            booksNames.add(ele.getText());
        }

        List<String> tempList = new ArrayList<>();
        tempList.addAll(booksNames);
        System.out.println(tempList);
        Collections.sort(tempList);
        System.out.println(booksNames);
        Assert.assertEquals(booksNames, tempList);

        Reporter.addStepLog("Verify that books: "+booksNames+" are sorted AtoZ " +_sortAtoZResults.toString());
        log.info("Verify that books: "+booksNames+" are sorted AtoZ " +_sortAtoZResults.toString());
//        waitUntilElementToBeClickable(_sortAtoZResults, 20);
//        arrayListForEachLoopAssertEqualsForString((List<WebElement>) _sortAtoZResults);
    }

    // this method is for verification for price sort by Low to High

    public void verifySortByLowToHigh() {

        List<String> booksPrices = new ArrayList<>();

        Select select = new Select(driver.findElement(By.id("products-orderby")));
        select.selectByVisibleText("Price: Low to High");

        List<WebElement> booksList = driver.findElements(By.xpath("//span[@class='price actual-price']"));

        for (WebElement ele : booksList) {
            booksPrices.add(ele.getText());
        }

        List<String> tempList = new ArrayList<>();
        tempList.addAll(booksPrices);
        System.out.println(tempList);
        Collections.sort(tempList);
        System.out.println(booksPrices);
        Assert.assertEquals(booksPrices, tempList);

        Reporter.addStepLog("Verify that books: "+booksPrices+" are sorted Low to High " +_sortLowToHighResults.toString());
        log.info("Verify that books: "+booksPrices+" are sorted Low to High " +_sortLowToHighResults.toString());
//        waitUntilElementToBeClickable(_sortLowToHighResults, 20);
//        arrayListForEachLoopAssertEqualsForInt((List<WebElement>) _sortLowToHighResults);
    }


}
