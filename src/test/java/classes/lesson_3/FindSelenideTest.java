package classes.lesson_3;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FindSelenideTest {

    @Test
    void shouldFindSelenideInGitHub() {
        /* Открыть github
        * Кликнуть на элемент поиска
        * Ввести "selenide"
        * Нажать enter
        * Выбрать первый найденный проект из списка
        * Проверка - в заголовке встречается selenide/selenide */

        open("https://github.com/");

        $x("//button[@data-target='qbsearch-input.inputButton']").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        $x("//a[@class='prc-Link-Link-85e08']").click();

        $x("//div[@class=' d-flex flex-wrap flex-items-center wb-break-word f3 text-normal']").shouldHave(text("selenide / selenide"));


//        sleep(2000);
    }

}
