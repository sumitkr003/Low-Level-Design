package parkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotSystem {
    private Map<String, ParkingLot> parkingLotIdToParkingLot;
    public ParkingLotSystem() {
        this.parkingLotIdToParkingLot = new HashMap<>();
    }

    public ParkingLot createParkingLot(String parkingLotId, Integer floors, Integer slotsPerFloor) {
        ParkingLot parkingLot = new ParkingLot(parkingLotId, floors, slotsPerFloor);
        parkingLotIdToParkingLot.put(parkingLotId, parkingLot);
        return parkingLot;
    }

    public String parkVehicle(String vehicleType, String regNumber, String color, String parkingLotId) throws Exception {
        ParkingLot parkingLot = parkingLotIdToParkingLot.get(parkingLotId);
        return parkingLot.parkVehicle(vehicleType, regNumber, color);
    }

    public void unParkVehicle(String ticketId, String parkingLotId) throws Exception {
        ParkingLot parkingLot = parkingLotIdToParkingLot.get(parkingLotId);
        parkingLot.unParkVehicle(ticketId);
    }

    public void display(String displayType, String vehicleType, String parkingLotId) throws Exception {
        ParkingLot parkingLot = parkingLotIdToParkingLot.get(parkingLotId);
        if(displayType.equals("free_count")) {
            parkingLot.displayFreeCount(vehicleType);
        } else if(displayType.equals("free_slots")) {
            parkingLot.displayFreeSlots(vehicleType);
        } else if(displayType.equals("occupied_slots")) {
            parkingLot.displayOccupiedSlots(vehicleType);
        }
    }
}
