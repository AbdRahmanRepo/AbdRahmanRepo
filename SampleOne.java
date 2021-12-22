

public class SampleOne {
	public static WebDriver driver;
	SoftAssert soft = new SoftAssert();
	
	
	@BeforeClass
	private void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.co.in/");

	}
	
	@Test(priority = 0)
	private void Login() throws Exception {
		driver.navigate().to("https://cp-management.bricknbolt.com/contractors");
		WebElement googleBtn = driver.findElement(By.xpath("//button[text()='Google']"));
		googleBtn.click();  
		
		try {	
			
			Set<String> allWindow = driver.getWindowHandles();
			System.out.println(allWindow);
			Iterator<String> iterator = allWindow.iterator();
			iterator.next();
			String signIn = iterator.next();
			driver.switchTo().window(signIn);
			Thread.sleep(5000);
			String title = driver.getTitle();
			System.out.println(title);
			
			WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
			email.sendKeys("ops.automation");
			
			WebElement nxtBtn = driver.findElement(By.xpath("//span[text()='Next']"));
			nxtBtn.click();
			
			WebElement psw = driver.findElement(By.xpath("//input[@name='password']"));
			psw.sendKeys("bricknbolt");
			
			
			WebElement nxtBtn2 = driver.findElement(By.xpath("//span[text()='Next']"));
			nxtBtn2.click();
			
		//	String bnbPage = iterator.next();
		//	System.out.println(bnbPage);
			driver.getTitle();
			String we = driver.getWindowHandle();
			System.out.println(we);
			Set<String> w = driver.getWindowHandles();
			System.out.println(w);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test(priority = 1)
	private void addContractor() throws Exception {
		
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		String SignIn = driver.getWindowHandle();
		Set<String> all = driver.getWindowHandles();
		for (String window : all) {
			if(!SignIn.equals(window)) {
				driver.switchTo().window(window);
				System.out.println(window);
				System.out.println(driver.getTitle());
			}
			
		}
//		
		WebElement addBtn = driver.findElement(By.cssSelector("#__next > section > section > div.ant-page-header > div > span.ant-page-header-heading-extra > button"));
		addBtn.click();
	
		WebElement name = driver.findElement(By.id("contractor-form_name"));
		name.sendKeys("AbdulRahman");
		soft.assertNotNull(name, "Username not entered");
		
		WebElement email = driver.findElement(By.id("contractor-form_email"));
		email.sendKeys("Abdulrahman123@gmail.com");
		
		WebElement phnNum = driver.findElement(By.id("contractor-form_phone"));
		phnNum.sendKeys("9876543210");
		
		WebElement city = driver.findElement(By.xpath("//li[normalize-space()='Bengaluru']"));
		city.click();
		
		//radio button
		driver.findElement(By.xpath("//div[@id='contractor-form_gender']//input[1]")).click();
		
		//submit btn
		driver.findElement(By.xpath("//button[@class='ant-btn button ant-btn-primary']")).click();
		
		
		

		
		
		
		
		
		
		
	}
	
	
	
//	@AfterClass
//	private void tearDown() {
//		
//		driver.close();
//		driver.quit();
//
//	}

}
}
