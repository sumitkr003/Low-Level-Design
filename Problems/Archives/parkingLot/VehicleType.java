package parkingLot;

public enum VehicleType {
    CAR,
    BIKE,
    TRUCK;

    public static VehicleType getVehicleType(String vehicleType) {
        for(VehicleType curr : VehicleType.values()) {
            if(curr.name().equals(vehicleType)) {
                return curr;
            }
        }
        return null;
    }
}
