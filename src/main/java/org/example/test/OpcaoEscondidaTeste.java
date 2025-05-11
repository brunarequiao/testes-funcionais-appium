package org.example.test;

import org.example.core.BaseTest;
import org.example.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class OpcaoEscondidaTeste extends BaseTest {

    private MenuPage menu = new MenuPage();

    @Test
    public void deveEncontrarOpcaoEscondida() {
        menu.scrollDown();

        menu.clicarPorTexto("Opção bem escondida");

        Assert.assertEquals("Você achou essa opção", menu.obterMensagemAlerta());

        menu.clicarPorTexto("OK");
    }
}
