package pradeepshah.SpringProject.demo.sankeLadder;

import pradeepshah.SpringProject.demo.Config.LoggerConfig;

import java.util.Deque;
import java.util.LinkedList;
import java.util.logging.Logger;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> players = new LinkedList<>();

    Player winner;

    LoggerConfig logger = LoggerConfig.getLoggerInstance();

    public Game() {
        InitializeBoard();
    }

    private void InitializeBoard() {
        // board initialization
        winner = null;
        board = new Board(10,5,4);
        dice = new Dice(1);
        addPlayers();
    }

    public void addPlayers(){
        players.add(new Player(1,0));
        players.add(new Player(2,0));
    }

    public void startGame(){
        while (winner == null){
            // check whose turn now
            Player playerTurn = findPlayerTurn();
            logger.info("Player turn is " + playerTurn.id + " current position is: " + playerTurn.position);

            // roll dice
            int diceNumber = dice.rollDice();
            int newPosition = playerTurn.position + diceNumber;
            newPosition = jumCheck(newPosition);
            playerTurn.position = newPosition;
            logger.info("player turn is: " + playerTurn.id + " new position " + playerTurn.position);
            if(newPosition >= board.cells.length * board.cells.length - 1){
                winner = playerTurn;
            }
        }
        logger.info("Winner is: "+ winner.id);
    }
    public Player findPlayerTurn(){
        Player player = players.removeFirst();
        players.addLast(player);
        return player;
    }
    public int jumCheck(int position){
        if(position > board.cells.length * board.cells.length - 1){
            return position;
        }
        Cell cell = board.getCell(position);
        if(cell.jump!=null && cell.jump.start == position){
            String jumpBy =  cell.jump.start < cell.jump.end ? "ladder" : "snake";
            logger.info("jump done by: " + jumpBy);
            position = cell.jump.end;
        }
        return position;
    }
}
