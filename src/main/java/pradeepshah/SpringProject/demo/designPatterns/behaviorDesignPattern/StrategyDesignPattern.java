package pradeepshah.SpringProject.demo.designPatterns.behaviorDesignPattern;




/*
strategy interface defines the drive behaviour contract,
*/


public class StrategyDesignPattern {
    public interface DriveStrategy{
        public void drive();
    }
    public static class NormalDerive implements DriveStrategy{
        @Override
        public void drive(){
            System.out.println("Normal Derive strategy");
        }
    }

    public static class SportsDrive implements DriveStrategy{
        @Override
        public void drive(){
            System.out.println("Sports Derive strategy");
        }
    }

    public static class EvDrive implements DriveStrategy{
        @Override
        public void drive(){
            System.out.println("Ev Derive strategy");
        }
    }

// context class holds the object of drive strategy class

    public static class Vehicle{
        DriveStrategy driveStrategy;

        public Vehicle(DriveStrategy driveStrategy){
            this.driveStrategy = driveStrategy;
        }
        public void drive(){
            System.out.println("\n" + this.getClass().getSimpleName()  + " : ");
            driveStrategy.drive();
        }
    }
// concrete context class

    public static class GoodsVehicle extends Vehicle{
        public GoodsVehicle(DriveStrategy driveStrategy){
            super(driveStrategy);
        }
    }


    public static class SportsVehicle extends Vehicle{
        public SportsVehicle(DriveStrategy driveStrategy){
            super(driveStrategy);
        }
    }

    public static class OffRoadVehicle extends Vehicle{
        public OffRoadVehicle(DriveStrategy driveStrategy){
            super(driveStrategy);
        }
    }
public static void main(String[] args){
    System.out.println("###### Strategy Design Pattern ######");
    System.out.println("###### Example: Vehicle Drive Modes: ####");

    Vehicle vehicle = new SportsVehicle(new SportsDrive());
    vehicle.drive();

    vehicle = new OffRoadVehicle(new NormalDerive());
    vehicle.drive();

    vehicle = new GoodsVehicle(new NormalDerive());
    vehicle.drive();

}

}
