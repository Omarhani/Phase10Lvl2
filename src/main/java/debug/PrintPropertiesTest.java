package debug;
import java.io.InputStream;
import java.util.Properties;
public class PrintPropertiesTest {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();

        try (InputStream in = ClassLoader.getSystemResourceAsStream("allure.properties")) {
            if (in == null) {
                System.out.println("allure.properties not found in classpath.");
                return;
            }
            props.load(in);
            System.out.println("Properties loaded successfully.");
        } catch (Exception e) {
            System.out.println("Error loading allure.properties");
            e.printStackTrace();
        }
    }
}
