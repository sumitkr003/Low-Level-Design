package elevator.elevatorState;

import elevator.Elevator;

public class MoveDownElevatorState implements ElevatorState{

    @Override
    public void addFloorToMove(int floor, Elevator elevator) {
        if(elevator.getCurrFloor() < floor) {
            elevator.getUpStops().add(floor);
        } else if(elevator.getCurrFloor() > floor){
            elevator.getDownStops().add(floor);
        }
    }

    @Override
    public void openDoor(Elevator elevator) {
        System.out.println("Elevator Moving");
    }

    @Override
    public void closeDoor(Elevator elevator) {
        System.out.println("Elevator Moving");
    }

    @Override
    public void stop(Elevator elevator) {
        elevator.setCurrFloor(elevator.getDownStops().poll());
        if(elevator.getDownStops().isEmpty()) {
            if(!elevator.getUpStops().isEmpty()) {
                elevator.setElevatorState(new MoveUpElevatorState());
            } else {
                elevator.setElevatorState(new IdleElevatorState());
            }
        }
    }
}
