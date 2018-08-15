/**
 * Classe de teste isolado de um formulario de investimento do sicredi
 *
 * @author patrixrs <patrix.pfr@gmail.com>
 */
package CrawlerSelenium;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Teste_Info {

    public static void main(String[] args) throws Exception {
        //variaveis da busca
        String strXpath;

        //localização do driver do chrmoe             
        System.setProperty("webdriver.chrome.driver", "C:\\crawler\\chromedriver.exe");

        //instancia o objeto do navegador via webdriver
        WebDriver driver = new ChromeDriver();

        //navegação, abre o site do simulador de investimentos do sicredi
        driver.get("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-sicredinvest/");

        //maximizar a janela
        //driver.manage().window().maximize();
        
        //preenche os campos do formulario
        strXpath = "//button";
        driver.findElement(By.name("valorAplicar")).sendKeys("500000");  //investimento inicial
        driver.findElement(By.name("valorInvestir")).sendKeys("50000");  //valor mensal
        driver.findElement(By.name("tempo")).sendKeys("24"); //meses
        driver.findElement(By.xpath(strXpath)).click();
        Thread.sleep(2000);

        WebElement tdResultado1 = driver.findElement(By.className("formularioBloco"));
        System.out.println(tdResultado1.getText());

        //fecha o navegador
        driver.close();
    }

    public static void imprimir(List<String> result) {
        int i = 0;
        for (String cadaResultado : result) {
            System.out.println("[Endereco " + i + "]");
            System.out.println(cadaResultado + "\n");
            i++;
        }
    }
}
