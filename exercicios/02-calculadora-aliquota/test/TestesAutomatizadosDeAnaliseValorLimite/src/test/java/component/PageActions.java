package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageActions {
    private WebDriver driver;
    private final String PATH_DRIVER = System.getProperty("user.dir") +"\\drivers\\chromedriver.exe";
    private final String NOME_PROPRIEDADE = "webdriver.chrome.driver";
    private final String SITE = "http://etec199-2021-kaiquesouzasantos.epizy.com/7_qts/exercicios/01/index.html";

    public PageActions() {
        System.setProperty(NOME_PROPRIEDADE, PATH_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(SITE);
    }

    public String retornaAliquota(String nome, String rendimento, String cpf) {
        try {
            insereValor("txtNome", nome);
            insereValor("numberRendimentos", rendimento);
            insereValor("txtCPF", cpf);

            clicaBotao("btnCalcular");

            ativaMouseOver("body");
        } catch (Exception ignored){}

        return driver.findElement(By.id("txtAliquota")).getAttribute("value");
    }

    public void fechaJanela() {
        driver.quit();
    }

    private void insereValor(String name, String valor) {
        driver
                .findElement(By.name(name))
                .sendKeys(valor);
    }

    private void clicaBotao(String name) {
        driver
                .findElement(By.id(name))
                .click();
    }

    private void ativaMouseOver(String name) {
        new Actions(driver).moveToElement(
                esperaVisibilidadeElemento(By.tagName(name))
        ).perform();
    }

    public WebElement esperaVisibilidadeElemento(By name) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(name));
    }
}
