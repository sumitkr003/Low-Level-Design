package parkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private String parkingLotId;
    private Map<Integer, Map<Integer, ParkingSlot>> floorToSlotToOccupiedMap;
    private Map<String, ParkingSlot> ticketIdToParkingSlot;

    public ParkingLot(String parkingLotId, Integer floors, Integer slotsPerFloor) {
        this.parkingLotId = parkingLotId;
        this.floorToSlotToOccupiedMap = new HashMap<>();
        for(int i = 1; i<=floors; i++) {
            floorToSlotToOccupiedMap.put(i, new HashMap<>());
            for(int slot = 1; slot<=slotsPerFloor; slot++) {
                VehicleType vehicleType = slot == 1 ? VehicleType.TRUCK : ((slot == 2 || slot == 3) ? VehicleType.BIKE : VehicleType.CAR);
                floorToSlotToOccupiedMap.get(i).put(slot, new ParkingSlot(slot, i, vehicleType));
            }
        }
        this.ticketIdToParkingSlot = new HashMap<>();
    }

    public String parkVehicle(String vehicleType, String regNumber, String color) throws Exception {
        VehicleType vh = validateVehicleType(vehicleType);
        ParkingSlot parkingSlot = findFreeParkingSlot(vh);
        if(parkingSlot == null) {
            throw new Exception("Parking Lot Full");
        }
        String ticketId =  parkingSlot.park(vh, regNumber, color, this.parkingLotId);
        this.ticketIdToParkingSlot.put(ticketId, parkingSlot);
        System.out.println("Parked vehicle. Ticket ID: " + ticketId);
        return ticketId;
    }

    private VehicleType validateVehicleType(String vehicleType) throws Exception {
        VehicleType vh = VehicleType.getVehicleType(vehicleType);
        if(vh == null) {
            throw new Exception("Invalid Vehicle Type : " + vehicleType);
        }
        return vh;
    }

    private ParkingSlot findFreeParkingSlot(VehicleType vehicleType) {
        for(Integer floor : floorToSlotToOccupiedMap.keySet()) {
            for(ParkingSlot ps : floorToSlotToOccupiedMap.get(floor).values()) {
                if(ps.isFreeForVehicleType(vehicleType)) {
                    return ps;
                }
            }
        }
        return null;
    }

    public void unParkVehicle(String ticketId) throws Exception {
        ParkingSlot parkingSlot = this.ticketIdToParkingSlot.get(ticketId);
        if(parkingSlot == null) {
            throw new Exception("Invalid Ticket");
        }
        parkingSlot.unPark();
        this.ticketIdToParkingSlot.put(ticketId, null);
        System.out.println("Unparked Vehicle with ticket Number : " + ticketId);
        return;
    }

    public void displayFreeCount(String vehicleType) {
        DisplayBoard.displayFreeCount(this.floorToSlotToOccupiedMap, VehicleType.getVehicleType(vehicleType));
    }

    public void displayFreeSlots(String vehicleType) {
        DisplayBoard.displayFreeSlots(this.floorToSlotToOccupiedMap, VehicleType.getVehicleType(vehicleType));
    }

    public void displayOccupiedSlots(String vehicleType) {
        DisplayBoard.displayOccupiedSlots(this.floorToSlotToOccupiedMap, VehicleType.getVehicleType(vehicleType));
    }
}
