public class Toy {
    // attributes
    private int id;
    private String name;
    private String type;
    private int count;

    public Toy(int id, String name, String type, int count){
        this.id = id;
        this.name = name;
        this.type = type;
        if(count < 0){
            throw new IllegalArgumentException("Cannot be negative");
        }
        this.count = count;
    }

    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getType(){
        return this.type;
    }
    public int getCount(){
        return this.count;
    }
    public void setCount(int count){
        if(count < 0){
            throw new IllegalArgumentException("Cannot be negative");
        }
        this.count = count;
    }
}
