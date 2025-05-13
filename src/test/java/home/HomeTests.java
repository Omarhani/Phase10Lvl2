package home;

import base.BaseTests;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static reader.ReadDataFromJson.dataModel;

public class HomeTests extends BaseTests {
    @Test
    public void verifyHomePageIsVisibleSuccessfully() throws FileNotFoundException {
        homePage.verifyHomeLinkIsOrange(dataModel().HomeColor);
    }


}
