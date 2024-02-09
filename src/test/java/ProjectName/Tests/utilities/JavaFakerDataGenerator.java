package ProjectName.Tests.utilities;

import com.github.javafaker.Faker;

public class JavaFakerDataGenerator {

    public static void main(String[] args) {
        Faker faker = new Faker();

        for (int i=0; i<300; i++) {
            System.out.println(faker.name().firstName() + ", " + faker.name().lastName() + ", " + faker.address().city() + ", " + faker.address().zipCode() + ", " + faker.numerify("###-####-###")+", " + faker.country().name());

        }
    }

}
