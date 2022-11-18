package Teste;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.page.Page;

import java.util.concurrent.TimeUnit;

public class PreecherFormulario {

    WebDriver navegador;

    @Before
    public void setUp() throws Exception{
        WebDriverManager.chromedriver().setup();
        navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.get("https://automacaocombatista.herokuapp.com/treinamento/home");
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
    @After
    public void tearDown() throws Exception{

    }
    @Test
    public void test(){
        navegador.findElement(By.xpath("/html/body/div[2]/div[1]/ul/li[1]/a")).click();
        navegador.findElement(By.xpath("/html/body/div[2]/div[1]/ul/li[1]/div/ul/li[1]/a")).click();

        navegador.findElement(By.name("user[name]")).sendKeys("yago");
        navegador.findElement(By.name("user[lastname]")).sendKeys("bramovit");
        navegador.findElement(By.name("user[email]")).sendKeys("brabo@gmail.com");
        navegador.findElement(By.name("user[address]")).sendKeys("Rua dos gato");
        navegador.findElement(By.name("user[university]")).sendKeys("IFCE");
        navegador.findElement(By.name("user[profile]")).sendKeys("Estudante");
        navegador.findElement(By.name("user[gender]")).sendKeys("macho");
        navegador.findElement(By.name("user[age]")).sendKeys("40");

        String nomeRetornado = navegador.findElement(By.name("user[name]")).getAttribute("value");
        String sobrenomeRetornado =  navegador.findElement(By.name("user[lastname]")).getAttribute("value");
        String emailRetornado =  navegador.findElement(By.name("user[email]")).getAttribute("value");
        String endercoRetonado = navegador.findElement(By.name("user[address]")).getAttribute("value");
        String univercidadeRetornado = navegador.findElement(By.name("user[university]")).getAttribute("value");
        String profissaoRetornado = navegador.findElement(By.name("user[profile]")).getAttribute("value");
        String generoRetornado = navegador.findElement(By.name("user[gender]")).getAttribute("value");
        String idadeRetornado =  navegador.findElement(By.name("user[age]")).getAttribute("value");

        //validando se os valores inseridos retornam igual
        Assertions.assertEquals("yago" ,nomeRetornado);
        Assertions.assertEquals("bramovit" ,sobrenomeRetornado);
        Assertions.assertEquals("brabo@gmail.com" ,emailRetornado);
        Assertions.assertEquals("Rua dos gato" ,endercoRetonado);
        Assertions.assertEquals("IFCE" ,univercidadeRetornado);
        Assertions.assertEquals("Estudante" ,profissaoRetornado);
        Assertions.assertEquals("macho" ,generoRetornado);
        Assertions.assertEquals("40" ,idadeRetornado);

        navegador.findElement(By.xpath("//*[@id=\"new_user\"]/div[5]/div/div")).click();

        String msgSucesso = navegador.findElement(By.id("notice")).getText();
        Assertions.assertEquals("Usuário Criado com sucesso", msgSucesso);

        String infoNome = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/p[1]")).getText();
        String infoUltimoNome = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/p[2]")).getText();
        String infoEmail = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/p[3]")).getText();
        String infoUnivercidade = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/p[4]")).getText();
        String infoGenero = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/p[5]")).getText();
        String infoProfissao = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/p[6]")).getText();
        String infoIdade = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/p[7]")).getText();
        String infoEnd = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/p[8]")).getText();

        Assertions.assertEquals("Nome: yago", infoNome);
        Assertions.assertEquals("Ultimo Nome: bramovit", infoUltimoNome);
        Assertions.assertEquals("Email: brabo@gmail.com", infoEmail);
        Assertions.assertEquals("Univercidade: IFCE", infoUnivercidade);
        Assertions.assertEquals("Gênero: macho", infoGenero);
        Assertions.assertEquals("Profissão: Estudante", infoProfissao);
        Assertions.assertEquals("Idade: 40", infoIdade);
        Assertions.assertEquals("Address: Rua dos gato", infoEnd);
    }

}
