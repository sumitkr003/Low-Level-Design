package elevator.elevatorState;

import elevator.Elevator;

public class OpenElevatorState implements ElevatorState{

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
        System.out.println("Elevator Already Open");
    }

    @Override
    public void closeDoor(Elevator elevator) {
        if(elevator.getUpStops().isEmpty() && elevator.getDownStops().isEmpty()) {
            elevator.setElevatorState(new IdleElevatorState());
        } else if(!elevator.getUpStops().isEmpty()) {
            elevator.setElevatorState(new MoveUpElevatorState());
        } else if(!elevator.getDownStops().isEmpty()){
            elevator.setElevatorState(new MoveDownElevatorState());
        }
    }

    @Override
    public void stop(Elevator elevator) {
        System.out.println("Currently elevator is already stopped and open");
    }
}
