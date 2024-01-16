package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class TextBoxPage {
    private final SelenideElement fullNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            userCurrentAddressInput = $("#currentAddress"),
            userPermanentAddress = $("#permanentAddress"),
            submitButton = $("#submit"),
            tableContent = $("#output");


    public TextBoxPage openPage() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setFullName(String fullName) {
        fullNameInput.setValue(fullName);

        return this;
    }

    public TextBoxPage setEmail(String email) {
        userEmailInput.setValue(email);

        return this;
    }

    public TextBoxPage setCurrentAddress(String currentAddress) {
        userCurrentAddressInput.setValue(currentAddress);

        return this;
    }

    public TextBoxPage setPermanentAddress(String permanentAddress) {
        userPermanentAddress.setValue(permanentAddress);

        return this;
    }


    public void submitResult() {
        submitButton.click();
    }


    public TextBoxPage checkNameResult(String name) {
        tableContent.$("#name").shouldHave(text("Name:" + name));

        return this;
    }

    public TextBoxPage checkEmailResult(String email) {
        tableContent.$("#email").shouldHave(text("Email:" + email));

        return this;
    }

    public TextBoxPage checkCurrentAddressResult(String currentAddress) {
        tableContent.$("#currentAddress").shouldHave(text("Current Address :" + currentAddress));

        return this;
    }

    public TextBoxPage checkPermanentAddressResult(String permanentAddress) {
        tableContent.$("#permanentAddress").shouldHave(text("Permananet Address :" + permanentAddress));

        return this;
    }


}