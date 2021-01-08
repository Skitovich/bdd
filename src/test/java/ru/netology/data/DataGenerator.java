package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;


public class DataGenerator {
    private DataGenerator() {
    }

    public static String getValidCity() {
        Random random = new Random();
        String[] validCity = {"Москва", "Краснодар", "Санкт-Петербург", "Казань", "Севастополь"};
        return validCity[random.nextInt(validCity.length - 1)];
    }

    public static AuthInfo generateAuthInfo(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String name = faker.name().firstName().
                replace("ё", "е") + " " + faker.name().lastName().replace("ё", "е");
        return new AuthInfo(getValidCity(), faker.phoneNumber().phoneNumber(), name);
    }

    public static String generateDate(int shiftFromCurrentDay) {
        LocalDate dayDelivery = LocalDate.now().plusDays(shiftFromCurrentDay);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return dayDelivery.format(formatter);
    }


    @Value
    public static class AuthInfo {
        String city;
        String telephone;
        String name;
    }
}



