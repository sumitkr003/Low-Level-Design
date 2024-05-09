package parkingLot;

import java.util.Scanner;

public class ParkingLotDriver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ParkingLotSystem parkingLotSystem = new ParkingLotSystem();

        while(true) {
            String line = in.nextLine();
            String[] operands = line.split(" ");
            ParkingLotOperations operation = ParkingLotOperations.getParkingLotOperation(operands[0]);
            try {
                switch (operation) {
                    case CREATE_PARKING_LOT:
                        parkingLotSystem.createParkingLot(operands[1], Integer.parseInt(operands[2]),
                                Integer.parseInt(operands[3]));
                        break;
                    case PARK:
                        parkingLotSystem.parkVehicle(operands[1], operands[2], operands[3], operands[4]);
                        break;
                    case UN_PARK:
                        parkingLotSystem.unParkVehicle(operands[1], operands[3]);
                        break;
                    case DISPLAY:
                        parkingLotSystem.display(operands[1], operands[2], operands[3]);
                        break;
                    case EXIT:
                        return;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

//create_parking_lot PR1234 2 6
//display free_count CAR PR1234
//display free_count BIKE PR1234
//display free_count TRUCK PR1234
//display free_slots CAR PR1234
//display free_slots BIKE PR1234
//display free_slots TRUCK PR1234
//display occupied_slots CAR PR1234
//display occupied_slots BIKE PR1234
//display occupied_slots TRUCK PR1234
//park_vehicle CAR KA-01-DB-1234 black PR1234
//park_vehicle CAR KA-02-CB-1334 red PR1234
//park_vehicle CAR KA-01-DB-1133 black PR1234
//park_vehicle CAR KA-05-HJ-8432 white PR1234
//park_vehicle CAR WB-45-HO-9032 white PR1234
//park_vehicle CAR KA-01-DF-8230 black PR1234
//park_vehicle CAR KA-21-HS-2347 red PR1234
//display free_count CAR PR1234
//display free_count BIKE PR1234
//display free_count TRUCK PR1234
//unpark_vehicle PR1234_2_5 PR1234
//unpark_vehicle PR1234_2_5 PR1234
//unpark_vehicle PR1234_2_7 PR1234
//display free_count CAR PR1234
//display free_count BIKE PR1234
//display free_count TRUCK PR1234
//display free_slots CAR PR1234
//display free_slots BIKE PR1234
//display free_slots TRUCK PR1234
//display occupied_slots CAR PR1234
//display occupied_slots BIKE PR1234
//display occupied_slots TRUCK PR1234
//park_vehicle BIKE KA-01-DB-1541 black PR1234
//park_vehicle TRUCK KA-32-SJ-5389 orange PR1234
//park_vehicle TRUCK KL-54-DN-4582 green PR1234
//park_vehicle TRUCK KL-12-HF-4542 green PR1234
//display free_count CAR PR1234
//display free_count BIKE PR1234
//display free_count TRUCK PR1234
//display free_slots CAR PR1234
//display free_slots BIKE PR1234
//display free_slots TRUCK PR1234
//display occupied_slots CAR PR1234
//display occupied_slots BIKE PR1234
//display occupied_slots TRUCK PR1234
//exit
