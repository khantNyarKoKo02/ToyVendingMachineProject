public class Player {
    private String username;

    public Player(String username){
        if(username == null || username.isEmpty()){
            throw new IllegalArgumentException("Username cannot be empty");
        }
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }
}
