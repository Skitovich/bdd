package ru.netology.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.data.DataGenerator;

import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.DataGenerator.generateAuthInfo;
import static ru.netology.data.DataGenerator.generateDate;

public class AppCardDeliveryTest {




    @BeforeAll
    static void setUp() {
        Configuration.browser = "firefox";
        Configuration.startMaximized = true;

    }

    @Test
    public void shouldRegistered() {
        DataGenerator.AuthInfo authInfo = generateAuthInfo("ru");
        int daysAfterToday = 3;

        open("http://localhost:9999/");
        element("[data-test-id='city'] .input__control").setValue(authInfo.getCity());
        element("[data-test-id=date] [placeholder=\"Дата встречи\"]").
                sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE, generateDate(daysAfterToday));
        element("[data-test-id='name'] .input__control").setValue(authInfo.getName());
        element("[data-test-id='phone'] .input__control").setValue(authInfo.getTelephone());
        element(".checkbox__box").click();
        element(".button__text").click();
        element("[data-test-id=date] [placeholder=\"Дата встречи\"]").shouldHave(Condition.visible);
        element(".button__text").click();
        element("button.button_size_s .button__text").click();
        element(".notification__content").shouldHave(Condition.visible);
    }


}
