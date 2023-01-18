package com.cydeo.tests.day9_javafaker_testbase_driverutil;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.util.Locale;

public class JavaFakerPractice {

    @Test
    public void test1() {

        // Create Faker object to reach methods
        Faker faker = new Faker();
        // Faker faker = new Faker(new Locale("pt"));

        System.out.println("faker.name().firstName() = " + faker.name().firstName());
        System.out.println("faker.name().lastName() = " + faker.name().lastName());
        System.out.println("faker.name().fullName() = " + faker.name().fullName());

        System.out.println("faker.address().streetAddress() = " + faker.address().streetAddress());
        System.out.println("faker.address().zipCode() = " + faker.address().zipCode());
        System.out.println("faker.address().cityName() = " + faker.address().cityName());

        System.out.println("faker.numerify(\"###-###-####\") = " + faker.numerify("###-###-####"));
        System.out.println("faker.numerify(\"123-###-##9\") = " + faker.numerify("123-###-###9"));

        System.out.println("faker.letterify(\"???-???\") = " + faker.letterify("???-????"));

        System.out.println("faker.bothify(\"##?#-??##-?#?#-###?\") = " + faker.bothify("##?#-??##-?#?#-###?"));

        System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard().replaceAll("-", " "));
        System.out.println("faker.finance().iban() = " + faker.finance().iban());

        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact().replaceAll("Chuck Norris", "Halid"));

        System.out.println("faker.pokemon().name() = " + faker.pokemon().name());

        System.out.println("faker.gameOfThrones().dragon() = " + faker.gameOfThrones().dragon());



    }
}
