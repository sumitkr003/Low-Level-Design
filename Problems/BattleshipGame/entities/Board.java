package Problems.BattleshipGame.entities;

import Problems.BattleshipGame.entities.ships.Ship;
import Problems.BattleshipGame.entities.ships.ShipFactory;
import Problems.BattleshipGame.enums.Direction;
import Problems.BattleshipGame.enums.ShipType;

public class Board {
    int boardSize;
    Cell [][] board;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        this.board = new Cell[boardSize][boardSize];
        intializeBoard();
    }

    private void intializeBoard() {
        for(int i = 0; i<boardSize; i++) {
            for(int j = 0; j<boardSize; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    private boolean checkOutOfBounds(int x, int y) throws Exception{
        return x<0 || x>=boardSize || y<0 || y>=boardSize;
    }

    private boolean canPlaceShip(int x, int y, Ship ship, Direction.Value direction) throws Exception {
        int size = ship.getShipSize();
        if(checkOutOfBounds(x, y)) {
            throw new Exception("Invalid Coordinates");
        }
        if(direction == Direction.Value.DOWN) {
            if(y+size > boardSize) {
                throw new Exception("Cannot place the ship here");
            }
        } else if(direction == Direction.Value.RIGHT) {
            if(x+size > boardSize) {
                throw new Exception("Cannot place the ship here");
            }
        }
        return true;
    }

    private boolean isShipAlreadyPlaced(int x, int y, int size, Direction.Value direction){
        for(int i = 0; i<size; i++) {
            int updatedX = direction == Direction.Value.DOWN ? x+i : x;
            int updatedY = direction == Direction.Value.DOWN ? y : y+i;
            if(board[updatedX][updatedY].getShip() != null) return true;
        }
        return false;
    }

    public void placeShip(int x, int y, ShipType.Type shipType, Direction.Value direction) throws Exception {
        Ship ship = ShipFactory.getShip(shipType);
        int size = ship.getShipSize();
        if(!canPlaceShip(x, y, ship, direction)) return;
        if(isShipAlreadyPlaced(x, y, size, direction)){
            throw new Exception("A ship is already placed. Please change direction or co-ordinates");
        }
        for(int i = 0; i<size; i++) {
            int updatedX = direction == Direction.Value.DOWN ? x+i : x;
            int updatedY = direction == Direction.Value.DOWN ? y : y+i;
            board[updatedX][updatedY].setShip(ship);
        }
    }

    public boolean throwMissile(int x, int y) throws Exception{
        if(checkOutOfBounds(x, y)) throw new Exception("Invalid co-ordinates");
        Cell cell = board[x][y];
        if(cell.isAttacked()){
            throw new Exception("This cell is already destryoyed, please throw missile at some other co-ordinates");
        }
        if(cell.getShip() != null){
            cell.setAttecked(true);
            return true;
        }
        return false;
    }

    public boolean hasAnyShipRemaining(){
        for(int i=0;i<this.boardSize;i++){
            for(int j=0;j<this.boardSize;j++){
                Cell cell = board[i][j];
                if(cell.getShip() != null && !cell.isAttacked()) return true;
            }
        }
        return false;
    }

    public void printBoard(){
        System.out.println();
        System.out.println("++++++++++++++++ PRINTING BOARD +++++++++++++++++++++");

        for(int i=0;i<this.boardSize;i++){
            for(int j=0;j<this.boardSize;j++){
                Cell cell = board[i][j];
                if(cell.isAttacked()){
                    System.out.print("A ");
                }else if(cell.getShip() != null){
                    System.out.print("S ");
                }else{
                    System.out.print("N ");
                }
            }
            System.out.println();
        }
    }
    
}
