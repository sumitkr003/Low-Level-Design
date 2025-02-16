package Problems.BattleshipGame.entities;
import Problems.BattleshipGame.entities.ships.Ship;

public class Cell {
    private boolean isAttacked;
    private Ship ship;

    public Cell(){
        this.isAttacked = false;
        this.ship = null;
    }

    public boolean isAttacked() {
        return isAttacked;
    }

    public void setAttecked(boolean isAttacked) {
        this.isAttacked = isAttacked;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
}
