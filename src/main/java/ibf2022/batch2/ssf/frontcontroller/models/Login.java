package ibf2022.batch2.ssf.frontcontroller.models;

import jakarta.json.JsonObject;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Login {

    @NotNull(message = "Username cannot be empty")
    @Size(min = 2, message = "Username must contain at least 2 characters.")
    private String username;

    @NotNull(message = "Password cannot be empty")
    @Size(min = 2, message = "Password must contain at least 2 characters.")
    private String password;
    private Integer tooShort;

    public Login() {
    }

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
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

    public Integer getTooShort() {
        return this.tooShort;
    }

    public void setTooShort(Integer tooShort) {
        this.tooShort = tooShort;
    }

    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }

    public static Login create(JsonObject json) {
		Login login = new Login();
		login.setUsername(json.getString("username"));
		login.setPassword(json.getString("password"));
		return login;
	}

}