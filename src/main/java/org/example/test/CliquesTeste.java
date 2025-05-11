package org.example.test;

import org.example.core.BaseTest;
import org.example.page.CliquesPage;
import org.example.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CliquesTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private CliquesPage cliques = new CliquesPage();

    @Before
    public void before() {
        menu.acessarCliques();
    }

    @Test
    public void deveRealizarCliqueLongo() {
        cliques.cliqueLongo();

        Assert.assertEquals("Clique Longo", cliques.obterTextoCampo());
    }

    @Test
    public void deveRealizarCliqueDuplo() {
        cliques.clicarPorTexto("Clique duplo");
        cliques.clicarPorTexto("Clique duplo");

        Assert.assertEquals("Duplo Clique", cliques.obterTextoCampo());
    }
}
