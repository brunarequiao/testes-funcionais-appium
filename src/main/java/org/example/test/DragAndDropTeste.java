package org.example.test;

import org.example.core.BaseTest;
import org.example.page.DragAndDropPage;
import org.example.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class DragAndDropTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private DragAndDropPage dragAndDrop = new DragAndDropPage();

    private String[] estadoInicial = new String[]{"Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "qualquer local desejado"};
    private String[] estadoIntermediario = new String[]{"é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "Esta", "qualquer local desejado"};
    private String[] estadoFinal = new String[]{"Faça um clique longo,", "é uma lista", "Drag em Drop!", "e arraste para", "Esta", "qualquer local desejado"};


    @Test
    public void deveEfeturDragAndDrop() {
        menu.acessarDragAndDrop();

        esperar(1000);
        Assert.assertArrayEquals(estadoInicial, dragAndDrop.obterLista());

        dragAndDrop.arrastar("Esta", "e arraste para");
        Assert.assertArrayEquals(estadoIntermediario, dragAndDrop.obterLista());

        dragAndDrop.arrastar("Faça um clique longo", "é uma lista");
        Assert.assertArrayEquals(estadoFinal, dragAndDrop.obterLista());
    }
}
