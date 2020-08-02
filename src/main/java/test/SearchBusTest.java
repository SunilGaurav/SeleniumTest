package test;


import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;


public class SearchBusTest extends BaseTest {


    @Test
    public void testSearch() throws InterruptedException {

        logger=report.startTest("first test");
        //HomePage home = new HomePage(driver);
        logger.setDescription("launch test");

        Assert.assertTrue(1==2);
       // home.searchBuses("Bangalore","Chennai");

        logger.log(LogStatus.PASS , "Test is passed which started at :"+logger.getStartedTime()+" And ended at"+logger.getEndedTime());


    }
}
