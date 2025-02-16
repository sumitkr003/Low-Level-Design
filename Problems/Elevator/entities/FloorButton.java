package Problems.Elevator.entities;

import Problems.Elevator.ElevatorService;
import Problems.Elevator.enums.constant;

public class FloorButton {
    // implement this method
    // find an elevator and to that elevator send this request
    public void buttonPress(int floor, constant.DIRECTION dir){
        ElevatorService.externalButtonPress(floor, dir);
    }
}
