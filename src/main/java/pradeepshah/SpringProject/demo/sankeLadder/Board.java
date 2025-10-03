package pradeepshah.SpringProject.demo.sankeLadder;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class Board {
    Cell[][] cells;

    Board(Integer boardSize, int numberOfSnakes, int numberOfLadders) {
        initializeCells(boardSize);
        addSnakeAndLadders(cells, numberOfSnakes, numberOfLadders);
    }

    private void initializeCells(int boardSize) {
        cells = new Cell[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    private void addSnakeAndLadders(Cell[][] cells, int numberOfSnakes, int numberOfLadders) {
        while (numberOfSnakes > 0) {
            int snakeHead = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            if (snakeHead >= snakeTail) {
                continue;
            }
            Jump snakeObj = new Jump(snakeHead, snakeTail);
            Cell cell = getCell(snakeHead);
            cell.jump = snakeObj;
            numberOfSnakes--;
        }

        // initialize ladders
        while (numberOfLadders > 0) {
            int ladderStart = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            int ladderEnd = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            if (ladderEnd >= ladderStart) {
                continue;
            }
            Jump snakeObj = new Jump(ladderStart, ladderEnd);
            Cell cell = getCell(ladderStart);
            cell.jump = snakeObj;
            numberOfLadders--;
        }
    }

    public Cell getCell(int idx) {
        int row = idx / cells.length;
        int column = idx % cells.length;
        return cells[row][column];
    }

//    @Data
//    public Data Person{
//        int age;
//        String name;
//        public Person( String name,int age){
//            this.age = age;
//            this.name = name;
//        }
//
//
//
//    }
//
//    public void streamOperation(){
//        List<Integer> a = Arrays.asList(1,2,3,4,5,6,7);
//
//        Stream str = Stream.of(a);
//
//        int maxElem = str.map(a -> a*3)
//                .filter(b -> b%2==0).max(Integer::compare);
//
//        List<Person> persons = Arrays.asList(
//                new Person("Alice", 25),
//                new Person("Bob", 30),
//                new Person("Charlie", 35),
//                new Person("Aman", 35),
//                new Person("Aman", 35),
//                new Person("Aman", 36),
//                new Person("Charlie", 36),
//                new Person("Kartik", 36)
//        );
//        Stream personStream = Stream.of(persons);
//
//        List<Person> uniquePerson = personStream.collect(p -> p.getName() + "_" + p.getAge());
//
//    }

}
