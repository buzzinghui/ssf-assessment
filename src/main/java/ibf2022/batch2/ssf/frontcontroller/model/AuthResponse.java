package ibf2022.batch2.ssf.frontcontroller.model;


public class AuthResponse {

    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AuthResponse{" +
                "message='" + message + '\'' +
                '}';
    }
}
