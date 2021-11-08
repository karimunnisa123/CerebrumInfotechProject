package SeleniumDemos;

import com.github.javafaker.Faker;
import org.apache.commons.lang.RandomStringUtils;

import java.util.Random;

public class Demo {
   public static void main(String args[]) throws InterruptedException {
    /*   WebDriverManager.chromedriver().setup();
       WebDriver driver=new ChromeDriver();
       driver.get("http://stgcerb.cerebruminfotech.com:9069/admin/");
       driver.manage().window().maximize();
       driver.findElement(By.id("email")).sendKeys("superadmin@yopmail.com");
       driver.findElement(By.id("password")).sendKeys("123456");
       //driver.findElement(By.xpath("//*[@id='loginForm'']/button")).click();
       driver.findElement(By.cssSelector("button[type='submit']")).click();
      // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       System.out.println(driver.getTitle()); //output is: Cere Consult
       Thread.sleep(2000);
   WebElement dashboardText=driver.findElement(By.cssSelector(".page-heading h3"));
   System.out.println(dashboardText);
       //WebElement dashboardText1=driver.findElement(By.xpath("//div[@class='page-heading h3']"));
       //System.out.println(dashboardText1);
      // WebElement dashboardText2=driver.findElement(By.xpath("//div[@class='page-heading']"));
       //System.out.println(dashboardText2);
      // driver.findElement(By.cssSelector(("div[class='toastify on success toastify-center toastify-top']"))).getText();
      // driver.findElement(By.cssSelector("div[class='toastify on error toastify-center toastify-top']")).getText();

  */


    //Generating random numbers by using Random class
       Random rd=new Random();
       int rdnum;
       rdnum=rd.nextInt(10); //it will generate random integers(nextInt) from 0 to 9,it will consider any number
       System.out.println("random number is: " + rdnum);

       //generating 10 digit phone number
       String st[]=new String[10];
       System.out.print("The phone number is:");
       for(int i=0;i<10;i++){
           rdnum=rd.nextInt(10);
           st[i]=Integer.toString(rdnum);
           System.out.print(st[i] );//0]+st[1]+st[2]+st[3]+st[4]+st[5]+st[6]+st[7]+st[8]+st[9]);
       }
        System.out.println();

       //generating random emails by using apache commmons-lang api
       String randomEmail= RandomStringUtils.randomAlphabetic(8);
       String email=randomEmail+"@gmail.com";
       System.out.println(email);

       //generating random decimals using Random class
       double rand_dbl=rd.nextDouble();//here no need to specify range
       System.out.println(rand_dbl);

       //generating random integers using Random class
       int rand_int=rd.nextInt(10); //here need to specify range, within 1 to 10 it will generate any one number randomly
       System.out.println(rand_int);

       //using Math class and random method in that
       System.out.println(Math.random()); //it will generate decimal by default

       //by using apache commons-lang API
       String randNum=RandomStringUtils.randomNumeric(5);
       System.out.println(randNum);

       String randString=RandomStringUtils.randomAlphabetic(5);
       System.out.println(randString);

       String randAlpaNum=RandomStringUtils.randomAlphanumeric(8);
       System.out.println(randAlpaNum);


       //generating firstname using Faker
       Faker faker = new Faker();
      System.out.println(faker.name().firstName());
      System.out.println(faker.name().lastName());
   }





}
