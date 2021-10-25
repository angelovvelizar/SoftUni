package Exercise.CatLady;

public class Siamese  extends  Cat{
    private double earSize;


    @Override
    public String getBreed() {
        return super.getBreed();
    }

    @Override
    public void setBreed(String breed) {
        super.setBreed(breed);
    }

    public Siamese(double earSize) {
        this.earSize = earSize;
    }

    public Siamese(String name, double earSize) {
        super(name);
        this.earSize = earSize;
    }

    @Override
    public double getParameter() {
        return super.getParameter();
    }

    @Override
    public void setParameter(double parameter) {
        super.setParameter(earSize);
    }
}
