package org.example.test;

import org.example.core.BaseTest;
import org.example.page.MenuPage;
import org.example.page.seuBarriga.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SBTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private SBLoginPage sb = new SBLoginPage();
    private SBMenuPage sbMenu = new SBMenuPage();
    private SBContasPage sbContas = new SBContasPage();
    private SBMovimentacoesPage sbMovimentacoes = new SBMovimentacoesPage();
    private SBHomePage sbHomePage = new SBHomePage();
    private SBResumoPage sbResumo = new SBResumoPage();

    @Before
    public void setup() {
        menu.acessarSBNativo();
        sb.insereEmail("bruna@123.com");
        sb.insereSenha("123");
        sb.entrar();
    }

    @Test
    public void deveInserirConta() {
        sbMenu.acessarContas();
        sbContas.insereConta("Conta de Teste");

        sbContas.salvar();
        Assert.assertTrue(sbContas.existeUmElementoPorTexto("Conta adicionada com sucesso"));
    }

    @Test
    public void deveExcluirConta() {
        sbMenu.acessarContas();

        sbContas.selecionarConta("123");

        sbContas.excluir();

        Assert.assertTrue(sbContas.existeUmElementoPorTexto("Conta excluída com sucesso"));
    }

    @Test
    public void deveValidarInclusaoMovimentacao() {
        sbMenu.acessarMovimentacoes();

        sbMovimentacoes.salvar();
        Assert.assertTrue(sbMovimentacoes.existeUmElementoPorTexto("Descrição é um campo obrigatório"));

        sbMovimentacoes.insereDescricao("Descrição da movimentação");

        sbMovimentacoes.salvar();
        Assert.assertTrue(sbMovimentacoes.existeUmElementoPorTexto("Interessado é um campo obrigatório"));

        sbMovimentacoes.insereInteressado("Bruna");

        sbMovimentacoes.salvar();
        Assert.assertTrue(sbMovimentacoes.existeUmElementoPorTexto("Valor é um campo obrigatório"));

        sbMovimentacoes.insereValor("200");

        sbMovimentacoes.salvar();
        Assert.assertTrue(sbMovimentacoes.existeUmElementoPorTexto("Conta é um campo obrigatório"));

        sbMovimentacoes.insereConta("Conta para alterar");

        sbMovimentacoes.salvar();
        Assert.assertTrue(sbMovimentacoes.existeUmElementoPorTexto("Movimentação cadastrada com sucesso"));
    }

    @Test
    public void deveAtualizarSaldoAoExcluirMovimentacao() {
        Assert.assertEquals("534.00", sbHomePage.obterSaldoConta("Conta para saldo"));

        sbMenu.acessarResumo();

        sbResumo.excluirMovimentacao("Movimentacao 3, calculo saldo");

        Assert.assertTrue(sbResumo.existeUmElementoPorTexto("Movimentação removida com sucesso!"));

        sbMenu.acessarHome();

        esperar(1000);
        sbHomePage.scroll(0.2, 0.9);

        Assert.assertEquals("-1000.00", sbHomePage.obterSaldoConta("Conta para saldo"));
    }
}
