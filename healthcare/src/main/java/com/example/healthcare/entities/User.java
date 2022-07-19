package com.example.healthcare.entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
@Table(name = "userrecord")
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Size(min = 2, max = 20)
    @NotNull(message = "Pls Enter User Name!")
    private String username;
    @Size(min = 2, max = 20)

    @NotNull(message = "Pls Enter Password!")
    private String password;
  //  private  boolean loggedIn;

//    @NotNull(message = "Pls Enter role")
//    private String role;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        //this.loggedIn = false;
//        this.role = role;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof User)) return false;
//        User user = (User) o;
//        return Objects.equals(username, user.username) &&
//                Objects.equals(password, user.password);
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id, username, password, loggedIn);
//    }
}
