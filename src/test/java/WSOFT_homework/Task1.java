package WSOFT_homework;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.*;

public class Task1 {

    @Test
    void ShouldGetAllInputWithTypeText() {
        open("https://wiki.wsoft.ru/");

        $$x("//input[@type='text']");

    }

    @Test
    void ShouldGetSecondLink() {
        open("https://wiki.wsoft.ru/");

        $x("//a[@id='space-menu-link']").click();
        $x("//a[@id='view-all-spaces-link']").click();

    }


}
