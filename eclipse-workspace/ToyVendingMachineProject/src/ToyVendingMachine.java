import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class ToyVendingMachine implements IVendingMachine {
    private List<Toy> ToysList = new ArrayList<>();

    public ToyVendingMachine(){
        Toy BatmanFigure = new Toy(1, "Batman figure", "Action Figure", 10);
        Toy BarbieFigure = new Toy(2, "Barbie figure", "Action Figure", 10);
    
        Toy TeddyBear = new Toy(3, "Teddy The Bear", "Stuffed Animal", 10);
    
        Toy LegoNinjaGo = new Toy(4, "LEGO Ninjago Set", "Puzzle Toy", 10);
        
        Toy HotWheel = new Toy(5, "Hotwheels car", "Toy Car", 10);
        Toy TakaraTomy = new Toy(6, "Takara Tomy car", "Toy Car", 10);
    
        Toy UnoCard = new Toy(7, "Hotwheels car", "Toy Car", 10);
    
        Toy SpikyBall = new Toy(8, "Spiky Ball", "Ball", 10);
        Toy PokeBall = new Toy(9, "Pokemon Ball", "Ball", 10);
        
        ToysList.add(BatmanFigure);
        ToysList.add(BarbieFigure);
        ToysList.add(TeddyBear);
        ToysList.add(LegoNinjaGo);
        ToysList.add(HotWheel);
        ToysList.add(TakaraTomy);
        ToysList.add(UnoCard);
        ToysList.add(SpikyBall);
        ToysList.add(PokeBall);
    }

    @Override
    public Toy dispensePrizes(){
        Random rand = new Random();
        int userId = rand.nextInt(9) + 1;
        for(Toy toy : ToysList){
            if(toy.getId() == userId){
                return toy;
            }
        }
        return null;
    }
    @Override
    public void restockPrizes(){
        for(Toy toy : ToysList){
            if(toy.getCount() < 10){
                toy.setCount(10);
            }
        }
        System.out.println("Restocked prizes successfully!");
    }
    
    public void checkInventory(){
        System.out.println("Here is the inventory: ");
        System.out.println("**********************");
        for(Toy toy : ToysList){
            System.out.println(toy.getCount() + " left for " + toy.getName());
        }
        System.out.println("**********************");
    }
}
