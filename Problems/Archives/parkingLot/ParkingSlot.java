package parkingLot;

public class ParkingSlot {
    private Integer parkingLotId;
    private Integer floor;
    private boolean free;
    private Vehicle vehicle;
    private String ticketId;
    private VehicleType vehicleType;

    public ParkingSlot(Integer parkingLotId, Integer floor, VehicleType vehicleType) {
        this.parkingLotId = parkingLotId;
        this.floor = floor;
        this.vehicleType = vehicleType;
        this.free = true;
    }

    public boolean isFreeForVehicleType(VehicleType vehicleType) {
        return this.free && ((this.parkingLotId == 1 && VehicleType.TRUCK == vehicleType) || (this.parkingLotId == 2
                && VehicleType.BIKE == vehicleType) || (this.parkingLotId == 3 && VehicleType.BIKE == vehicleType) || (
                this.parkingLotId > 3 && VehicleType.CAR == vehicleType));
    }

    public boolean isOccupied() {
        return !this.free;
    }

    public String park(VehicleType vehicleType, String regNo, String color, String parkingSlotId) {
        Vehicle vehicle = new Vehicle();
        String ticketId = String.join("_", parkingSlotId, floor+"", this.parkingLotId+"");
        vehicle.color = color;
        vehicle.vehicleNumber = regNo;
        vehicle.ticketId = ticketId;
        vehicle.type = vehicleType;
        this.vehicle = vehicle;
        this.free = false;
        this.ticketId = ticketId;
        return ticketId;
    }

    public void unPark() {
        this.vehicle = null;
        this.free = true;
        this.ticketId = null;
    }

    public Integer getParkingLotId() {
        return (this.parkingLotId);
    }

    public VehicleType getVehicleType() {
        return (this.vehicleType);
    }
}
