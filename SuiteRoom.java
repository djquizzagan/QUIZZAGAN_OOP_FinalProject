import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SuiteRoom extends Room {

public SuiteRoom() {
super("Suite Room", 
        "This elegant Suite Room Type has three unique layouts designed to match your individual tastes!", 
        "Php 2200-2800"); 
}

@Override
public void showDetails() {
System.out.println("\t\t\t\t\t\t\t   Room Type: " + getRoomType());
System.out.println("\t\t     Description: " + getDescription());
System.out.println("\t\t\t\t\t\t\t   Price Range: " + getPriceRange());

System.out.println("\t\t\t\t\t\t\t\t=============");
System.out.println("\t\t\t\t\t\t\t\t    Suite    ");
System.out.println("\t\t\t\t\t\t\t\t=============");
System.out.println("Suite Room A: Price: Php 2200\n- 1 Queen Bed\n- Free Wi-Fi\n- Breakfast and Morning Snack\n- Airconditioned\n- Television");
System.out.println("Suite Room B: Price: Php 2500\n- 1 King Bed\n- Free Wi-Fi\n- Breakfast and Lunch\n- Airconditioned\n- Television");
System.out.println("Suite Room C: Price: Php 2800\n- 2 Queen Beds\n- Free Wi-Fi\n- Breakfast, Lunch, Dinner\n- Airconditioned\n- Karaoke");

Scanner input = new Scanner(System.in);
System.out.print("Enter your choice (A, B, C): ");
String suiteChoice = input.nextLine().trim().toLowerCase();
System.out.print("==================================================================================================================================================================");
System.out.print("\n\n");

switch (suiteChoice) {
    case "a":
        showRoomDetails("A", 2200, "- 1 Queen Bed\n\t\t\t\t\t\t\t\t- Free Wi-Fi\n\t\t\t\t\t\t\t\t- Breakfast and Morning Snack\n\t\t\t\t\t\t\t\t- Airconditioned\n\t\t\t\t\t\t\t\t- Television");
        break;
    case "b":
        showRoomDetails("B", 2500, "- 1 King Bed\n\t\t\t\t\t\t\t\t- Free Wi-Fi\n\t\t\t\t\t\t\t\t- Breakfast and Lunch\n\t\t\t\t\t\t\t\t- Airconditioned\n\t\t\t\t\t\t\t\t- Television");
        break;
    case "c":
        showRoomDetails("C", 2800, "- 2 Queen Beds\n\t\t\t\t\t\t\t\t- Free Wi-Fi\n\t\t\t\t\t\t\t\t- Breakfast, Lunch, Dinner\n\t\t\t\t\t\t\t\t- Airconditioned\n\t\t\t\t\t\t\t\t- Karaoke");
        break;
    default:
        System.out.println("Invalid input! Please enter 'A', 'B', or 'C'.");
        return; 
}
}

private void showRoomDetails(String roomType, int price, String amenities) {
System.out.println("You have chosen... \nSuite Room" + roomType + ": Price: Php " + price);
System.out.println(amenities);

Scanner input = new Scanner(System.in);
System.out.print("Please enter your check-in date (YYYY-MM-DD): \n");
String checkInDateStr = input.nextLine().trim();
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
LocalDate checkInDate = LocalDate.parse(checkInDateStr, formatter);

System.out.print("Please enter the number of days of your stay: \n");
int numberOfDays = input.nextInt();
input.nextLine(); 

int totalCost = price * numberOfDays;

System.out.println("Total cost for your stay: Php " + totalCost);
System.out.println("\t\t\t\t\t\tDo you want to proceed with the payment and reservation?");
System.out.println("\t\t\t\t\t\t            A. Proceed    B. Go back");
System.out.println("\t\t\t\t\t\t             Type A/a for Proceed");
System.out.println("\t\t\t\t\t\t             Type B/b for Go Back");

System.out.print("Enter your choice: ");
String suiteProceed = input.nextLine().trim().toLowerCase();
System.out.print("=================================================================================================================================================================");
System.out.print("\n\n");

switch (suiteProceed) {
    case "a":
        proceedToPayment(roomType, price, amenities, checkInDate, numberOfDays, totalCost);
        break;
    case "b":
        showDetails();  
        break;
    default:
        System.out.println("Invalid input! Please enter 'A' or 'B'.");
}
}

private void proceedToPayment(String roomType, int price, String amenities, LocalDate checkInDate, int numberOfDays, int totalCost) {
    System.out.println("You have successfully chosen Standard Room " + roomType + " for Php " + totalCost + "!\n");
    System.out.println("Proceeding to payment...\n");

    double conrate = getCurrencyConversionRate();
    if (conrate == 0) {
        System.out.println("Invalid currency selected. Exiting the payment process.");
        return;
    }

    double convertedPrice = totalCost * conrate;
    System.out.println(String.format("\nThe price of the room in your chosen currency is: %.1f", convertedPrice));

    Scanner input = new Scanner(System.in);
    System.out.println("\t\t\t\t\t\t\tDo you want to proceed with the payment of " + String.format("%.1f", convertedPrice) + "? (Yes/No)");
    System.out.println("Enter your choice: ");
    String paymentChoice = input.nextLine().trim().toLowerCase(); 

    if (paymentChoice.equals("yes")) {
        System.out.println("Please enter the amount you want to pay in your selected currency: ");
        double amountPaid = input.nextDouble();
        input.nextLine();  

        if (amountPaid >= convertedPrice) {
            System.out.println("===========================================");
            System.out.println(" Payment successful! Reservation complete. ");
            System.out.println("===========================================");
            
            displayReservationDetails(roomType, price, amenities, checkInDate, numberOfDays, totalCost);
        } else {
            System.out.println("Insufficient amount! Payment failed.");
        }
    } else {
        System.out.println("Payment cancelled. Returning to room selection.");
        showDetails();
    }
}

private void displayReservationDetails(String roomType, int price, String amenities, LocalDate checkInDate, int numberOfDays, int totalCost) {
System.out.println("\n\n\n===================================================================== Reservation Summary =====================================================================");
System.out.println("\t\t\t\t\t\t\t\tRoom Type: Suite Room " + roomType);
System.out.println("\t\t\t\t\t\t\t\tPrice: Php " + price + " per night");
System.out.println("\t\t\t\t\t\t\t\tAmenities: " + amenities);
System.out.println("\t\t\t\t\t\t\t\tCheck-in Date: " + checkInDate);
System.out.println("\t\t\t\t\t\t\t\tNumber of Days: " + numberOfDays);
System.out.println("\t\t\t\t\t\t\t\tTotal Price: Php " + totalCost);
}

private double getCurrencyConversionRate() {
System.out.println("Choose the currency you want to pay in:");
System.out.println("1. Japanese Yen (JPY)");
System.out.println("2. British Pound (GBP)");
System.out.println("3. US Dollar (USD)");
System.out.println("4. UAE Dirhams (AED)");
System.out.println("5. South Korean Won (KRW)");
System.out.println("6. Philippine Peso (PHP)");

Scanner input = new Scanner(System.in);
System.out.print("Enter the number corresponding to your currency choice: ");
int currencyChoice = input.nextInt();
input.nextLine(); 

double conrate = 0;
switch (currencyChoice) {
    case 1: 
        conrate = 2.5;  
    case 2: 
        conrate = 0.015;  
        break;
    case 3: 
        conrate = 0.018;  
        break;
    case 4: 
        conrate = 0.067;  
        break;
    case 5: 
        conrate = 23.5;  
        break;
    case 6:
        conrate = 1;  
        break;
    default:
        System.out.println("Invalid currency choice.");
        return 0;  
}
return conrate;
}
}
