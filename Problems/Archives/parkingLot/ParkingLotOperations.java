package parkingLot;

public enum ParkingLotOperations {
    CREATE_PARKING_LOT("create_parking_lot"),
    PARK("park_vehicle"),
    UN_PARK("unpark_vehicle"),
    DISPLAY("display"),
    EXIT("exit");

    String operation;
    ParkingLotOperations(String op) {
        this.operation = op;
    }
    public static ParkingLotOperations getParkingLotOperation(String parkingLotOperation) {
        for(ParkingLotOperations curr : ParkingLotOperations.values()) {
            if(curr.operation.equals(parkingLotOperation)) {
                return curr;
            }
        }
        return null;
    }
}
