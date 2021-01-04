package ru.netology.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.DataClass.getFakerInfo;

public class AppCardDeliveryTest {


    @BeforeAll
    static void setUp() {

        Configuration.startMaximized = true;
        Configuration.browser = "firefox";
    }

    @Test
    public void shouldRegistered() {

        LocalDate dayDeliveryCard = LocalDate.now().plusDays(3);
        LocalDate dayDeliveryCardPlusSevenDays = LocalDate.now().plusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");


        open("http://localhost:9999/");
        element("[data-test-id='city'] .input__control").setValue(getFakerInfo("ru").getCity());
        element("[data-test-id=date] [placeholder=\"Дата встречи\"]").
                sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE, dayDeliveryCard.format(formatter));
        element("[data-test-id='name'] .input__control").setValue(getFakerInfo("ru").getName() + " " + getFakerInfo("ru").getSurName());
        element("[data-test-id='phone'] .input__control").setValue(getFakerInfo("ru").getTelephone());
        element(".checkbox__box").click();
        element(".button__text").click();
        element(".notification__content").
                waitUntil(Condition.visible,10000).shouldHave(Condition.text(dayDeliveryCard.format(formatter)));
        element("[data-test-id=date] [placeholder=\"Дата встречи\"]").
                sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE, dayDeliveryCardPlusSevenDays.format(formatter));
        element(".button__text").click();
        element("button.button_size_s .button__text").click();
        element(".notification__content").waitUntil(Condition.visible, 10000).
                shouldHave(Condition.text(dayDeliveryCardPlusSevenDays.format(formatter)));
    }



}
