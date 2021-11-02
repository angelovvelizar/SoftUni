package Exercise.PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight){
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setWeight(double weight) {
        if(weight <= 0 || weight > 200){
            throw new IllegalArgumentException("Dough weight should be in the range [1...200].");
        }

        this.weight = weight;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if(!bakingTechnique.equals("Crispy") && !bakingTechnique.equals("Chewy") && !bakingTechnique.equals("Homemade")){
            throw new IllegalArgumentException("Invalid type of dough.");
        }

        this.bakingTechnique = bakingTechnique;
    }

    private void setFlourType(String flourType) {
        if(!flourType.equals("White") && !flourType.equals("Wholegrain")){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    public double calculateCalories(){
        double flourModifier = 0;
        switch (this.flourType){
            case "White":
                flourModifier = 1.5;
                break;
            case "Wholegrain":
                flourModifier = 1.0;
                break;
        }

        double bakingModifier = 0;
        switch (this.bakingTechnique){
            case "Crispy":
                bakingModifier = 0.9;
                break;
            case "Chewy":
                bakingModifier = 1.1;
                break;
            case "Homemade":
                bakingModifier = 1.0;
                break;
        }

        return (2 * this.weight) * flourModifier * bakingModifier;
    }
}
