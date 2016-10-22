package com.example.velocity.entity;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "app_user")
public class AppUser {

    private Long id;
    private Boolean accountExpired;
    private Boolean accountLocked;
    private String address;
    private String city;
    private String country;
    private String postalCode;
    private String province;
    private Boolean credentialsExpired;
    private String email;
    private Boolean accountEnabled;
    private String firstName;
    private String lastName;
    private String password;
    private String passwordHint;
    private String phoneNumber;
    private String username;
    private Long version;
    private String website;

        @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        public Boolean getAccountExpired() {
        return accountExpired;
    }

    public void setAccountExpired(Boolean accountExpired) {
        this.accountExpired = accountExpired;
    }
        public Boolean getAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(Boolean accountLocked) {
        this.accountLocked = accountLocked;
    }
        public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
        public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
        public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
        public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
        public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
        public Boolean getCredentialsExpired() {
        return credentialsExpired;
    }

    public void setCredentialsExpired(Boolean credentialsExpired) {
        this.credentialsExpired = credentialsExpired;
    }
        public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
        public Boolean getAccountEnabled() {
        return accountEnabled;
    }

    public void setAccountEnabled(Boolean accountEnabled) {
        this.accountEnabled = accountEnabled;
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
        public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
        public String getPasswordHint() {
        return passwordHint;
    }

    public void setPasswordHint(String passwordHint) {
        this.passwordHint = passwordHint;
    }
        public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
        public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
        public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
        public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
