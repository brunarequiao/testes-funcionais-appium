package org.example.page.seuBarriga;

import org.example.page.MenuPage;

public class SBMenuPage extends MenuPage {

    public void acessarContas() {
        clicarPorTexto("CONTAS");
    }

    public void acessarMovimentacoes() {
        clicarPorTexto("MOV...");
    }

    public void acessarResumo() {
        clicarPorTexto("RESUMO");
    }

    public void acessarHome() {
        clicarPorTexto("HOME");
    }
}
