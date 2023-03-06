package main.com.w1zer.entity;

import java.util.Objects;

public class Profile {
    private long id;
    private String login;
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return id == profile.id && login.equals(profile.login) && password.equals(profile.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password);
    }
}
