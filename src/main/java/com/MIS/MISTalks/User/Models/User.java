package com.MIS.MISTalks.User.Models;

import com.MIS.MISTalks.DTO.SignupData;
import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id()
    @SequenceGenerator(
            name = "id_generator",
            sequenceName = "id_generator",
            allocationSize = 1,
            initialValue = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "id_generator"
    )
    @Column(name="id")
    Integer userId;
    String firstName;
    String lastName;
    String phoneNumber;
    String email;
    String password;

    String joinDate;

    public User(){}

    public User(SignupData data){
        this.firstName = data.firstName();
        this.lastName = data.lastName();
        this.email = data.email();
        this.password = data.password();

    }

    public User(String firstName, String lastName, String phoneNumber, String email, String password, String joinDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }
}
