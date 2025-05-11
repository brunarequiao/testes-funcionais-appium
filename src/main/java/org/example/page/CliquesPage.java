package org.example.page;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.example.core.BasePage;
import org.openqa.selenium.By;

import static org.example.core.DriverFactory.getDriver;

public class CliquesPage extends BasePage {

    public void cliqueLongo() {
        new TouchAction<>(getDriver())
                .longPress(LongPressOptions.longPressOptions()
                        .withElement(ElementOption.element(getDriver().findElement(By.xpath("//*[@text='Clique Longo']")))))
                .release()
                .perform();
    }



    public String obterTextoCampo() {
        return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
    }
}
