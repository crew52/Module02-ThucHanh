package entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Contact implements Serializable {
    private String phoneNumber;
    private String group;
    private String fullName;
    private String gender;
    private String address;
    private LocalDate birthDate;
    private String email;

    public Contact(String phoneNumber, String group, String fullName, String gender,
                   String address, LocalDate birthDate, String email) {
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
        this.birthDate = birthDate;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void displayContactInfo() {
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Group: " + group);
        System.out.println("Full Name: " + fullName);
        System.out.println("Gender: " + gender);
        System.out.println("Address: " + address);
    }
}
