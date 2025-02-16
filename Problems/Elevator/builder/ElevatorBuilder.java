package Problems.Elevator.builder;

import java.util.Collections;
import java.util.List;

import Problems.Elevator.entities.Floor;
import Problems.Elevator.entities.Elevator;
import Problems.Elevator.entities.ElevatorButton;

public class ElevatorBuilder {
    private ElevatorButton buttons;
    private int capacity;
    private List<Floor> floors;

    public ElevatorBuilder addButtons(){
        this.buttons = new ElevatorButton();
        return this;
    }

    public ElevatorBuilder addCapacity(int capacity){
        this.capacity = capacity;
        return this;
    }
    
    public ElevatorBuilder addFloor(int floor){
        this.floors.add(new Floor(floor));
        Collections.sort(this.floors, (a, b) -> Integer.compare(a.floor, b.floor));
        return this;
    }

    public Elevator build(){
        return new Elevator(this.floors, this.buttons, this.capacity);
    }
}
