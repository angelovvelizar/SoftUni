package glacialExpedition.models.explorers;

import glacialExpedition.models.suitcases.Carton;
import glacialExpedition.models.suitcases.Suitcase;

import static glacialExpedition.common.ExceptionMessages.EXPLORER_ENERGY_LESS_THAN_ZERO;
import static glacialExpedition.common.ExceptionMessages.EXPLORER_NAME_NULL_OR_EMPTY;

public class BaseExplorer implements Explorer {
    private String name;
    private double energy;
    private Suitcase suitcase;

    protected BaseExplorer(String name, double energy) {
        this.setName(name);
        this.setEnergy(energy);
        this.suitcase = new Carton();
        //TODO: initialize suitcase;
    }

    protected void setEnergy(double energy) {
        if(energy < 0){
            throw new IllegalArgumentException(EXPLORER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    private void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(EXPLORER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }

    @Override
    public boolean canSearch() {
        return this.energy > 0;
    }

    @Override
    public Suitcase getSuitcase() {
        return this.suitcase;
    }

    @Override
    public void search() {
        if(this.getEnergy() - 15 >= 0){
            this.setEnergy(this.getEnergy() - 15);
        }else{
            this.setEnergy(0);
        }
    }
}
