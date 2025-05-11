package org.example.page;

import org.example.core.BasePage;
import org.openqa.selenium.By;

import java.util.Set;

import static org.example.core.DriverFactory.getDriver;

public class WebViewPage extends BasePage {

    public void entrarContextoWeb() {
        Set<String> contextHandles = getDriver().getContextHandles();
        for(String valor: contextHandles) {
            System.out.println(valor);
        }

        getDriver().context((String) contextHandles.toArray()[1]);
    }

    public void sairContextoWeb() {
        getDriver().context((String) getDriver().getContextHandles().toArray()[0]);
    }

    public void insereEmail(String valor) {
        getDriver().findElement(By.id("email")).sendKeys(valor);
    }

    public void insereSenha(String valor) {
        getDriver().findElement(By.id("senha")).sendKeys(valor);
    }

    public void entrar() {
        clicar(By.xpath("//button[@type='submit']"));
    }

    public String pegaMensagem() {
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }

}
