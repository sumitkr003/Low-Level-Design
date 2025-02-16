package Problems.BattleshipGame.entities.ships;

import Problems.BattleshipGame.enums.ShipType;

public class ShipFactory {
    public static Ship getShip(ShipType.Type shipType) throws Exception {
        switch (shipType) {
            case ShipType.Type.Carrier:
                return new Carrier();
            case ShipType.Type.Battleship:
                return new BattleShip();
            case ShipType.Type.Cruiser:
                return new Cruiser();
            case ShipType.Type.Submarine:
                return new SubMarine();
            case ShipType.Type.Destroyer:
                return new Destroyer();
            default:
                throw new Exception("Invalid Ship Type");
        }
    }
}
