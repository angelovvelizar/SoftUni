package spaceStation.core;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private AstronautRepository astronauts = new AstronautRepository();
    private PlanetRepository planets = new PlanetRepository();
    private int exploredPlanets = 0;

    public ControllerImpl() {

    }


    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;
        if (type.equals("Biologist")) {
            astronaut = new Biologist(astronautName);
        } else if (type.equals("Geodesist")) {
            astronaut = new Geodesist(astronautName);
        } else if (type.equals("Meteorologist")) {
            astronaut = new Meteorologist(astronautName);
        } else {
            throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        }

        this.astronauts.add(astronaut);

        return String.format(ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        planet.getItems().addAll(Arrays.asList(items));

        this.planets.add(planet);

        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = this.astronauts.findByName(astronautName);
        if (this.astronauts.findByName(astronautName) == null) {
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }

        this.astronauts.remove(astronaut);

        return String.format(ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {

        List<Astronaut> suitableAstronauts = this.astronauts.getModels().stream().filter(a -> a.getOxygen() > 60).collect(Collectors.toList());
        if (suitableAstronauts.size() == 0) {
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        Planet planet = planets.findByName(planetName);
        MissionImpl mission = new MissionImpl();
        mission.explore(planet, suitableAstronauts);
        exploredPlanets++;

        return String.format(PLANET_EXPLORED, planetName, mission.getDeadAstronauts());
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(exploredPlanets).append(" planets were explored!").append(System.lineSeparator());
        sb.append("Astronauts info:").append(System.lineSeparator());

        Collection<Astronaut> astronauts = this.astronauts.getModels();
        for (Astronaut astronaut : astronauts) {
            sb.append("Name: ").append(astronaut.getName()).append(System.lineSeparator());
            sb.append("Oxygen: ").append(String.format("%.0f",astronaut.getOxygen())).append(System.lineSeparator());
            sb.append("Bag items: ");

            if(astronaut.getBag().getItems().size() == 0){
                sb.append("none");
            }else{
                String bagItemsOutput = String.join(", ", astronaut.getBag().getItems());
                sb.append(bagItemsOutput);
            }
            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
