package Teste;


import Metodos.Metodos;
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

public class PreecherFormulario extends Metodos {


    @Before
    public void setUp() throws Exception{
        iniciarTeste("https://automacaocombatista.herokuapp.com/treinamento/home");


    }
    @After
    public void tearDown() throws Exception{

    }
    @Test
    public void test(){

        clicar(By.xpath("/html/body/div[2]/div[1]/ul/li[1]/a"));
        clicar(By.xpath("/html/body/div[2]/div[1]/ul/li[1]/div/ul/li[1]/a"));

        escrever(By.name("user[name]"), "yago");
        escrever(By.name("user[lastname]"), "bramovit");
        escrever(By.name("user[email]"), "brabo@gmail.com");
        escrever(By.name("user[address]"), "Rua dos gato");
        escrever(By.name("user[university]"), "IFCE");
        escrever(By.name("user[profile]"), "Estudante");
        escrever(By.name("user[gender]"), "macho");
        escrever(By.name("user[age]"), "40");


        validarAtributo(By.name("user[name]"), "value", "yago");
        validarAtributo(By.name("user[lastname]"), "value", "bramovit");
        validarAtributo(By.name("user[email]"), "value", "brabo@gmail.com");
        validarAtributo(By.name("user[address]"), "value", "Rua dos gato");
        validarAtributo(By.name("user[university]"), "value", "IFCE");
        validarAtributo(By.name("user[profile]"), "value", "Estudante");
        validarAtributo(By.name("user[gender]"), "value", "macho");
        validarAtributo(By.name("user[age]"), "value", "40");

        clicar(By.xpath("//*[@id=\"new_user\"]/div[5]/div/div"));

        validarTexto(By.id("notice"), "Usuário Criado com sucesso");

        validarTexto(By.xpath("/html/body/div[2]/div[2]/div[3]/div/p[1]"), "Nome: yago");
        validarTexto(By.xpath("/html/body/div[2]/div[2]/div[3]/div/p[2]"), "Ultimo Nome: bramovit");
        validarTexto(By.xpath("/html/body/div[2]/div[2]/div[3]/div/p[3]"), "Email: brabo@gmail.com");
        validarTexto(By.xpath("/html/body/div[2]/div[2]/div[3]/div/p[4]"), "Univercidade: IFCE");
        validarTexto(By.xpath("/html/body/div[2]/div[2]/div[3]/div/p[5]"), "Gênero: macho");
        validarTexto(By.xpath("/html/body/div[2]/div[2]/div[3]/div/p[6]"), "Profissão: Estudante");
        validarTexto(By.xpath("/html/body/div[2]/div[2]/div[3]/div/p[7]"), "Idade: 40");
        validarTexto(By.xpath("/html/body/div[2]/div[2]/div[3]/div/p[8]"), "Address: Rua dos gato");

    }

}
