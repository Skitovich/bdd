package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.Value;

import java.util.Locale;


public class DataClass {
    private DataClass() { }
    @Data
    @Value
    public static class AuthInfo {
        String city;
        String telephone;
        String name;
        String surName;
    }

    public static AuthInfo getFakerInfo(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return new AuthInfo(faker.address().cityName().replace("Сочи","Краснодар"),
                faker.phoneNumber().phoneNumber(),
                faker.name().firstName().replace("ё","е"),
                faker.name().lastName().replace("ё","е"));
    }
}
