package Problems.Elevator.entities;

public class Floor {
    public int floor;
    FloorButton button;

    public Floor(int floorNumber) {
        this.floor = floorNumber;
        this.button = new FloorButton();
    }
}
