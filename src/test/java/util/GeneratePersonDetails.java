package util;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;


public class GeneratePersonDetails {

    private static Faker faker = new Faker();

    public static String generateFirstName(){
        // String firstName = "";
        //return firstName;
        return faker.name().firstName();

    }

    public static String generateLastName(){
       // String lastName = "";
        //return lastName;
        return faker.name().lastName();
    }

    public static String generateEmail(){
        String email = RandomStringUtils.randomAlphanumeric(4)+ "@yopmail.com";
        return email;
      //  return "email"+ RandomStringUtils.randomNumeric(4)+"@yopmail.com";

    }

    public static String generatePhoneNumber(){
       // Integer phoneNo = 0;
       // return phoneNo;
        return "9"+RandomStringUtils.randomNumeric(9);
    }

}

/*

    public static String generateFirstName(){
        return faker.name().firstName();
    }

    public static String generateLastName(){
        return faker.name().lastName();
    }

    public static String generateEmail(){
        return "Testemail"+RandomStringUtils.randomNumeric(4)+"@yopmail.com";
    }

    public static String generatePhoneNumber(){
        return "9"+RandomStringUtils.randomNumeric(9);
    }


 */