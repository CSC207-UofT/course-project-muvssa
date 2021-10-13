public class User {

    private String username;
    private String password;
    private String email;


    public User(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean login(String name, String password) {
        if(name.equals(this.username) || name.equals(this.email)){
            return(this.password.equals(password));
        }
        return false;
    }

}
