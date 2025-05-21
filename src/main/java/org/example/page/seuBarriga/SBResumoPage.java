package org.example.page.seuBarriga;

import io.appium.java_client.MobileElement;
import org.example.core.BasePage;
import org.openqa.selenium.By;

import static org.example.core.DriverFactory.getDriver;

public class SBResumoPage extends BasePage {

    public void excluirMovimentacao(String desc) {
        MobileElement element = getDriver().findElement(By.xpath("//*[@text='"+desc+"']/.."));
        swipeElement(element, 0.9, 0.1);
        clicarPorTexto("Del");

    }
}
