package org.example.test;

import org.example.core.BaseTest;
import org.example.page.MenuPage;
import org.example.page.SwipeListPage;
import org.junit.Assert;
import org.junit.Test;

public class SwipeElementTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private SwipeListPage swipePage = new SwipeListPage();

    @Test
    public void deveResolverDesafio() {
        menu.acessarSwipeList();

        swipePage.swipeElementRight("Opção 1");

        swipePage.clicarBotaoMais();

        Assert.assertTrue(swipePage.existeUmElementoPorTexto("Opção 1 (+)"));

        swipePage.swipeElementRight("Opção 4");

        swipePage.clicarPorTexto("(-)");

        Assert.assertTrue(swipePage.existeUmElementoPorTexto("Opção 4 (-)"));

        swipePage.swipeElementLeft("Opção 5 (-)");

        Assert.assertTrue(swipePage.existeUmElementoPorTexto("Opção 5"));
    }
}
