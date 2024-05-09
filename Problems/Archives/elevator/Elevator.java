package elevator;

import elevator.elevatorState.ElevatorState;
import elevator.elevatorState.IdleElevatorState;
import java.util.PriorityQueue;
import java.util.UUID;

public class Elevator {
    private String elevatorId;
    private ElevatorState elevatorState;
    private Integer currFloor;
    private PriorityQueue<Integer> upStops;
    private PriorityQueue<Integer> downStops;
    private Integer maxCapacity;
    private Integer currCapacity;

    public Elevator(Integer maxCapacity) {
        this.elevatorId = UUID.randomUUID().toString();
        this.elevatorState = new IdleElevatorState();
        this.currFloor = 1;
        this.maxCapacity = maxCapacity;
        this.currCapacity = 0;
        upStops = new PriorityQueue<>();
        downStops = new PriorityQueue<>((a,b) -> b-a);
    }

    public String getElevatorId() {
        return elevatorId;
    }

    public ElevatorState getElevatorState() {
        return elevatorState;
    }

    public Integer getCurrFloor() {
        return currFloor;
    }

    public PriorityQueue<Integer> getUpStops() {
        return upStops;
    }

    public PriorityQueue<Integer> getDownStops() {
        return downStops;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public Integer getCurrCapacity() {
        return currCapacity;
    }

    public void setElevatorState(ElevatorState elevatorState) {
        this.elevatorState = elevatorState;
    }

    public void setCurrFloor(Integer currFloor) {
        this.currFloor = currFloor;
    }

    public void setCurrCapacity(Integer currCapacity) {
        this.currCapacity = currCapacity;
    }
}
