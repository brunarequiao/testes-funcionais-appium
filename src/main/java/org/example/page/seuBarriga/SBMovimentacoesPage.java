package org.example.page.seuBarriga;

import org.example.core.BasePage;
import org.openqa.selenium.By;

public class SBMovimentacoesPage extends BasePage {

    public void salvar() {
        clicarPorTexto("SALVAR");
    }

    public void insereDescricao(String desc) {
      escrever(By.className("android.widget.EditText"), desc);
    }

    public void insereInteressado(String interessado) {
        escrever(By.xpath("//android.widget.EditText[2]"), interessado);
    }

    public void insereValor(String valor) {
        escrever(By.xpath("//android.widget.EditText[3]"), valor);
    }

    public void insereConta(String conta) {
       selecionarCombo(By.xpath("//android.widget.Spinner[2]"), conta);
    }
}
