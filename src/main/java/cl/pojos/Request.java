package cl.pojos;

public class Request {

    private String email;
    private String username;
    private String urlCallback;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrlCallback() {
        return urlCallback;
    }

    public void setUrlCallback(String urlCallback) {
        this.urlCallback = urlCallback;
    }

    @Override
    public String toString() {
        return "Request{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", urlCallback='" + urlCallback + '\'' +
                '}';
    }
}
