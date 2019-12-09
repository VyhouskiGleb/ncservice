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
    private List<Library> orders = new ArrayList<Library>();
    private BillingAccount billing = new BillingAccount();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billing_id")

    public BillingAccount getBilling() {
        return billing;
    }
    public void setBilling(BillingAccount billing) {
        System.out.print("dd");this.billing = billing;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(targetEntity= Library.class, fetch=FetchType.EAGER)
    @JoinColumn(name="user_id")
    public List<Library> getOrders() {
        return orders;
    }
    public void setOrders(List<Library> orders) {
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
                Objects.equals(billing, user.billing) &&
                Objects.equals(role, user.role) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, role, orders, billing);
    }
}
