package com.example.Widget.in.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String fullname;

    public user(String username, String password, String fullname) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
    }
}
