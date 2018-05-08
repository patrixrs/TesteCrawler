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

/**
 *
 * @author patrixrs <patrix.pfr@gmail.com>
 */
public class Teste_Selenium {

    public static void main(String[] args) throws Exception {
        //variaveis da busca
        String strXpath;
        List<WebElement> buscaResultados;
        List<String> tdResultado1 = new ArrayList<>();
        List<String> tdResultado2 = new ArrayList<>();
        List<Imoveis> Imovel;

        //localização do driver do chrmoe             
        System.setProperty("webdriver.chrome.driver", "C:\\crawler\\chromedriver.exe");

        //instancia o objeto do navegador via webdriver
        WebDriver driver = new ChromeDriver();

        //navegação, abre o site
        driver.get("https://www.zapimoveis.com.br/");

        //maximizar a janela
        driver.manage().window().maximize();

        //insere os dados na busca e clicka em buscar
        driver.findElement(By.id("location")).sendKeys("Porto Alegre");
        driver.findElement(By.id("btnBuscar")).click();

        //sleep timer em 5 segundos
        Thread.sleep(5000);

        //mudar as paginas da busca e capturar os resultados
        for (int i = 1; i < 3; i++) {
            if (i > 1) {
                //strXpath = "//input[@name='txtPaginacao']";
                driver.findElement(By.id("proximaPagina")).click();
                Thread.sleep(2000);
            }
            /*Imovel = new ArrayList<>();
            Imovel.add(new Imoveis("","","","","")); */
            //captura os dados
            buscaResultados = driver.findElements(By.xpath("//div[@class='card-view']/article/section/a/h2"));
            for (WebElement res : buscaResultados) {
                tdResultado1.add(res.getText());
            }
        }
        //imprime o resultado do site zap
        imprimir(tdResultado1);
        
        
        //abre o site da foxter ja na pagina de porto alegre       
        driver.navigate().to("https://www.foxterciaimobiliaria.com.br/imoveis/porto-alegre/");
        
        // Simula o pressionamento da tecla "DOWN" do teclado        
        Actions actions = new Actions(driver);
        //desliza a pagina para baixo        
        for (int i = 1; i < 100; i++) {
            /* if (i > 1) {
                actions.sendKeys(Keys.DOWN).perform();
                Thread.sleep(2000);
            } */
            //captura os dados
            buscaResultados = driver.findElements(By.xpath("//*[@id=\"imoveis-container\"]/div/div["+i+"]/a/div/div/div[3]"));
            for (WebElement res : buscaResultados) {
                tdResultado2.add(res.getText());
            }
            actions.sendKeys(Keys.DOWN).perform();
        }
        //imprime o resultado do site foxter
        imprimir(tdResultado2);

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
