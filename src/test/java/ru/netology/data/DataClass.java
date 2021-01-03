package ru.netology.data;


import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public class DataClass {
    private DataClass() { }

    @Value
    public static class AuthInfo {
        private final String city;
        private final String telephone;
        private final String name;
        private final String surName;
    }

    public static AuthInfo getFakerInfo() {
        Faker faker = new Faker(new Locale("ru"));
        return new AuthInfo(faker.address().cityName(),faker.phoneNumber().phoneNumber(),faker.name().firstName(),faker.name().lastName());
    }

//    public static AuthInfo getOtherAuthInfo(AuthInfo original) {
//        return new AuthInfo("petya", "123qwerty");
//    }

//    @Value
//    public static class VerificationCode {
//        private String code;
//    }
//
//    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
//        return new VerificationCode("12345");
//    }
}
