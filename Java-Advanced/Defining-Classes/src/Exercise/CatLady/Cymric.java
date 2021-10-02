package Exercise.CatLady;

public class Cymric extends Cat {
    private double furLength;


    public Cymric(double furLength) {
        this.furLength = furLength;
    }

    public Cymric(String name, double furLength) {
        super(name);
        this.furLength = furLength;
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
        super.setParameter(furLength);
    }
}
