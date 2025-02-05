package docs;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Lockates {

    void x() {
        $x("//input[@id='email']").setValue("some@email.ru");   //XPATH
        $("input[id='email']").setValue("some@email.ru"); // css selector

    }

}
