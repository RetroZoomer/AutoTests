package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {


    @BeforeAll
    static void setup() {
//        Configuration.timeout = 50000;
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void dataAppearsInOutputBlockTest() {
        open("https://demoqa.com/text-box");

        $(".text-center").shouldHave(text("Text Box"));

        $("#userName").setValue("Alex");
        $("#userEmail").setValue("example@ex.com");
        $("#currentAddress").setValue("address cur");
        $("#permanentAddress").setValue("address perm");
        $("#submit").click();

        $("#output").shouldHave(text("Alex"));

//        sleep(3000);

    }

}
