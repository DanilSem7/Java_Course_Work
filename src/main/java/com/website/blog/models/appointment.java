package com.website.blog.models;
import com.website.blog.domain.User;
import javax.persistence.*;

@Entity
public class appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String date, time, doctor, telephone, status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public User getAuthor() {
        return author;
    }
    public void setAuthor(User author) {
        this.author = author;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getDoctor() {
        return doctor;
    }
    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String client) {
        this.telephone = client;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public appointment() {
    }

    public appointment(String date, String doctor, String time, String telephone, String status, User user)  {
        this.author = user;
        this.date = date;
        this.doctor = doctor;
        this.time = time;
        this.telephone = telephone;
        this.status = "Заявка принята";
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }
}
