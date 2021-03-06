package fr.almeri.beerboard.models;

import javax.persistence.*;
import java.io.Serializable;

import java.util.Objects;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "salt")
    private byte[] salt;

    public User(){};

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String s, String hash, byte[] salt) {
        this.login = s;
        this.password = hash;
        this.salt = salt;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User users = (User) o;
        return Objects.equals(getUserId(), users.getUserId()) && Objects.equals(getLogin(), users.getLogin()) && Objects.equals(getPassword(), users.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getLogin(), getPassword());
    }
}
