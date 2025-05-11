package org.example.test;

import org.example.core.BaseTest;
import org.example.page.MenuPage;
import org.example.page.WebViewPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class WebViewTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private WebViewPage webView = new WebViewPage();

    @Test
    public void deveFazerLogin() {
        menu.acessarSBHibrido();

        esperar(3000);
        webView.entrarContextoWeb();

        webView.insereEmail("bruna@123.com");

        webView.insereSenha("123");

        webView.entrar();

        Assert.assertEquals("Bem vindo, Wagner!", webView.pegaMensagem());

    }

    @After
    public void tearDown() {
        webView.sairContextoWeb();
    }
}
