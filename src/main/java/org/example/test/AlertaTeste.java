package org.example.test;

import org.example.core.BaseTest;
import org.example.page.AlertaPage;
import org.example.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class AlertaTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AlertaPage alertaPage = new AlertaPage();

    @Test
    public void deveConfirmarAlerta() {
        menu.acessarAlertas();

        alertaPage.clicarAlertaConfirm();

        Assert.assertEquals("Info", alertaPage.obterTituloAlerta());
        Assert.assertEquals("Confirma a operação?", alertaPage.obterMensagemAlerta());

        alertaPage.confirmar();

        Assert.assertEquals("Confirmado", alertaPage.obterMensagemAlerta());

        alertaPage.sair();
    }
}
