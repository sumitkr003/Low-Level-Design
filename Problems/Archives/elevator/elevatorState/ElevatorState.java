package elevator.elevatorState;

import elevator.Elevator;

public interface ElevatorState {
    void addFloorToMove(int floor, Elevator elevator);
    void openDoor(Elevator elevator);
    void closeDoor(Elevator elevator);
    void stop(Elevator elevator);
}
