package parkingLot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DisplayBoard {
    public static void displayFreeCount(Map<Integer, Map<Integer, ParkingSlot>> floorToSlotToOccupiedMap, VehicleType vehicleType) {
        for(Integer floor : floorToSlotToOccupiedMap.keySet()) {
            Integer freeCount = 0;
            for(ParkingSlot parkingSlot : floorToSlotToOccupiedMap.get(floor).values()) {
                if(parkingSlot.isFreeForVehicleType(vehicleType)) {
                    freeCount++;
                }
            }
            System.out.println("No. of free slots for " +  vehicleType.name() + " on Floor " + floor +" : " + freeCount);
        }
    }

    public static void displayFreeSlots(Map<Integer, Map<Integer, ParkingSlot>> floorToSlotToOccupiedMap, VehicleType vehicleType) {
        for(Integer floor : floorToSlotToOccupiedMap.keySet()) {
            List<String> freeSlots = new ArrayList<>();
            for (ParkingSlot parkingSlot : floorToSlotToOccupiedMap.get(floor).values()) {
                for (VehicleType vh : VehicleType.values()) {
                    if (parkingSlot.getVehicleType() == vehicleType && parkingSlot.isFreeForVehicleType(vh)) {
                        freeSlots.add(String.valueOf(parkingSlot.getParkingLotId()));
                    }
                }
            }
            System.out.println("Free slots for " + vehicleType.name() + " on Floor " + floor + " : " + String.join(",", freeSlots));
        }
    }

    public static void displayOccupiedSlots(Map<Integer, Map<Integer, ParkingSlot>> floorToSlotToOccupiedMap, VehicleType vehicleType) {
        for(Integer floor : floorToSlotToOccupiedMap.keySet()) {
            List<String> occupiedSlots = new ArrayList<>();
            for (ParkingSlot parkingSlot : floorToSlotToOccupiedMap.get(floor).values()) {
                if (parkingSlot.getVehicleType() == vehicleType && parkingSlot.isOccupied()) {
                    occupiedSlots.add(String.valueOf(parkingSlot.getParkingLotId()));
                }
            }
            System.out.println("Occupied slots for " + vehicleType.name() + " on Floor " + floor + " : " + String.join(",", occupiedSlots));
        }
    }
}
