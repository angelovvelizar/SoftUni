package Exercise.SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostFor1Km;
    private int distanceTraveled;


    public Car(String model,double fuelAmount, double fuelCostFor1Km, int distanceTraveled){
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1Km = fuelCostFor1Km;
        this.distanceTraveled = distanceTraveled;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public void canMove(int amountOfKm){
        if(amountOfKm * this.fuelCostFor1Km > fuelAmount){
            System.out.println("Insufficient fuel for the drive");
        }else {
            distanceTraveled += amountOfKm;
            fuelAmount = fuelAmount - (amountOfKm * this.fuelCostFor1Km);
        }

    }

    public double getFuelAmount(){
        return  fuelAmount;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount,this.distanceTraveled);
    }
}
