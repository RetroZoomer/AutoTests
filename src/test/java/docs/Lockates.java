package docs;

import com.codeborne.selenide.DownloadOptions;
import com.codeborne.selenide.FileDownloadMode;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class Lockates {

    void selector_examples() {
        $x("//input[@id='email']").setValue("some@email.ru");   //XPATH
        $("input[id='email']").setValue("some@email.ru"); // css selector
        $$("#ul-something"); // Берет не первый, а все элементы, которые есть на странице

        $("div", 2); // Найдет третий элемент

        $(byText("full text")); // Поиск полной строки
        $(withText("ull text")); // Ищит часть строки

        $("div").$("h1").find(byText("abc")).click(); // Пример вложенности поиска. find = $

    }

    void actions_examples() {
        $("").click();
        $("").doubleClick();
        $("").contextClick();

        $("").hover();

        $("").setValue("Text");
        $("").append("Text");
        $("").clear();

        $("").pressEnter();
        $("").pressTab();
        $("").pressEscape();

        $("").dragAndDrop(to("#target"));
        actions().moveToElement($("div")).clickAndHold().moveByOffset(300, 200).release().perform();

    }

    void conditions_examples() {

        $("").shouldBe(visible);
        $("").shouldBe(hidden);
        $("").shouldBe(empty);

        $("").shouldBe(visible, Duration.ofSeconds(30));

        $("").shouldHave(text("abc"));
        $("").shouldHave(textCaseSensitive("abc"));
        $("").shouldHave(exactText("abc"));
        $("").shouldHave(exactTextCaseSensitive("abc"));

        $("").shouldHave(cssValue("font-size", "12"));


    }

    void collections_examples() {

    }

    void file_operations_example() throws FileNotFoundException {

        File file1 = $("a.fileLink").download();
        File file2 = $("div").download(DownloadOptions.using(FileDownloadMode.FOLDER));

        File file = new File("src/test/resources/readme.txt");
        $("#file-upload").uploadFile(file);
        $("#file-upload").uploadFromClasspath("readme.txt");

    }

}