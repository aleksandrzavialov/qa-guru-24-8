package pages.components;

import com.codeborne.selenide.SelenideElement;
import models.Student;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {

    private final SelenideElement tableTitle = $("#example-modal-sizes-title-lg"),
            tableContent = $(".table-responsive"),
            closeTableButton = $("#closeLargeModal"),
            formWrapper = $(".practice-form-wrapper");

    public ResultTableComponent checkResultTableUI() {
        tableTitle.shouldHave(text("Thanks for submitting the form"));
        closeTableButton.shouldBe(visible);

        return this;
    }

    public ResultTableComponent checkResult(String key, String value) {
        tableContent.$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }

    public void checkTableIsNotVisible() {
        formWrapper.shouldHave(text("Student Registration Form"));
        tableTitle.shouldNotBe(visible);
        tableContent.shouldNotBe(visible);
        closeTableButton.shouldNotBe(visible);
    }

    public void checkAllStudentFields(Student student) {
        checkResult("Student Name", student.name + " " + student.lastName).
                checkResult("Student Email", student.email).
                checkResult("Gender", student.gender).
                checkResult("Mobile", student.phone).
                checkResult("Date of Birth",
                        student.dayOfBirth + " " + student.monthOfBirth + "," + student.yearOfBirth).
                checkResult("Subjects", String.join(", ", student.subjects)).
                checkResult("Hobbies", String.join(", ", student.hobbies)).
                checkResult("Picture", student.picture).
                checkResult("Address", student.address).
                checkResult("State and City", student.state + " " + student.city);
    }
}
