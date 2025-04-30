package org.example.test;

import org.example.core.BaseTest;
import org.example.page.AccordionPage;
import org.example.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class AccordionTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AccordionPage accordion = new AccordionPage();

    @Test
    public void deveInteragirComAccordion() throws InterruptedException {
        menu.acessarAccordion();

        accordion.selecionarOp1();

        esperar(1000);
        Assert.assertEquals("Esta é a descrição da opção 1", accordion.obterValorOp1());
    }
}
