public class Car {
    
    private String plateNumber;
    private String model;
    private double mileage;
    private double fuelLevel;
    private double tankCapacity;

   
    public Car(String plateNumber, String model, double startingFuelLevel, double tankCapacity) {
        this.plateNumber = plateNumber;
        this.model = model;
        this.mileage = 0.0; 
        this.fuelLevel = startingFuelLevel;
        this.tankCapacity = tankCapacity;
    }

    
    public void drive(double km) {
        
        double requiredFuel = km / 10.0; 

        if (requiredFuel > this.fuelLevel) {
            System.out.println("Not enough fuel for this trip!");
        } else {
            this.mileage += km;
            this.fuelLevel -= requiredFuel;
        }
    }

    
    public void refuel(double amount) {
        if (this.fuelLevel + amount > this.tankCapacity) {
            this.fuelLevel = this.tankCapacity;
            System.out.println("Tank is full, extra fuel discarded.");
        } else {
            this.fuelLevel += amount;
        }
    }

    
    public void checkStatus() {
        System.out.println("Current Mileage: " + this.mileage + " km");
        System.out.println("Current Fuel Level: " + this.fuelLevel + " liters");

        
        if (this.fuelLevel < (this.tankCapacity * 0.10)) {
            System.out.println("Low fuel warning!");
        }
    }

    
    public static void main(String[] args) {
       
        Car myCar = new Car("38 S 2026", "Toyota Corolla", 20.0, 50.0);

        System.out.println("--- INITIAL STATUS ---");
        myCar.checkStatus();

       
        System.out.println("\n--- Driving 120 km... ---");
        myCar.drive(120); 
        myCar.checkStatus();

       
        System.out.println("\n--- Refueling 20 liters... ---");
        myCar.refuel(20);
        myCar.checkStatus();

        
        System.out.println("\n--- EDGE CASE: Driving 500 km (Needs 50L, but we only have 28L) ---");
        myCar.drive(500); 
        
        
        System.out.println("\n--- EDGE CASE: Refueling 40 liters (Exceeds 50L tank capacity) ---");
        myCar.refuel(40); 
        myCar.checkStatus();

        
        System.out.println("\n--- Driving 460 km to trigger low fuel warning... ---");
        myCar.drive(460); 
        myCar.checkStatus();
    }
}