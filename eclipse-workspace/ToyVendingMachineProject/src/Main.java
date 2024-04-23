import java.util.*;
public class Main {
    public static void main(String[] args) {
        ToyVendingMachine ToyMachine = new ToyVendingMachine();

        // Connect user
        Scanner scanner = new Scanner(System.in);

        System.out.println("***** HAPPI vending machine *****");
        System.out.println("Win cool toys with only 100 THB! Test your luck");
        System.out.println("1 roll = 100 THB");

        String userInput;
        Toy prizeToy;

        do {
            System.out.println("Would you like to play? Insert 100 THB (y/n): ");
            userInput = scanner.nextLine().toLowerCase();
			
            if (userInput.equals("y")) {
                prizeToy = ToyMachine.dispensePrizes();
                System.out.println("Congratulations! You have won " + prizeToy.getName() + " !!!!");
            } else if (userInput.equals("n")) {
                System.out.println("Have a nice day! Come again!");
            } else {
                System.out.println("Invalid input, please enter 'y' for yes or 'n' for no.");
            }

        } while (!userInput.equals("n"));

        scanner.close();
    }
}
