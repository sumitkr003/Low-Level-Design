package Problems.Elevator.entities;

import java.util.UUID;

import Problems.Elevator.ElevatorService;

public class ElevatorButton {
    public void buttonPress(UUID floorId, int floor){
        ElevatorService.internalButtonPress(floorId, floor);
    }
}
