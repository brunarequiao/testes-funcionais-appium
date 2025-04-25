package org.example.core;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class BaseTest {

    @Rule
    public TestName testName = new TestName();

    @AfterClass
    public static void finalizaClasse() {
        DriverFactory.killDriver();
    }

    @After
    public void tearDown() throws IOException {
        gerarScreenShot();
        DriverFactory.getDriver().resetApp();
    }

    public void gerarScreenShot() throws IOException {
        File imagem = (File) DriverFactory.getDriver().getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(imagem, new File("target/screenshots/"+testName.getMethodName()+".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
