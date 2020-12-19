package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getDriverInstance() throws Exception {
        switch (getData("browserType")) {
            case "Chrome": {
                if (driver == null) {
                    System.setProperty("webdriver.chrome.driver", "c://chromedriver//chromedriver.exe");
                    driver = new ChromeDriver();
                }
                return driver;
            }
            default:
                throw new IllegalArgumentException("No such driver");
        }
    }

    public static String getData(String keyName) throws Exception {
        ClassLoader classLoader = DriverManager.class.getClassLoader();
        File fXmlFile = new File("src/main/resources/data.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }
}
