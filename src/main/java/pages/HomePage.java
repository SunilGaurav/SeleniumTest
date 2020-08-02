package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath="/html/body/section/div[2]/main/section/div/div[2]/section/div/div[1]/div/input")
    WebElement fromField;

    @FindBy(xpath="/html/body/section/div[2]/main/section/div/div[2]/section/div/div[2]/div/input")
    WebElement toField;

    @FindBy(id="search_btn")
    WebElement searchButton;


   public void searchBuses(String from , String to) throws InterruptedException {

       fromField.click();
       fromField.sendKeys(from);
       Thread.sleep(2000);

       toField.clear();
       toField.sendKeys(to);
       Thread.sleep(2000);
       driver.findElement(By.xpath("/html/body/section/div[2]/main/section/div/div[2]/section/div/div[3]/div/label")).click();
       Thread.sleep(2000);
       String date = "10-Oct 2020";
       String splitter[] = date.split("-");
       String month_year = splitter[1];
       String day = splitter[0];
       System.out.println(month_year);
       System.out.println(day);

       selectDate(month_year,day);
       Thread.sleep(2000);
       searchButton.click();
   }


   public void selectDate(String monthyear, String Selectday) throws InterruptedException
    {
        List<WebElement> elements = driver.findElements(By.xpath("//div[@id='rb-calendar_onward_cal']/table/tbody/tr[1]/td[2]"));

        for (int i=0; i<elements.size();i++)
        {
            System.out.println(elements.get(i).getText());
            //Selecting the month
            if(elements.get(i).getText().equals(monthyear))
            {
                //Selecting the date
                List<WebElement> days = driver.findElements(By.xpath(".//*[@id='rb-calendar_onward_cal']/table/tbody/tr/td"));

                for (WebElement d:days)
                {
                    System.out.println(d.getText());
                    if(d.getText().equals(Selectday))
                    {
                        d.click();
                        Thread.sleep(10000);
                        return;
                    }
                }

            }

        }
        driver.findElement(By.xpath(".//*[@id='rb-calendar_onward_cal']/table/tbody/tr[1]/td[3]/button")).click();
        selectDate(monthyear,Selectday);

    }


}
