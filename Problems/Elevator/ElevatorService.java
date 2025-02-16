package Problems.Elevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import Problems.Elevator.controllers.ElevatorController;
import Problems.Elevator.enums.constant;

public class ElevatorService {
    private static List<ElevatorController> controllers = new ArrayList<>();

    public ElevatorService(int numElevators){
        for(int i=0;i<numElevators;i++){
            ElevatorService.controllers.add(new ElevatorController(100, 0, 25));
        }
    }

    public static void internalButtonPress(UUID elevatorId, int floor){
        Optional<ElevatorController> controller = ElevatorService.controllers.stream()
        .filter(elevator -> elevator.getElevatorId() == elevatorId)
        .findFirst();
        controller.ifPresentOrElse((c) -> c.assignFloorFromInside(floor), () -> System.out.println("No elevator found with this id"));
    }

    public static void externalButtonPress(int floor, constant.DIRECTION dir){
        // find elevator
        // then press that elevator button
    }
}
