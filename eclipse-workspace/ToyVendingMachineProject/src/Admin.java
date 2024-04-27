public class Admin extends Player {
    private String password;

    public Admin(String username, String password){
        super(username);
        if(password == null || password.isEmpty()){
            throw new IllegalArgumentException("Password cannot be empty");
        }
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }
}
