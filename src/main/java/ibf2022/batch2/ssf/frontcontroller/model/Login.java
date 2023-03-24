package ibf2022.batch2.ssf.frontcontroller.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Login {
    @NotNull(message = "username is empty")
    @Size(min = 2, message = "username must be at least length of 2")
    private String username;
    @NotNull(message = "password is empty")
    @Size(min = 2, message = "password must be at least length of 2")
    private String password;
    private Integer tooShort;
    private Boolean authenticated=false;

    public Login() {
    }

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Boolean isAuthenticated() {
        return this.authenticated;
    }

    public Boolean getAuthenticated() {
        return this.authenticated;
    }

    public void setAuthenticated(Boolean authenticated) {
        this.authenticated = authenticated;
    }


    public Integer getTooShort() {
        return this.tooShort;
    }

    public void setTooShort(Integer tooShort) {
        this.tooShort = tooShort;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }

}