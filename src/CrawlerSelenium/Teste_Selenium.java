/**
 * Teste de Crwler com Selenium para capturar resposta de uma busca dentro
 * do site no caso deste teste imobiliaria.
 *
 * @author patrixrs <patrix.pfr@gmail.com>
 */
package CrawlerSelenium;

import Classes.Imoveis;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Teste_Selenium {

    public static void main(String[] args) throws Exception {
        //variaveis da busca
        String strXpath;
        List<WebElement> buscaResultados;
        List<String> tdResultado1 = new ArrayList<>();
        List<String> tdResultado2 = new ArrayList<>();
        List<String> tdResultado3 = new ArrayList<>();
        List<Imoveis> Imovel;

        //localização do driver do chrmoe             
        System.setProperty("webdriver.chrome.driver", "C:\\crawler\\chromedriver.exe");

        //instancia o objeto do navegador via webdriver
        WebDriver driver = new ChromeDriver();

        //navegação, abre o site
        driver.get("https://www.zapimoveis.com.br/venda/imoveis/rs+porto-alegre/#{%22precomaximo%22:%222147483647%22,%22parametrosautosuggest%22:[{%22Bairro%22:%22%22,%22Zona%22:%22%22,%22Cidade%22:%22PORTO%20ALEGRE%22,%22Agrupamento%22:%22%22,%22Estado%22:%22RS%22}],%22pagina%22:%221%22,%22ordem%22:%22Relevancia%22,%22paginaOrigem%22:%22ResultadoBusca%22,%22semente%22:%22973895467%22,%22formato%22:%22Lista%22}");

        //maximizar a janela
        //driver.manage().window().maximize();
/*
        //insere os dados na busca e clicka em buscar
        driver.findElement(By.id("location")).sendKeys("Porto Alegre");
        driver.findElement(By.id("btnBuscar")).click();
        //sleep timer em 5 segundos
        Thread.sleep(5000);
*/
        //mudar as paginas da busca e capturar os resultados
        for (int i = 1; i < 5; i++) {            
            Actions act = new Actions(driver);
            WebElement troca = driver.findElement(By.xpath("//a[@class='btn-primario pull-right icone-seta-simples-dir']"));
            act.moveToElement(troca).click().perform();
            Thread.sleep(2000);

            //captura os dados
            buscaResultados = driver.findElements(By.xpath("//article[@class='minificha']"));
            for (WebElement res : buscaResultados) {
                tdResultado1.add(res.getText());
            }
        }
        //imprime o resultado do site zap
        imprimir(tdResultado1);
        
        //abre o site da foxter ja na pagina de porto alegre        
        driver.navigate().to("https://www.foxterciaimobiliaria.com.br/imoveis/porto-alegre/");
        Thread.sleep(1000);
        
        //captura os dados
        for (int i = 1; i < 6; i++) {
            buscaResultados = driver.findElements(By.xpath("//*[contains(@class,'smallBanner')]"));
            for (WebElement res : buscaResultados) {
                tdResultado2.add(res.getText());
            }
            Actions act1 = new Actions(driver);
            Thread.sleep(1000);
            //desliza a pagina para baixo      
            act1.sendKeys(Keys.PAGE_DOWN).perform();
        }
        //imprime o resultado do site foxter
        imprimir(tdResultado2);
/*
        //abre o site da lopes ja na pagina de porto alegre       
        driver.navigate().to("https://www.lopes.com.br/busca/comprar-prontos/todos-porto_alegre-rs/todos");

        //mudar as paginas da busca e capturar os resultados
        for (int i = 1; i < 4; i++) {
            //captura os dados
            buscaResultados = driver.findElements(By.xpath("//*[contains(@class, 'infos')]"));
            for (WebElement res : buscaResultados) {
                tdResultado3.add(res.getText());
            }
            Actions act2 = new Actions(driver);
            WebElement troca = driver.findElement(By.linkText("Próximo"));
            act2.moveToElement(troca).click().perform();
            Thread.sleep(2000);
        }
*/
        //imprime o resultado do site lopes
        imprimir(tdResultado3);
         
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
