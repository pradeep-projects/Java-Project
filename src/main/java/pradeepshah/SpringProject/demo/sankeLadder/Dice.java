package pradeepshah.SpringProject.demo.sankeLadder;

import java.util.Random;

public class Dice {

    int diceCount;

    public Dice( int diceCount){
        this.diceCount = diceCount;
    }

    public int rollDice(){
            Random rand = new Random();
            int num = rand.nextInt(6) + 1;
            return num;
    }

}
