package org.example.test;

import org.example.core.BaseTest;
import org.example.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class SwipeTeste extends BaseTest {

    private MenuPage menu = new MenuPage();

    @Test
    public void deveRealizarSwipe() {
        menu.acessarSwipe();

        Assert.assertTrue(menu.existeUmElementoPorTexto("a esquerda"));

        menu.swipeRight();

        Assert.assertTrue(menu.existeUmElementoPorTexto("E veja se"));

        menu.clicarPorTexto("›");

        Assert.assertTrue(menu.existeUmElementoPorTexto("Chegar até o fim!"));

        menu.swipeLeft();

        menu.clicarPorTexto("‹");

        Assert.assertTrue(menu.existeUmElementoPorTexto("a esquerda"));
    }
}
