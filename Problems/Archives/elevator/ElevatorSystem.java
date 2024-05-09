package elevator;

import java.util.HashMap;

public class ElevatorSystem {
    private HashMap<String, Elevator> elevatorMap;
    private Integer floors;

    public ElevatorSystem(Integer elevators, Integer floors, Integer maxCapacity) {
        this.floors = floors;
        elevatorMap = new HashMap<>();
        for(int i = 0; i<elevators; i++) {
            Elevator elevator = new Elevator(maxCapacity);
            elevatorMap.put(elevator.getElevatorId(), elevator);
        }
    }

    public Elevator assignElevator(Integer floor, boolean up) {
        // assign already going up elevator if any, otherwise nearest Idle State Elevator, and change elevator state accordingly.
        return null;
    }

    public void addFloor(String elevatorId, int floor) {
        Elevator elevator = elevatorMap.get(elevatorId);
        elevator.getElevatorState().addFloorToMove(floor, elevator);
    }

    public void stop(String elevatorId) {
        Elevator elevator = elevatorMap.get(elevatorId);
        elevator.getElevatorState().stop(elevator);
    }

    public void openDoor(String elevatorId) {
        Elevator elevator = elevatorMap.get(elevatorId);
        elevator.getElevatorState().openDoor(elevator);
    }

    public void closeDoor(String elevatorId) {
        Elevator elevator = elevatorMap.get(elevatorId);
        elevator.getElevatorState().closeDoor(elevator);
    }
}
