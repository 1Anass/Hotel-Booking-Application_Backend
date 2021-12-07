package ma.hotelbookingapp.monolithic.data.dtos;

public class PriceSuggestion {
    
    private float suggestedPrice;

    private int numberOfRooms;

    protected PriceSuggestion() { }

    public PriceSuggestion(float suggestedPrice, int numberOfRooms){
        this.suggestedPrice = suggestedPrice;
        this.numberOfRooms = numberOfRooms;
    }

    public float getSuggestedPrice() {
        return suggestedPrice;
    }

    public void setSuggestedPrice(float suggestedPrice) {
        this.suggestedPrice = suggestedPrice;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    
}
