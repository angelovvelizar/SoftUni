package aquarium.core;

import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.List;

import static aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private DecorationRepository decorations = new DecorationRepository();
    private List<Aquarium> aquariums = new ArrayList<>();


    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        if (!aquariumType.equals("FreshwaterAquarium") && !aquariumType.equals("SaltwaterAquarium")) {
            throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }
        if (aquariumType.equals("FreshwaterAquarium")) {
            this.aquariums.add(new FreshwaterAquarium(aquariumName));
        } else {
            this.aquariums.add(new SaltwaterAquarium(aquariumName));
        }
        return "Successfully added " + aquariumType + ".";
    }

    @Override
    public String addDecoration(String type) {
        if (!type.equals("Ornament") && !type.equals("Plant")) {
            throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }

        if (type.equals("Ornament")) {
            this.decorations.add(new Ornament());
        } else {
            this.decorations.add(new Plant());
        }
        return "Successfully added " +
                type + ".";
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration decoration = this.decorations.findByType(decorationType);
        if (decoration == null) {
            throw new IllegalArgumentException("There isn't a decoration of type " + decorationType + ".");
        }

        Aquarium aquarium = getAquarium(aquariumName);
        aquarium.addDecoration(decoration);
        this.decorations.remove(decoration);

        return "Successfully added " + decorationType + " to " + aquariumName + ".";
    }

    private Aquarium getAquarium(String aquariumName) {
        return this.aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().orElse(null);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        if (!fishType.equals("FreshwaterFish") && !fishType.equals("SaltwaterFish")) {
            throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }
        Aquarium aquarium = getAquarium(aquariumName);

        if (fishType.equals("FreshwaterFish")) {
            if (aquarium instanceof SaltwaterAquarium) {
                return "Water not suitable.";
            }
            aquarium.addFish(new FreshwaterFish(fishName, fishSpecies, price));
        } else {
            if (aquarium instanceof FreshwaterAquarium) {
                return "Water not suitable.";
            }
            aquarium.addFish(new SaltwaterFish(fishName, fishSpecies, price));
        }

        return "Successfully added " + fishType + " to " + aquariumName + ".";
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = getAquarium(aquariumName);
        aquarium.feed();
        int fedCount = aquarium.getFish().size();
        return "Fish fed: " + fedCount;
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = getAquarium(aquariumName);

        double decorationsSum = aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();
        double fishSum = aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum();
        double totalSum = decorationsSum + fishSum;

        return String.format("The value of Aquarium %s is %.2f.", aquariumName, totalSum);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        for (Aquarium aquarium : aquariums) {
            sb.append(aquarium.getInfo()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
