package Tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import DataReader.ExcelReader;
import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestRunner {

    public static WebDriver driver;
    public static String url = "https://www.despegar.com.co/hoteles/";

    public String[][] nonNullData(String[][] dataSet) {
        List<String[]> nonNullData = new ArrayList<>();

        for (String[] row : dataSet) {
            if (row[0] != null) {
                nonNullData.add(row);
            }
        }

        return nonNullData.toArray(new String[0][]);
    }
    @DataProvider(name= "dp")
    public String [][] inputData() throws IOException {
        ExcelReader objExcelFile = new ExcelReader();
        String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\Data";
        String [][] dataSet = objExcelFile.readExcel(filePath,"List city.xlsx","Hoja1");
        System.out.println(dataSet.length);
        //return dataSet;
        return nonNullData(dataSet);
    }
    @BeforeTest
    public static void browser(){
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }
    @Test
    public void close_add() {
        System.out.println("Entra a prueba0");
        HomePage.close_modal();
        System.out.println("Sale de la prueba0");
    }
    @Test (dataProvider = "dp")
    void select_destination(String data) throws InterruptedException{
        System.out.println("Entra a prueba1 "+ data);
        HomePage.click_type_place(data);
        System.out.println("Sale de la prueba1");
    }

    @Test
    void select_Date(){
        System.out.println("Entra a prueba2");
        System.out.println("Entra a la función calendar");
        HomePage.open_calendar();
        System.out.println("Sale de la función calendar");
        //System.out.println("Entra a checkIn");
       // HomePage.select_date_ckeckIn();
        //System.out.println("Sale del checkIn");
        System.out.println("Entra a checkOut");
        HomePage.select_date_ckeckOut();
        System.out.println("Sale del checkOut");
        System.out.println("Sale de la prueba2");
   }
    @Test
    void select_searchButton(){
        System.out.println("Entra a prueba3");
        System.out.println("Entra a la función select button");
        HomePage.search_button();
        System.out.println("Sale de la función search button");
    }
    @AfterTest
    public static void CloseBrowser(){
        driver.quit();
    }
}
/*CucumberOptions(
        plugin = {"pretty",
        "html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json"
        },
        features = {"src/test/resources/features"},
        glue = {"Tests.StepDefinitions"}
        //tags = "@regression"
)
public class TestRunner extends AbstractTestNGCucumberTests {

}*/