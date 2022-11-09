// A package in java used to group related classes.
package org.example;

// importing a package of selenium
import org.openqa.selenium.By;

// importing a package of selenium webdriver
import org.openqa.selenium.WebDriver;

// importing a package of chromedriver
import org.openqa.selenium.chrome.ChromeDriver;

// importing a package of aftermethod
import org.testng.annotations.AfterMethod;

// importing a package of beforemethod
import org.testng.annotations.BeforeMethod;

// importing a package of Test
import org.testng.annotations.Test;

// It allows for date formatting (date -> text), parsing (text -> date) and normalization.
import java.text.SimpleDateFormat;
import java.util.Date;


public class HomePage
{
    protected static WebDriver driver;

    // method simulates a mouse-click on an element
    public void ClickOnElement(By by) {
        driver.findElement(by).click();
    }

    // verifying messages, errors, asserting WebElements, and many more.
    // findElement command is used to uniquely identify a web element within the web page
    public String GettextFromElement(By by){
      return driver.findElement(by).getText();
    }

//to input content in editable text fields or password fields in a webpage.
//findElement command is used to uniquely identify a web element within the web page
    public void EnterText(By by,String text){
        driver.findElement(by).sendKeys(text);
    }

// implement before each test method
    @BeforeMethod
    public void openBrowser(){

        //.setProperty command is used for sets the property of the system which is indicated by a key
        System.setProperty("webdriver.chrome.driver","src/test/java/Drivers/chromedriver.exe");

        // To communicate test scripts with Google Chrome
        driver = new ChromeDriver();

        // to maximise the browser window
        driver.manage().window().maximize();

        //driver.get command used for to open  URL.it will wait till the whole page gets loaded.
        driver.get("https://demo.nopcommerce.com/");

    }

    // implement after each test method
    @AfterMethod
    public void closeBrowser() {driver.quit();}



    public void typeText(By by , String text ) {
        driver.findElement(by).sendKeys(text);
        }

     public String getTimeStamp(By by){
        return new SimpleDateFormat("yyyyMMDDHHmmss").format(new java.util.Date());
     }

    public String GetTextFromElement(By by){
        return driver.findElement(by).getText();
    }


        @Test
        public void BasePage(){

        String timeStamp = new SimpleDateFormat("YYYYMMDDHHmmss").format(new java.util.Date());
            System.out.println(timeStamp);
       ClickOnElement(By.className("ico-register"));
       ClickOnElement(By.id("gender-female"));

       typeText(By.id("FirstName"),"Krina");
       typeText(By.id("LastName"),"dave");
       typeText(By.xpath("//div[@class=\"date-picker-wrapper\"]/select[1]"),"28");
       typeText(By.xpath("//div[@class=\"date-picker-wrapper\"]/select[2]"),"February");
       typeText(By.xpath("//div[@class=\"date-picker-wrapper\"]/select[3]"),"1999");

       typeText(By.id("Email"),"kristyahuja" +timeStamp+"@hotmail.com");

       typeText(By.id("Company"),"NTT ltd");



       typeText(By.name("Password"),"Abc@0909");

       ClickOnElement(By.id("Newsletter"));

       typeText(By.name("ConfirmPassword"),"Abc@0909");

       ClickOnElement(By.name("register-button"));

            System.out.println();

            String message = GetTextFromElement(By.className("result"));

            System.out.println("message");

    }
    //This annotated method will be run after each method
    @Test
    public void Product(){
        //ClickonElement,EnterText[Reusable method called] for uniquely identify a web element with in the webpage by Id, By Classname, By Xpath
        ClickOnElement(By.className("header-menu"));
       ClickOnElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/computers\"]"));
        ClickOnElement(By.xpath("//a[@title=\"Show products in category Desktops\"]"));

        //regMsg,regMsg1,regMsg2is local variable to store the find element through gettext command

        String product1 = driver.findElement(By.xpath("//h2[@class=\"product-title\"]/a[@href=\"/build-your-own-computer\"]")).getText();


        String product2 = driver.findElement(By.xpath("//h2[@class=\"product-title\"]/a[@href=\"/digital-storm-vanquish-3-custom-performance-pc\"]")).getText();

        String product3 = driver.findElement(By.xpath("//h2[@class=\"product-title\"]/a[@href=\"/lenovo-ideacentre-600-all-in-one-pc\"]")).getText();

        //local variable item introduced to find element
        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product3);

    }
    //This annotated method will be run after each method
    @Test
    public void NewsComent(){

        ClickOnElement(By.className("read-more"));
      EnterText(By.className("enter-comment-title"),"Good shopping website");

        EnterText(By.className("enter-comment-text"),("This shopping website is very good they values customer's money&feedback."));
       ClickOnElement(By.name("add-comment"));

       //local variable introduced
        String newscomment = driver.findElement(By.className("result")).getText();
        // to printout in console
        System.out.println(newscomment);

    }
    //This annotated method will be run after each method
    @Test
    public void HomepageCategories(){
        ClickOnElement(By.className("header-menu"));

        //local variable regMsg Declared to store the value get from reusable method GettextFromElement through Xpath,Id or by Class
        String item1 = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/computers\"]")).getText();

        String item2 = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/electronics\"]")).getText();

        String item3 = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/apparel\"]")).getText();

        String item4 = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/digital-downloads\"]")).getText();

        String item5 = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/books\"]")).getText();

        String item6 = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/jewelry\"]")).getText();

        String item7 = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/gift-cards\"]")).getText();

        //local variable items introduced

        System.out.println(item1);
        System.out.println(item2);
        System.out.println(item3);
        System.out.println(item4);
        System.out.println(item5);
        System.out.println(item6);
        System.out.println(item7);

    }

    //This annotated method will be run after each method
    @Test
    public void EmailAFriend(){

        String timestamp = new SimpleDateFormat("yyyyMMDDHHmmss").format(new Date());
        // printing output for timestamp
        System.out.println(timestamp);

        //ClickOnElement,EnterText[Reusable method called] for uniquely identify a web element with in the webpage by Id, By Classname, By Xpath

        ClickOnElement(By.xpath("//div[@class=\"item-grid\"]//a[@href=\"/apple-macbook-pro-13-inch\"]"));
       ClickOnElement(By.className("email-a-friend"));
        EnterText(By.name("FriendEmail"),"ashish01"+timestamp+"@gmail.com");
        EnterText(By.name("YourEmailAddress"),"kristy"+timestamp+"@gmail.com");
        EnterText(By.name("PersonalMessage"),"This Macbook pro is very nice and attractive feature dear!!!!!");
        ClickOnElement(By.name("send-email"));

    //  msd is local variable to store the find element through gettextfromelement command
        String msg = GetTextFromElement(By.xpath("//div[@class=\"message-error validation-summary-errors\"]"));

        // printing output
        System.out.println(msg);

    }

}





