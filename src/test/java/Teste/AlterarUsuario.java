package Teste;

import Metodos.Metodos;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class AlterarUsuario extends Metodos {

    @Before
    public void setUp() throws Exception{
    iniciarTeste("https://automacaocombatista.herokuapp.com/users");

    }
    @After
    public void tearDown() throws Exception{


    }
    @Test
    public void test(){
        clicar(By.xpath("/html/body/div[3]/div/table/tbody/tr[1]/td[10]/a"));

        apagarTexto(By.name("user[email]"));
        escrever(By.name("user[email]"), "Novo@gmail.com");
        apagarTexto(By.name("user[address]"));
        escrever(By.name("user[address]"), "Rua dos bonitos");

        validarAtributo(By.name("user[email]"), "value", "Novo@gmail.com");
        validarAtributo(By.name("user[address]"), "value", "Rua dos bonitos");
        clicar(By.name("commit"));

        validarTexto(By.id("notice"), "Seu Usuário foi Atualizado!");
        validarTexto(By.xpath("/html/body/div[2]/div[2]/div[3]/div/p[3]"), "Email: Novo@gmail.com");
        validarTexto(By.xpath("/html/body/div[2]/div[2]/div[3]/div/p[8]"), "Address: Rua dos bonitos");
    }
}
