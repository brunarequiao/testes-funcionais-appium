package org.example.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.example.core.BasePage;
import org.openqa.selenium.By;

import static org.example.core.DriverFactory.getDriver;

public class SwipeListPage extends BasePage {

    public void swipeElementLeft(String opcao) {
        swipeElement(getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")), 0.1, 0.9);
    }

    public void swipeElementRight(String opcao) {
        swipeElement(getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")), 0.9, 0.1);
    }

    public void clicarBotaoMais() {
        MobileElement botao = getDriver().findElement(By.xpath("//*[@text='(+)']/.."));

        new TouchAction<>(getDriver())
                .tap(
                        TapOptions.tapOptions()
                                .withElement(ElementOption.element(botao))
                                .withPosition(PointOption.point(-50, 0)) // Pode não funcionar com valores negativos
                )
                .perform();
    }
}
