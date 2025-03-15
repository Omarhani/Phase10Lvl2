package t;

import org.testng.annotations.Test;
import reader.ReadDataFromJson;

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
}
