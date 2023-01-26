package com.MIS.MISTalks.EmailSubscribe.Model;

import javax.persistence.*;

@Entity
@Table(name = "subscribed_emails")
public class Email {
    @SequenceGenerator(
            name = "email_id_gen",
    sequenceName = "email_id_gen",
    initialValue = 1,
    allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "email_id_gen")
    @Id
    private Integer id;
    private String email;

    public Email(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
