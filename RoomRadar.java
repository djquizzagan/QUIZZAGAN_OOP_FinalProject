import java.util.Scanner;

public class RoomRadar {
public static void main(String[] args) {
    RoomRadar roomRadar = new RoomRadar();
    roomRadar.displayWelcomeMessage();
    roomRadar.promptUserChoice();
}

private void displayWelcomeMessage() {
    System.out.println("\t\t\t\t\t\t\t\t=============");
    System.out.println("\t\t\t\t\t\t\t\t  RoomRadar");
    System.out.println("\t\t\t\t\t\t\t\t=============");
    System.out.println("\t\t\t\t\t\t\tYour Comfort, Our Priority!\n");
    System.out.println("\tWelcome, Prestigious Guest!");
    System.out.println("\tExplore our diverse selection of beautifully designed rooms, each tailored to provide a unique and comfortable experience for you!\n\n");

    System.out.println("\t\t\t\t\t\t   A. Standard\t    B. Suite\t  C. Deluxe");
    System.out.println("\t\t\t\t\t\t   Kindly choose your preferred room type  ");
    System.out.println("\t\t\t\t\t\t             Type A/a for Standard");
    System.out.println("\t\t\t\t\t\t             Type B/b for Suite");
    System.out.println("\t\t\t\t\t\t             Type C/c for Deluxe");
}

private void promptUserChoice() {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter your choice: ");
    String choice = input.nextLine().trim().toLowerCase();
    System.out.print("========================================================================================================================================================");
    System.out.print("\n\n");
    Room room = null; 
      
    switch (choice) {
        case "a":
            room = new StandardRoom(); 
            break;
        case "b":
            room = new SuiteRoom(); 
            break;
        case "c":
            room = new DeluxeRoom(); 
            break;
        default:
            System.out.println("Invalid input! Please enter 'A', 'B', or 'C'.");
            input.close();
            return; 
    }

    
    room.showDetails(); 
    input.close(); 
}
}
