package Teste;

import Metodos.Metodos;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RadioCheckBox extends Metodos {

    @Before
    public void setUp() throws Exception{
    iniciarTeste("https://automacaocombatista.herokuapp.com/buscaelementos/radioecheckbox");

    }
    @After
    public void tearDown() throws Exception {

    }
    @Test
    public void test(){
        clicar(By.xpath("/html/body/div[2]/div[2]/div[3]/div[1]/form/p[1]/label"));
        validarCheckBox(By.id("red"));

        clicar(By.xpath("/html/body/div[2]/div[2]/div[3]/div[1]/form/p[2]/label"));
        validarCheckBox(By.id("blue"));

        validarCheckBox(By.id("yellow"));
    }
}
