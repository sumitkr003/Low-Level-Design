## Requirements
1. One building contains multiple floors and multiple elevators
2. Each floor contains two buttons to request elevators (UP or DOWN)
3. From inside the elevator user can click any floor button


### Entities
Building -> has -> floors
floors -> has -> external buttons
Elevator -> has -> internal buttons

### Action classes
ElevatorController
InternalButtonDispatcher
ExternalButtonDispatcher

### Strategy class
To assign an elevator optimally