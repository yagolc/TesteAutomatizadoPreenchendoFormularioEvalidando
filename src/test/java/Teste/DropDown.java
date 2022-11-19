package Teste;

import Metodos.Metodos;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class DropDown extends Metodos {

    @Before
    public void setUp() throws Exception{
        iniciarTeste("https://automacaocombatista.herokuapp.com/buscaelementos/dropdowneselect");

    }
    @After
    public void tearDown() throws Exception {

    }
    @Test
    public void test(){
        clicar(By.xpath("/html/body/div[2]/div[2]/div/div[3]/div[1]/div/a"));
        validarElementoVisivel(By.id("dropdown1"));
        validarElementoVisivel(By.id("dropdown2"));
        validarElementoVisivel(By.id("dropdown3"));


    }
}
