package org.example.page.seuBarriga;

import org.example.core.BasePage;
import org.openqa.selenium.By;

public class SBContasPage extends BasePage {

    public void insereConta(String nome) {
        escrever(By.className("android.widget.EditText"), nome);
    }

    public void salvar() {
        clicarPorTexto("SALVAR");
    }

    public void excluir() {
        clicarPorTexto("EXCLUIR");
    }

    public void selecionarConta(String conta) {
        cliqueLongo(By.xpath("//*[@text='"+conta+"']"));
    }
}
