package aquarium.entities.aquariums;

public class SaltwaterAquarium extends BaseAquarium {
    private static final int SALTWATER_AQUARIUM_CAPACITY = 25;

    public SaltwaterAquarium(String name) {
        super(name, SALTWATER_AQUARIUM_CAPACITY);
    }
}
