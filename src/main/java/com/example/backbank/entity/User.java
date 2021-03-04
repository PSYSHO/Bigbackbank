package com.example.backbank.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "users")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
private String username;
private String SecondName;
private String Lastname;
private float wallet;
private String email;
@OneToMany
private Set<Deposit> deposits;
@OneToMany
private Set<CreditCard> creditCards;

@ManyToMany(fetch = FetchType.LAZY)
@JoinTable(	name = "user_roles",
        joinColumns = @JoinColumn(name = "users_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
private Set<Role> roles = new HashSet<>();

private String password;

    public User() {
    }

    public User(String username,String email,String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
    public User(String username,String email,String password,float wallet) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(long id, String username, String secondName, String lastname, float wallet, Set<Deposit> deposits, String role, String email, String password) {
        this.id = id;
        this.username = username;
        this.SecondName = secondName;
        this.Lastname = lastname;
        this.wallet = wallet;
        this.deposits = deposits;
        this.email = email;
        this.password = password;
    }

    public float getWallet() {
        return wallet;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    public Set<CreditCard> getCreditProducts() {
        return creditCards;
    }

    public void setCreditProducts(Set<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String firstname) {
        this.email = firstname;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public Set<Deposit> getProducts() {
        return deposits;
    }

    public void setProducts(Set<Deposit> deposits) {
        this.deposits = deposits;
    }


    public String getUsername() {
        return username;
    }

    public Set<Deposit> getDeposits() {
        return deposits;
    }

    public void setDeposits(Set<Deposit> deposits) {
        this.deposits = deposits;
    }

    public Set<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(Set<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
