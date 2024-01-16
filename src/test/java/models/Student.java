package models;

import data.StudentData;

public class Student {

    public String name, lastName, fullName,  email, gender, phone, monthOfBirth, dayOfBirth, picture, address,
            permanentAddress, currentAddress, state, city;
    public int yearOfBirth;
    public String[] subjects, hobbies;

    public Student(String name, String lastName, String email, String gender, String phone, int yearOfBirth,
                   String monthOfBirth, String dayOfBirth, String[] subjects, String[] hobbies, String picture,
                   String address, String state, String city) {

        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
        this.yearOfBirth = yearOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.dayOfBirth = dayOfBirth;
        this.subjects = subjects;
        this.hobbies = hobbies;
        this.picture = picture;
        this.address = address;
        this.state = state;
        this.city = city;

    }

    public Student() {
        this.name = StudentData.getRandomName();
        this.lastName = StudentData.getRandomLastName();
        this.fullName =  name + " " + lastName;
        this.email = StudentData.getRandomEmail(name, lastName);
        this.permanentAddress = StudentData.getPermanentAddress();
        this.currentAddress = StudentData.getCurrentAddress();

    }

}
