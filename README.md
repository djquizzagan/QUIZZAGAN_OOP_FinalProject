# 🌆RoomRadar: A Hotel Room Reservation System 
![alt text](<Screenshot 2024-12-08 000304.png>)
## I. 📚Project Overview

**RoomRadar: A Hotel Room Reservation System** offer and securely reserve a hotel room of your choice with ease. Using this system, people will no longer need to personally book an appointment on a specific room they want. The system aims to help the community in finding and reserving a room not only when they want comfort but also in times of need. This system will start the change especially in the rural areas wherein automated transactions were not yet utilized. People can start exploring the advantages of innovation of technology and use a system like this, (RoomRadar: A Room Reservation System) for their needs, wants and all things associated with it. 

The program is divided into 5 main components:
1. **RoomRadar.java** - The main class that handles the user interface and interaction with the room selection system.
2. **Room.java** - An abstract parent class that defines the common properties and behaviors for different room types.
3. **StandardRoom.java** - A subclass that implements the details for a specific room type (Standard Room).
4. **SuiteRoom.java** - A subclass that implements the details for a specific room type (Suite Room).
5. **DeluxeRoom.java** - A subclass that implements the details for a specific room type (Deluxe Room).

The system allows users to choose from different room types (Standard, Suite, and Deluxe), input check-in details, calculate costs, and proceed with payment in various currencies.

## II. ♨️Application of OOP Principles

### 1. **Encapsulation**:
   - Each class encapsulates its data like room type, description, price range and provides methods to interact with that data.
   - The program uses private attributes for room properties and exposes them through public getter methods.

### 2. **Abstraction**:
   - The **Room** class serves as an abstract base class that defines the general structure of rooms and leaves the details of each room type (Standard, Suite, and Deluxe) to be implemented in their respective subclasses.
   - **showdetails** is an abstract method, ensuring that all subclasses must implement this method to display room-specific information.

### 3. **Inheritance**:
   - **StandardRoom, SuiteRoom, DeluxeRoom** inherits from **Room** and implements the details specific to the each of them. This allows for reusability of common room attributes (such as price range and description) while providing specialized behavior for those three extended classes.
   
### 4. **Polymorphism**:
   - The program demonstrates polymorphism through the use of the **showdetails** method. Despite being of different types, each subclass provides its own implementation of this method, allowing the program to interact with different room types in a uniform way.

## III. 🌏Integration of SDG (Sustainable Development Goal)

### Chosen SDG: **Goal 8 - Decent Work and Economic Growth**

SDG 9: Industry, Innovation, Infrastructure

    The system is associated with a digital approach that allows a no-appearance reservation by the user and secures anything indicated in the reservation. It promotes innovation especially in rural areas wherein there are numerous hotels but guests cannot assure the reservation until they book it personally which is time consuming and not practical. The automation of this system enhances operational efficiency, reducing reliance on manual processes and minimizing human error, which is a vital part of innovating and modernizing transactions. As this system of innovation emerges, the modern time of technology grows for more and for the better. Not only for the wants of users, but most especially for essentials of different people who need comfort and accommodation. 


SDG 8: Decent Work and Economic Growth

    Integration of innovation and business leads to the growth of the economy. The system provides an opportunity for businesses to bloom with the use of a system like this. Using this system encourages most businesses to embrace e-commerce and online services that are important for the uprise of industry. When people see a chance like this, the likes of the tourism department rises because people will be more engaged to travel and explore once there is a platform like this. As more travelers and tourists become part of the economic interactions, many opportunities are on the way which is a vital factor of progression and economic growth. Additionally, the data insights provided by the system can help hotels refine their marketing and pricing strategies, improving financial stability and ensuring long term growth.  


## IV. ⚙️Instructions for Running the Program

### Requirements:
- A text editor or IDE (such as Vscode, IDEA or Eclipse) to open and edit the Java files.
- Java Development Kit (JDK) installed on user's device or machine. 

### Steps to Run the Program:

1. **Clone or Download the Repository**:
   
   1.1  Clone the repository or download the project files to your local machine.
   - In cloning the Repository, follow these steps:

    Copy the repository's URL:
    https://github.com/djquizzagan/QUIZZAGAN_OOP_FinalProject

    Open your terminal or command prompt.

    Run the following command:
  
   git clone https://github.com/djquizzagan/QUIZZAGAN_OOP_FinalProject

2. **Navigate to the Project Directory**:
   - Open or Make sure to Download (if you dont have any) an IDE like Vscode and navigate to the directory where the files are stored.

3. **Open and Compile the Java Files**:
   - The project consists of five Java files: **RoomRadar.java, Room.java, StandardRoom.java, SuiteRoom.Java, Deluxe.java**
   Make sure to open all the files and in order to use all the features of the program
   
4. **Run the Program**:
   - After compiling the files, click the run or debug button to start the operation of the program. 

5. **Interact with the Program**:
   - The program will display a welcome message like 
   **||RoomRadar|| "Your comfort our priority."......**
   and allow user to choose from three room types (Standard, Suite, and Deluxe). The choices were clearly stated in the program. 
   - Then the user will be prompted to select a room and ask to enter check-in date, and specify the number of days of stay.
   - When done choosing, it will proceed to the payment process after the user agree.
   - Then the program will calculate the total cost and proceed to the payment process, where users can choose a currency and complete the payment.
   - Once the payment is settled, a display message showing the successful reservation and its details will pop out. 

## 👨‍💻Contributors
| Name                    | Role       | Email                          | Other Contacts        |
|-------------------------|------------|--------------------------------|-----------------------|
| Deniel John V. Quizzagan   | Developer  | 23-08907@g.batstate-u.edu.ph   | +639461368285        |

## Course: 
- CS 211 (Object-oriented Programming)

## Instructor:
- Mr. Maurice Oliver Dela Cruz
