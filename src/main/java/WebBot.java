
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebBot {

    private static final String siteUrl      = "https://sites.google.com/ncsu.edu/pepperpot/home";
    private static final String siteHeader   = "PepperPot";

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    public static void main(String [] args) {
        runMe();
    }

    public static void runMe(){
        try {
            int i = 1;
            while (true) {
                WebDriver driver = new HtmlUnitDriver( true );
                WebDriverWait wait = new WebDriverWait( driver, 5 );
                driver.get(siteUrl);
                wait.until(ExpectedConditions.titleContains(siteHeader));
                driver.close();
                System.out.print("Count: " + i++);
            }
        } catch (Exception e){
            runMe();
        }
    }

}
