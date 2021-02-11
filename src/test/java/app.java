
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class app {
	
	private WebDriver driver;
	private By botonRegistro= By.linkText("Contáctenos");
	private By nombre  =By.name("your-name");
	private By email   =By.name("your-email");
	private By asunto= By.name("your-subject");
	private By noSoyUnBot =By.name("captcha-636");
	private By enviar =By.xpath(".//*[@value='Enviar']");	
	private By emailValido=By.xpath("/html/body/div[1]/section/div[1]/div/main/article/div/div[1]/div[1]/div/div/form/p[2]/span/span");
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedrive/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		System.out.print("Ingreso a la pagina de la empresa \n");
		driver.get("https://www.consultoriaglobal.com.ar/cgweb/");
	}
	@Test
	public void LlenoFormulario() {
		driver.findElement(botonRegistro).click();
		try {
			Thread.sleep(2000);
			if(driver.findElement(botonRegistro).isDisplayed()) {
				System.out.print("Ingreso a la seccion contacto \n");
				driver.findElement(nombre).sendKeys("nico");
				System.out.print("Ingreso un nombre \n");
				driver.findElement(email).sendKeys("jkrabgakjbs");//email no valido
				System.out.print("Ingreso un email invalido \n");
				driver.findElement(asunto).sendKeys("buenas tardes");
				System.out.print("Ingreso un asunto \n");
				driver.findElement(noSoyUnBot).sendKeys("4s4e");//supongo que pasa el captcha
				System.out.print("Completo la prueba captcha\n");
				driver.findElement(enviar).click();
				System.out.print("Apreto el boton de enviar\n");
				Thread.sleep(3000);
				System.out.print("Espero a que la pagina responda mi solicitud\n");
				System.out.print("Busco si el correo ingresado es correcto\n");
				try {
					if(driver.findElement(emailValido).isDisplayed()) 
						
						System.out.print("error al ingresar email");				
				}catch (Exception e){
					System.out.print("correo correcto");
					
				}
			}else {
				System.out.print("No se pudo hacer la tarea");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}	 
	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}
	
}
