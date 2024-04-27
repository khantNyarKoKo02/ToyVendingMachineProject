public class Admin extends Player {
    private String password;

    public Admin(String username, String password){
        super(username);
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }
}
