package elevator.elevatorState;

import elevator.Elevator;

public class IdleElevatorState implements ElevatorState{

    @Override
    public void addFloorToMove(int floor, Elevator elevator) {
        if(elevator.getCurrFloor() < floor) {
            elevator.getUpStops().add(floor);
            elevator.setElevatorState(new MoveUpElevatorState());
        } else if(elevator.getCurrFloor() > floor){
            elevator.getDownStops().add(floor);
            elevator.setElevatorState(new MoveDownElevatorState());
        }
    }

    @Override
    public void openDoor(Elevator elevator) {
        elevator.setElevatorState(new OpenElevatorState());
    }

    @Override
    public void closeDoor(Elevator elevator) {
        System.out.println("Elevator Not Open");
    }

    @Override
    public void stop(Elevator elevator) {
        System.out.println("Elevator Already Idle");
    }
}
