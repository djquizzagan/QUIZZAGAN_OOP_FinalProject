// Abstract class for Room
public abstract class Room {
private String roomtype;
private String description;
private String pricerange;

public Room(String roomtype, String description, String pricerange) {
    this.roomtype = roomtype;
    this.description = description;
    this.pricerange = pricerange;
}

public abstract void showDetails(); 

public String getRoomType() {
    return roomtype;
}

public String getDescription() {
    return description;
}

public String getPriceRange() {
    return pricerange;
}
}
