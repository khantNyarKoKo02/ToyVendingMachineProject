import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
public class Main {

    public static void saveRecord(String data, String fileName) {
        try (FileWriter writer = new FileWriter(fileName, true)) { 
            writer.write(data + "\n");  
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
    public static void readRecords(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) { 
            String line;
            System.out.println("Here is the record of all prizes won: ");
            System.out.println("***************************************");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("***************************************");
        } catch (IOException e) {
            System.err.println("An error occurred while reading from the file: " + e.getMessage());
        }
    }
    public static void clearContents(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Admin superadmin = new Admin("superduperadmin","admin123");
        ToyVendingMachine ToyMachine = new ToyVendingMachine();

    
        Scanner scanner = new Scanner(System.in);

        System.out.println("***** HAPPI vending machine *****");
        System.out.println("Win cool toys with only 100 THB! Test your luck");
        System.out.println("1 roll = 100 THB");

        String userInput;
        Toy prizeToy;

        try{
            do {
                System.out.println("Would you like to play? Insert 100 THB (y/n): ");
                userInput = scanner.nextLine().toLowerCase();
                
                switch(userInput){
                    case "y":
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
                        LocalDateTime now = LocalDateTime.now();  
                        prizeToy = ToyMachine.dispensePrizes();
                        prizeToy.setCount(prizeToy.getCount() - 1);
                        System.out.println("Congratulations! You have won " + prizeToy.getName() + " !!!!");
                        saveRecord("A player won a " + prizeToy.getName() + " at " + dtf.format(now), "prizeRecord");
                        break;
                    case "n":
                        System.out.println("Have a nice day! Come again!");
                        break;
                    case "adminlogin":
                        String username;
                        String password;
                        System.out.print("Enter username: ");
                        username = scanner.nextLine();
                        System.out.print("Enter password: ");
                        password = scanner.nextLine();
                        String adminUsername = superadmin.getUsername();
                        String adminPassword = superadmin.getPassword();
                        if(username.equals(adminUsername) && password.equals(adminPassword)){
                            System.out.println("Welcome, " + adminUsername);
                        }else{
                            System.out.println("Wrong username or password!");
                            break;
                        } 
                        int adminChoice;
                        do{
                        System.out.println("What would you like to do? ");
                        System.out.println("1. Restock vending machine");
                        System.out.println("2. Check record");
                        System.out.println("3. Clear record");
                        System.out.println("4. Check inventory");
                        System.out.println("5. Exit");
                        adminChoice = scanner.nextInt();
                        scanner.nextLine();
                            if(adminChoice == 1){
                                ToyMachine.restockPrizes();
                            }else if(adminChoice == 2){
                                readRecords("prizeRecord");
                            }else if(adminChoice == 3){
                                clearContents("prizeToy");
                            }else if(adminChoice == 4){
                                ToyMachine.checkInventory();
                            }
                        } while(adminChoice != 5);
                        System.out.println("You have been logged out!");
                        break;
                    default:
                        System.out.println("Invalid input, please enter 'y' for yes or 'n' for no.");
                        break;
                }
    
            } while (!userInput.equals("n"));
        }catch(IOException e){
            System.out.println("An error occured " + e.getMessage());
        }finally{
            scanner.close();
        }
    }
}
