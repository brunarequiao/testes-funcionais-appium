package org.example.core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.touch.TapOptions;
import org.openqa.selenium.Dimension;

import java.time.Duration;
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

    public void tap(int x, int y) {
        new TouchAction<>(getDriver())
                .tap(TapOptions.tapOptions().withPosition(PointOption.point(x, y)))
                .perform();
    }

    public void scroll(double inicio, double fim) {
        Dimension size = getDriver().manage().window().getSize();

        int x = size.width / 2;
        int yInicial = (int) (size.height * inicio);
        int yFinal = (int) (size.height * fim);

        new TouchAction(getDriver())
                .press(PointOption.point(x, yInicial))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x, yFinal))
                .release()
                .perform();
    }

    public void scrollDown() {
        scroll(0.9, 0.1);
    }

    public void scrollUp() {
        scroll(0.1, 0.9);
    }

    public void swipeLeft() {
        swipe(0.1, 0.9);
    }

    public void swipeRight() {
        swipe(0.9, 0.1);
    }

    public String obterTituloAlerta() {
        return obterTexto(By.id("android:id/alertTitle"));
    }

    public String obterMensagemAlerta() {
        return obterTexto(By.id("android:id/message"));
    }

    public void swipe(double inicio, double fim) {
        Dimension size = getDriver().manage().window().getSize();

        int y = size.width / 2;
        int xInicial = (int) (size.height * inicio);
        int xFinal = (int) (size.height * fim);

        new TouchAction(getDriver())
                .press(PointOption.point(xInicial, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(xFinal, y))
                .release()
                .perform();
    }

    public void swipeElement(MobileElement element, double inicio, double fim) {
        int y = element.getLocation().y + (element.getSize().height / 2);

        int xInicial = (int) (element.getSize().width * inicio);
        int xFinal = (int) (element.getSize().width * fim);

        new TouchAction(getDriver())
                .press(PointOption.point(xInicial, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(xFinal, y))
                .release()
                .perform();
    }

    public void cliqueLongo(By by) {
        new TouchAction<>(getDriver())
                .longPress(LongPressOptions.longPressOptions()
                        .withElement(ElementOption.element(getDriver().findElement(by))))
                .perform();
    }
}
