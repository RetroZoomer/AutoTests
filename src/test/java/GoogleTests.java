import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class GoogleTests {

    @Test
    void selenideSearchTest() {
        //Открыть браузер
        open("https://www.google.ru/");

        // Ввести в строку selenide и нажать поиск
//        $("[name='q']").setValue("Selenide");
        $(byName("q")).setValue("Selenide").pressEnter();
        sleep(1000);
        // Проверить, что поиск прошел успешно, по слову Selenide
        // # - укароченный синтаксис для id
        // Google не пускает меня) т.к. думает, что я робот
        $("#search").shouldHave(text("selenide.org"));
        sleep(5000);

    }

}
