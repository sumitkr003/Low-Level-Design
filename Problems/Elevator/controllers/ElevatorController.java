package Problems.Elevator.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.UUID;

import Problems.Elevator.builder.ElevatorBuilder;
import Problems.Elevator.entities.Elevator;
import Problems.Elevator.enums.constant;

public class ElevatorController {
    private Elevator elevator;
    private ElevatorBuilder builder;
    // when elevator is going up and request floor is above current floor then add to minQ
    private PriorityQueue<Integer> minQ;
    // when elevator is going down and requested Floor is below current floor then add to maxQ
    private PriorityQueue<Integer> maxQ;
    // when elevator is going up and requested floor is below current floor
    // or when elevator is going down and requested floor is above current floor
    private HashMap<constant.DIRECTION, List<Integer>> pendingRequests;

    public ElevatorController(int capacity, int minFloors, int maxFloors){
        this.builder = new ElevatorBuilder();
        this.builder = this.builder.addButtons().addCapacity(100);
        for(int i=minFloors;i<=maxFloors;i++){
            this.builder = this.builder.addFloor(i);
        }
        elevator = this.builder.build();
        this.minQ = new PriorityQueue<>();
        this.maxQ = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        this.pendingRequests = new HashMap<>();
        this.pendingRequests.put(constant.DIRECTION.DOWN, new ArrayList<>());
        this.pendingRequests.put(constant.DIRECTION.UP, new ArrayList<>());
    }

    public UUID getElevatorId(){
        return this.elevator.getElevatorId();
    }

    public boolean hasAnyRequest(){
        return this.pendingRequests.get(constant.DIRECTION.UP).size() > 0 || this.pendingRequests.get(constant.DIRECTION.UP).size() > 0;
    }

    public void changeDirection(){
        if(this.elevator.getElevatorState() == constant.ELEVATOR_STATE.UP){
            for(int val: pendingRequests.get(constant.DIRECTION.DOWN)){
                this.maxQ.add(val);
            }
            this.pendingRequests.put(constant.DIRECTION.DOWN, new ArrayList<>());
            this.elevator.updateElevatorState(constant.ELEVATOR_STATE.DOWN);
        }else if(this.elevator.getElevatorState() == constant.ELEVATOR_STATE.DOWN){
            for(int val: pendingRequests.get(constant.DIRECTION.UP)){
                this.minQ.add(val);
            }
            this.pendingRequests.put(constant.DIRECTION.UP, new ArrayList<>());
            this.elevator.updateElevatorState(constant.ELEVATOR_STATE.DOWN);
        }
        System.out.println("Elevator is changing direction");
    }

    public void move(){
        while(true){
            if(this.elevator.getElevatorState() == constant.ELEVATOR_STATE.DOWN){
                while(!this.maxQ.isEmpty()){
                    this.elevator.setCurrentFloor(this.maxQ.poll());
                }
            }
            if(hasAnyRequest()) changeDirection();

            if(this.elevator.getElevatorState() == constant.ELEVATOR_STATE.UP){
                while(!this.minQ.isEmpty()){
                    this.elevator.setCurrentFloor(this.minQ.poll());
                }
            }
            if(hasAnyRequest()) changeDirection();

            if(!hasAnyRequest() && this.minQ.isEmpty() && this.maxQ.isEmpty()){
                this.elevator.updateElevatorState(constant.ELEVATOR_STATE.IDLE);
                break;
            }
        }
    }

    private void assignFloor(int floor, constant.DIRECTION dir){
        if(this.elevator.getCurrentFloor() > floor && dir == constant.DIRECTION.DOWN){
            this.maxQ.add(floor);
        }else if(this.elevator.getCurrentFloor() < floor && dir == constant.DIRECTION.UP){
            this.minQ.add(floor);
        }else{
            this.pendingRequests.get(dir).add(floor);
        }
    }

    public void assignFloorFromInside(int floor){
        if(this.elevator.getCurrentFloor() == floor){
            System.out.println("Pressing same floor button");
        }
        if(this.elevator.getCurrentFloor() > floor){
            assignFloor(floor, constant.DIRECTION.DOWN);
        }else{
            assignFloor(floor, constant.DIRECTION.UP);
        }
    }

    public void assignFloorFromOutside(int floor, constant.DIRECTION dir){
        assignFloor(floor, dir);
    }

}
