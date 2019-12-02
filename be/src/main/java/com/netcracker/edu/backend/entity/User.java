package com.netcracker.edu.backend.entity;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="users")
public class User {
    private long id;
    private String login;
    private String password;
    private String role;
    private List<Order> orders = new ArrayList<Order>();

    @Id
    @Column(name = "user_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_login")
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "user_password")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "user_role")
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    @OneToMany(targetEntity=Order.class, fetch=FetchType.EAGER)
    @JoinColumn(name="user_id")
    public List<Order> getOrders() {
        return orders;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(role, user.role) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, role, orders);
    }
}
