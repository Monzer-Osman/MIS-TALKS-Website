package com.MIS.MISTalks.ContactUs.Model;

import javax.persistence.*;

@Entity
@Table(name = "feedbacks")
public class Feedback {
    @SequenceGenerator(
        name="feed_id_generator",
        sequenceName = "feed_id_generator",
        initialValue = 1,
        allocationSize = 1
    )
    @GeneratedValue(
            generator = "feed_id_generator",
            strategy = GenerationType.SEQUENCE
    )
    @Id
    private Integer id;

    @Column(name = "sender_name")
    private String senderName;
    private String email;
    private String subject;
    private String message;

    public Feedback(Integer id, String senderName, String email, String subject, String message) {
        this.id = id;
        this.senderName = senderName;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    public Feedback(String senderName, String email, String subject, String message) {
        this.senderName = senderName;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
