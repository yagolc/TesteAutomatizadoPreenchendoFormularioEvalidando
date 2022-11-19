package Metodos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Metodos {
    WebDriver navegador;
    public void iniciarTeste(String site){
        WebDriverManager.chromedriver().setup();
        navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.get(site);
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void clicar(By elemento){
        navegador.findElement(elemento).click();
    }

    public void escrever(By elemento, String texto){
        navegador.findElement(elemento).sendKeys(texto);
    }
    public void validarTexto(By elemento, String textoEsperado){
        String texto = navegador.findElement(elemento).getText();
        Assert.assertEquals(textoEsperado, texto);
    }

    public void validarAtributo(By elemento, String atributo, String atributoEsperado){
        String atributoRecebido = navegador.findElement(elemento).getAttribute(atributo);
        Assert.assertEquals(atributoEsperado, atributoRecebido);
    }
    public void apagarTexto(By elemento){
        navegador.findElement(elemento).clear();
    }
    public void validarCheckBox(By elemento){
        boolean elemente = navegador.findElement(elemento).isSelected();
        Assert.assertTrue(elemente);
    }
    public void validarElementoVisivel(By elemento){
        boolean element = navegador.findElement(elemento).isDisplayed();
        Assert.assertTrue(element);
    }
}
