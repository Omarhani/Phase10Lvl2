package contactUs;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ContactUsPage;

import java.io.FileNotFoundException;
import static org.testng.Assert.assertTrue;
import static reader.ReadDataFromJson.dataModel;

public class ContactUsTests extends BaseTests {
    @Test
    public void testContactUs() throws FileNotFoundException {
        ContactUsPage contactUsPage=homePage.clickContactUsLink();
        assertTrue(contactUsPage.getContactUsPageTitle().equalsIgnoreCase("Get In Touch"));
        contactUsPage.insertContactUsName(dataModel().Contactus.Name);
        contactUsPage.insertContactUsEmail(dataModel().Contactus.Email);
        contactUsPage.insertContactUsSubject(dataModel().Contactus.Subject);
        contactUsPage.insertContactUsMessage(dataModel().Contactus.Message);
        contactUsPage.uploadFile(dataModel().Contactus.FilePath);
        contactUsPage.clickOnSubmitButton();
        contactUsPage.acceptContactUsAlert();
        assertTrue(contactUsPage.getContactUsSuccessMessage().contains("Success! Your details have been submitted successfully."));
    }
}
