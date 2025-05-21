package org.example.page.seuBarriga;

import org.example.core.BasePage;
import org.openqa.selenium.By;

public class SBLoginPage extends BasePage {

    public void insereEmail(String email) {
        escrever(By.className("android.widget.EditText"), email);
    }

    public void insereSenha(String senha) {
        escrever(By.xpath("//android.widget.EditText[2]"), senha);
    }

    public void entrar() {
        clicarPorTexto("ENTRAR");
    }
}
