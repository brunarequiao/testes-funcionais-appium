package org.example.core;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

import static org.example.core.DriverFactory.getDriver;

public class BasePage {

    public void escrever(By by, String texto) {
        getDriver().findElement(by).sendKeys(texto);
    }

    public String obterTexto(By by) {
        return getDriver().findElement(by).getText();
    }

    public void clicar(By by) {
        getDriver().findElement(by).click();
    }

    public void clicarPorTexto(String texto) {
        clicar(By.xpath("//*[@text='"+texto+"']"));
    }

    public void selecionarCombo(By by, String valor) {
        getDriver().findElement(by).click();
        clicarPorTexto(valor);
    }

    public boolean isCheckMarcado(By by) {
        return getDriver().findElement(by).getAttribute("checked").equals("true");
    }

    public boolean existeUmElementoPorTexto(String texto) {
        List<MobileElement> findElements = getDriver().findElements(By.xpath("//*[@text='"+texto+"']"));
        return findElements.size() > 0;
    }
}
