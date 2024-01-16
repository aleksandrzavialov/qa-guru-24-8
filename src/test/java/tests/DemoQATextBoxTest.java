package tests;

import data.StudentData;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class DemoQATextBoxTest extends TestBase {

    @Test
    void fillTextBoxFormTest() {

        TextBoxPage textBoxPage = new TextBoxPage();
        textBoxPage.openPage();

        textBoxPage.setFullName(StudentData.studentTextBox.fullName);
        textBoxPage.setEmail(StudentData.studentTextBox.email);
        textBoxPage.setCurrentAddress(StudentData.studentTextBox.currentAddress);
        textBoxPage.setPermanentAddress(StudentData.studentTextBox.permanentAddress);
        textBoxPage.submitResult();

        textBoxPage.checkNameResult(StudentData.studentTextBox.fullName);
        textBoxPage.checkEmailResult(StudentData.studentTextBox.email);
        textBoxPage.checkCurrentAddressResult(StudentData.studentTextBox.currentAddress);
        textBoxPage.checkPermanentAddressResult(StudentData.studentTextBox.permanentAddress);

    }
}