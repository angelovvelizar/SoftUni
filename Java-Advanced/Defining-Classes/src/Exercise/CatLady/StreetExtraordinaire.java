package Exercise.CatLady;

public class StreetExtraordinaire extends  Cat{
    private double decibels;


    public StreetExtraordinaire(double decibels) {
        this.decibels = decibels;
    }

    public StreetExtraordinaire(String name, double decibels) {
        super(name);
        this.decibels = decibels;
    }

    @Override
    public void setBreed(String breed) {
        super.setBreed(breed);
    }

    @Override
    public String getBreed() {
        return super.getBreed();
    }

    @Override
    public double getParameter() {
        return super.getParameter();
    }

    @Override
    public void setParameter(double parameter) {
        super.setParameter(decibels);
    }
}
