package tests;

import java.net.MalformedURLException;


import org.openqa.selenium.WebElement;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class SwipeTest extends BaseTest{
  public static void main(String[] args) throws MalformedURLException {
    AndroidDriver<AndroidElement> driver = getAndroidDriver();
    driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
    driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
    driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
    driver.findElementByXPath("//*[@content-desc='9']").click();
    TouchAction t=new TouchAction(driver);
    //long press //on element// 2 sec// move to another element and you release
    WebElement first=driver.findElementByXPath("//*[@content-desc='15']");
    WebElement second=driver.findElementByXPath("//*[@content-desc='45']");

    t.longPress(longPressOptions()
        .withElement(element(first))
        .withDuration(ofSeconds(2)))
        .moveTo(element(second)).release().perform();

  }
}
