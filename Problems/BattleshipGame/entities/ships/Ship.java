package Problems.BattleshipGame.entities.ships;

import Problems.BattleshipGame.enums.ShipType;

public abstract class Ship {
    ShipType.Type shipType;
    int shipSize;

    public Ship(ShipType.Type shipType, int shipSize) {
        this.shipType = shipType;
        this.shipSize = shipSize;
    }

    public String getShipType(){
        return shipType.toString();
    };

    public int getShipSize(){
        return shipSize;
    }
}