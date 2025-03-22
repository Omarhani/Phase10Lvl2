package t;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static reader.ReadDataFromJson.dataModel;

public class T {

    @Test
    public void t1() throws FileNotFoundException {

        System.out.println(dataModel().URL);
    }

    @Test
    public void t2() throws FileNotFoundException {
        System.out.println(dataModel().Login.ValidCreditials.Username);
        System.out.println(dataModel().Login.ValidCreditials.Password);
    }

    @Test
    public void t3() throws FileNotFoundException {
        System.out.println(dataModel().Login.InvalidCreditials.InvalidUsername.Username);
        System.out.println(dataModel().Login.InvalidCreditials.InvalidUsername.Password);
    }

    @Test
    public void t4()throws FileNotFoundException{
        System.out.println(dataModel().Login.InvalidCreditials.InvalidPassword.Username);
        System.out.println(dataModel().Login.InvalidCreditials.InvalidPassword.Password);
    }

    @DataProvider
    public Object[][] dataProviderToT5() throws FileNotFoundException {
        return dataModel().Login1;
    }

    @Test (dataProvider = "dataProviderToT5")
    public void t5(String username, String password){
        System.out.println(username);
        System.out.println(password);
    }
}
