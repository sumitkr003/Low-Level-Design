package hotelManagementSystem;

import java.util.List;

public class StandardRoom extends Room{

    private List<String> amenities;
    private Double roomCharges;
    private Integer roomCapacity;

    public StandardRoom(String roomId, String masterSecret, List<String> amenities, Double roomCharges, Integer roomCapacity) {
        super(roomId, masterSecret);
        this.amenities = amenities;
        this.roomCapacity = roomCapacity;
        this.roomCharges = roomCharges;
    }

    @Override
    public List<String> getAmenities() {
        return this.amenities;
    }

    @Override
    public Double getRoomCharges() {
        return this.roomCharges;
    }

    @Override
    public Integer getRoomCapacity() {
        return this.roomCapacity;
    }
}
