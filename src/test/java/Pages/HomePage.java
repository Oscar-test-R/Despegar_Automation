package Pages;

import DataReader.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class HomePage {
    public static String close_announce = ".login-incentive--content .login-incentive--button.login-incentive--button-close.shifu-3-btn-ghost";
    public static String search_destinations = ".input-container [placeholder*=\"ciudad\"]";
    public static String select_first_destination = "li.item.-active > span.item-text > em";
    public static String check_in = "div .input-container [placeholder='Entrada'].input-tag";
    public static String listElement = "div.history-item__aside.-center .history-item__title";
    public static String select_date_check_in = "//div[@class='sbox5-monthgrid-datenumber-number' and text()='26']";
    public static String select_date_check_out = "//div[@class='sbox5-monthgrid-datenumber-number' and text()='29']";
    public static String search_button = "button.sbox5-box-button-ovr.sbox5-3-btn.sbox5-button.-secondary.-icon.-lg";
    public static WebDriver driver;
    /*@DataProvider(name= "dp")
    public Object[][] inputData() throws IOException {
        ExcelReader objExcelFile = new ExcelReader();
        String filePath = System.getProperty("user.dir")+"\\src\\test\\Data";
        String [][] dataSet = objExcelFile.readExcel(filePath,"List city.xlsx","Hoja1");
        return dataSet;
    }*/
    public static void click_type_place (String strCity) {
        System.out.println(strCity);
        System.out.println(search_destinations);
        WebElement locator_place = driver.findElement(By.cssSelector(search_destinations));
        System.out.println(search_destinations);
        locator_place.click();
        System.out.println(search_destinations);

       try{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
           System.out.println(search_destinations);
        WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(search_destinations)));
           System.out.println(search_destinations);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(listElement)));
        inputField.sendKeys(strCity);

        WebElement select_first = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(select_first_destination)));
        select_first.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*public static void click_type_place() {
        WebElement locator_place = driver.findElement(By.cssSelector(search_destinations));
        locator_place.click();

        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(search_destinations)));
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(listElement)));
            inputField.sendKeys("cali");

            WebElement select_first = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(select_first_destination)));
            select_first.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    public static void open_calendar() {
        WebElement open_calendar = driver.findElement(By.cssSelector(check_in));
        System.out.println("Va a Hacer click");
        open_calendar.click();
        System.out.println("Hace click");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Espera hasta 10 segundos
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(select_date_check_in)));
        // Esperar a que al menos un elemento esté presente en la lista
        System.out.println("hace el wait");

        List<WebElement> list = driver.findElements(By.xpath(select_date_check_in));
        System.out.println("Encuentra la lista");
        if (list.size() <= 2) {
            WebElement locatorDateCheckIn = list.get(1);
            wait.until(ExpectedConditions.elementToBeClickable(locatorDateCheckIn));
            locatorDateCheckIn.click();
        } else {
            System.out.println("No hay elementos");
        }
    }
    public static void select_date_ckeckOut() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Espera hasta 10 segundos
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(select_date_check_out)));
        System.out.println("hace el wait 2");

        List<WebElement> list = (List<WebElement>) driver.findElements(By.xpath(select_date_check_out));
        if (list.size() <= 2) {
            WebElement locatorDateCheckOut = list.get(0);
            wait.until(ExpectedConditions.elementToBeClickable(locatorDateCheckOut));
            locatorDateCheckOut.click();
            //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(select_date_check_out)));
        }else {
            System.out.println("No hay elementos");
        }
    }
    public static void search_button() {
        WebElement locator_search_button = driver.findElement(By.cssSelector(search_button));
        try {
            //Thread.sleep(2000);  // Pausa la ejecución durante 2 segundos (puedes ajustar según sea necesario
            locator_search_button.click();
            //Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void close_modal() {
        WebElement locator_modal = driver.findElement(By.cssSelector(close_announce));
        locator_modal.click();
    }
}