package utils;


import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "loginProvider")
    public static Object[][] getDataFromDataprovider() {

        Object[][] ob = ExcelReader.getTestData("sheet1");
        return ob;

    }


}
