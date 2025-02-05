package homework;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class First_homework {

    @BeforeAll
    static void setup() {
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillPracticeForm() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Name");
        $("#lastName").setValue("LastName");
        $("#userEmail").setValue("ex@ex.com");
        $x("//label[@for='gender-radio-2']").click();
        $("#userNumber").setValue("7777777777");

        // Клик по полю с датой
        $("#dateOfBirthInput").click();
        // Выбор года
        $(".react-datepicker-popper").should(appear);
        $(".react-datepicker__month-select").click();
        $x("//option[@value='8']").click();

        // Выбор месяца
        $(".react-datepicker__year-select").click();
        $x("//option[@value='1965']").click();
        $("#subjects-label").click();

        // Subjects
        $("#subjectsInput").setValue("English").pressEnter();
        $("#subjectsInput").setValue("Arts").pressEnter();

        // checkbox
        $x("//label[@for='hobbies-checkbox-3']").scrollTo().click();

        // Выбор файла
        $("#uploadPicture").uploadFile(new File("src/test/resources/123.txt"));

        // Адресс
        $x("//textarea[@id='currentAddress']").setValue("Адресс");

        // Штат и год
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Gurgaon").pressEnter();

        // Submit
        $("#submit").click();

        // Проверка, что появилось модульное окно
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        // Нажатие на кнопку Close
        $("#closeLargeModal").scrollIntoView(true).click();
    }

}
