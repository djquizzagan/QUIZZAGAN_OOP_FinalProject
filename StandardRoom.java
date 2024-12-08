import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StandardRoom extends Room {

public StandardRoom() {
super("Standard Room", 
        "This cozy Standard Room offers three distinct room options to suit your preferences perfectly!", 
        "Php 900-1700"); 
}

@Override
public void showDetails() {
System.out.println("\t\t\t\t\t\t\t   Room Type: " + getRoomType());
System.out.println("\t\t     Description:" + getDescription());
System.out.println("\t\t\t\t\t\t\t   Price Range:" + getPriceRange());

System.out.println("\t\t\t\t\t\t\t\t=============");
System.out.println("\t\t\t\t\t\t\t\t  Standard   ");
System.out.println("\t\t\t\t\t\t\t\t=============");
System.out.println("Standard Room A: Price: Php 900\n- 1 Single Bed\n- Free Wi-Fi\n- Fan Cooling\n");
System.out.println("Standard Room B: Price: Php 1300\n- 1 Double Bed\n- Free Wi-Fi\n- Fan Cooling\n- Television\n");
System.out.println("Standard Room C: Price: Php 1700\n- 1 King Bed\n- Free Wi-Fi\n- Breakfast\n- Fan Cooling\n- Television\n");

Scanner input = new Scanner(System.in);
System.out.print("Enter your choice (A, B, C): ");
String stanchoice = input.nextLine().trim().toLowerCase();
System.out.print("==================================================================================================================================================================");
System.out.print("\n\n");

switch (stanchoice) {
    case "a":
        showRoomDetails("A", 900, "-1 Single Bed\n\t\t\t\t\t\t\t\t- Free Wi-Fi\n\t\t\t\t\t\t\t\t- Fan Cooling\n");
        break;
    case "b":
        showRoomDetails("B", 1300, "-1 Double Bed\n\t\t\t\t\t\t\t\t- Free Wi-Fi\n\t\t\t\t\t\t\t\t- Fan Cooling\n\t\t\t\t\t\t\t\t- Television\n");
        break;
    case "c":
        showRoomDetails("C", 1700, "-1 King Bed\n\t\t\t\t\t\t\t\t- Free Wi-Fi\n\t\t\t\t\t\t\t\t- Breakfast\n\t\tt\t\t\t\t\t- Fan Cooling\n\t\t\t\t\t\t\t\t- Television\n");
        break;
    default:
        System.out.println("Invalid input! Please enter 'A', 'B', or 'C'.");
        return;
}
}

private void showRoomDetails(String roomType, int price, String amenities) {
System.out.println("You have chosen... \nStandard Room" + roomType + ": Price: Php " + price);
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
String stanproceed = input.nextLine().trim().toLowerCase();
System.out.print("=================================================================================================================================================================");
System.out.print("\n\n");

switch (stanproceed) {
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

        final double epsilon = 0.01;

        if (amountPaid >= (convertedPrice - epsilon)) {
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
System.out.println("\n================================================================= Reservation Summary ================================================================");
System.out.println("\t\t\t\t\t\t\t\tRoom Type: Standard Room " + roomType);
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
