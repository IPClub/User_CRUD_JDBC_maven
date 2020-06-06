package entity;

public class User {

    private int id;
    private String login;
    private String password;
    private String email;
    private int birthday;


    public User() {

    }

    public User(String login, String password, String email, int birthday) {
        this.login = login;
        this.password = password;
        this.birthday = birthday;
        this.email = email;
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


    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String info() {
        return login + "," + password + ", " + birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
