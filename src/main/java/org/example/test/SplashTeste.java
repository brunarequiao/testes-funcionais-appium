package org.example.test;

import org.example.core.BaseTest;
import org.example.page.MenuPage;
import org.example.page.SplashPage;
import org.junit.Assert;
import org.junit.Test;

public class SplashTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private SplashPage splashPage = new SplashPage();

    @Test
    public void deveAguardarSplashSumir() {
        menu.acessarSplash();

        splashPage.isTelaSplashVisivel();

        splashPage.aguardarSplashSumir();

        Assert.assertTrue(splashPage.existeUmElementoPorTexto("Formulário"));
    }
}
