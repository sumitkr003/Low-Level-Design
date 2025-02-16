package Problems.Elevator.entities;

import java.util.List;

public class Building {
    List<Floor> floors;
    String buildingName;

    public Building(String name, int numFloors){
        this.buildingName = name;
        for(int i=0;i<=numFloors;i++){
            floors.add(new Floor(i));
        }
    }
}
