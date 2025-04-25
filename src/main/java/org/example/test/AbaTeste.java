package org.example.test;

import org.example.core.BaseTest;
import org.example.page.AbaPage;
import org.example.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class AbaTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AbaPage abaPage = new AbaPage();

    @Test
    public void deveInteragirComAbas() {

        menu.acessarAbas();

        Assert.assertTrue(abaPage.isAba1());

        abaPage.selecionarAba2();

        Assert.assertTrue(abaPage.isAba2());
    }
}
