package tests;

import data.StudentData;
import models.Student;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultTableComponent;


public class DemoQAFullFormTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    ResultTableComponent resultTable = new ResultTableComponent();

    @Test
    void successfulRegisterFullDataTest() {

        Student student = StudentData.studentFullData;

        //Preconditions
        registrationPage.openPage();

        //Form filling
        registrationPage.fillAllStudentFields(student);
        registrationPage.submitResult();

        //Checking submit results
        resultTable.checkResultTableUI().
                checkAllStudentFields(student);
    }

    @Test
    void successfulRegisterMinimalDataTest() {

        //Preconditions
        registrationPage.openPage();

        //Form filling
        registrationPage.setFirstName(StudentData.studentMinimumData.name).
                setLastName(StudentData.studentMinimumData.lastName).
                setGender(StudentData.studentMinimumData.gender).
                setUserNumber(StudentData.studentMinimumData.phone).
                setDateOfBirth(StudentData.studentMinimumData.dayOfBirth,
                        StudentData.studentMinimumData.monthOfBirth, StudentData.studentMinimumData.yearOfBirth);

        registrationPage.submitResult();

        //Checking submit results
        resultTable.checkResultTableUI().
                checkResult("Student Name",
                        StudentData.studentMinimumData.name + " " + StudentData.studentMinimumData.lastName).
                checkResult("Student Email", " ").
                checkResult("Gender", StudentData.studentMinimumData.gender).
                checkResult("Mobile", StudentData.studentMinimumData.phone).
                checkResult("Date of Birth",
                        StudentData.studentMinimumData.dayOfBirth + " " +
                                StudentData.studentMinimumData.monthOfBirth + "," +
                                StudentData.studentMinimumData.yearOfBirth).
                checkResult("Subjects", " ").
                checkResult("Hobbies", " ").
                checkResult("Picture", " ").
                checkResult("Address", " ").
                checkResult("State and City", " ");

    }

    @Test
    void unsuccessfulRegisterNoGenderEnteredTest() {

        //Preconditions
        registrationPage.openPage();

        //Form filling
        registrationPage.setFirstName(StudentData.studentMinimumData.name).
                setLastName(StudentData.studentMinimumData.lastName).
                setUserNumber(StudentData.studentMinimumData.phone).
                setDateOfBirth(StudentData.studentMinimumData.dayOfBirth,
                        StudentData.studentMinimumData.monthOfBirth,
                        StudentData.studentMinimumData.yearOfBirth);

        registrationPage.submitResult();

        //Checking submit results
        resultTable.checkTableIsNotVisible();

    }

}


