package org.example.test;

import org.example.core.BaseTest;
import org.example.page.AlertaPage;
import org.example.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlertaTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AlertaPage alertaPage = new AlertaPage();

    @Before
    public void before() {
        menu.acessarAlertas();
    }

    @Test
    public void deveConfirmarAlerta() {
        alertaPage.clicarAlertaConfirm();

        Assert.assertEquals("Info", alertaPage.obterTituloAlerta());
        Assert.assertEquals("Confirma a operação?", alertaPage.obterMensagemAlerta());

        alertaPage.confirmar();

        Assert.assertEquals("Confirmado", alertaPage.obterMensagemAlerta());

        alertaPage.sair();
    }

    public void deveClicarForaAlerta() throws InterruptedException {
        alertaPage.clicarAlertaSimples();

        esperar(1000);
        alertaPage.clicarForaCaixa();

        Assert.assertFalse(alertaPage.existeUmElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));
    }
}
