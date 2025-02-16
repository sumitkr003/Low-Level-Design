package Problems.Elevator.entities;

import java.util.List;
import java.util.UUID;

import Problems.Elevator.enums.constant;

public class Elevator {
    UUID elevatorId;
    int currentFloor;
    int capacity;
    int currentCapacity;
    ElevatorButton buttons;
    constant.ELEVATOR_STATE state;
    // these are list of floors where this elevator can go
    List<Floor> floors;
    

    public Elevator(List<Floor> floors, ElevatorButton buttons, int capacity){
        this.state = constant.ELEVATOR_STATE.IDLE;
        this.floors = floors;
        this.buttons = buttons;
        this.capacity = capacity;
        this.currentCapacity = this.capacity;
        if(this.floors.size() > 0){
            this.currentFloor = this.floors.get(0).floor;
        }
        this.elevatorId = UUID.randomUUID();
    }

    public void updateElevatorState(constant.ELEVATOR_STATE state){
        System.out.println("Elevator has now" + state.toString() + " state");
        this.state = state;
    }

    public void addCapacity(int num){
        this.currentCapacity += num;
        if(this.currentCapacity > this.capacity){
            System.out.println("Elevetor is overloaded");
        }
    }

    public void removeCapacity(int num){
        this.capacity -= num;
    }

    public void updateFloor(int f){
        this.currentFloor = f;
    }

    public int getRemainingCapacity(){
        return this.capacity - this.currentCapacity;
    }

    public int getCurrentFloor(){
        return this.currentFloor;
    }

    public void setCurrentFloor(int f){
        this.currentFloor = f;
        System.out.println("Elevator is at floor: " + f);
    }

    public constant.ELEVATOR_STATE getElevatorState(){
        return this.state;
    }

    public UUID getElevatorId(){
        return this.elevatorId;
    }

    public void buttonPress(int floor){
        this.buttons.buttonPress(elevatorId, floor);
    }
}
