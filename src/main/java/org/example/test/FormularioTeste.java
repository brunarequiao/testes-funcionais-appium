package org.example.test;

import org.example.core.BaseTest;
import org.example.core.DriverFactory;
import org.example.page.FormularioPage;
import org.example.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class FormularioTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private FormularioPage formulario = new FormularioPage();

    @Before
    public void inicializarAppium() throws MalformedURLException {
        menu.acessarFormulario();
    }

    @Test
    public void devePreencherCampoTexto() throws MalformedURLException {
        formulario.escreverNome("Bruna");

        assertEquals("Bruna", formulario.obterNome());
    }

    @Test
    public void deveInteragirCombo() throws MalformedURLException {
        formulario.selecionarCombo("Nintendo Switch");

        assertEquals("Nintendo Switch", formulario.obterValorCombo());
    }

    @Test
    public void deveInteragirComSwitchECheckbox() throws MalformedURLException {

        Assert.assertFalse(formulario.isCheckMarcado());
        Assert.assertTrue(formulario.isSwitchMarcado());

        formulario.clicarCheck();
        formulario.clicarSwitch();

        Assert.assertTrue(formulario.isCheckMarcado());
        Assert.assertFalse(formulario.isSwitchMarcado());
    }

    @Test
    public void deveRealizarCadastro() throws MalformedURLException {
        formulario.escreverNome("Bruna");
        formulario.clicarCheck();
        formulario.clicarSwitch();
        formulario.selecionarCombo("Nintendo Switch");

        formulario.salvar();

        assertEquals("Nome: Bruna", formulario.obterNomeCadastrado());

        assertEquals("Console: switch", formulario.obterConsoleCadastrado());

        Assert.assertTrue(formulario.obterCheckCadastrado().endsWith("Off"));

        Assert.assertTrue(formulario.obterSwitchCadastrado().endsWith("Marcado"));
    }

    @Test
    public void deveRealizarCadastroDemorado() throws MalformedURLException {
        formulario.escreverNome("Bruna");

        DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        formulario.salvarDemorado();

        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Bruna']")));

        assertEquals("Nome: Bruna", formulario.obterNomeCadastrado());
    }
}

