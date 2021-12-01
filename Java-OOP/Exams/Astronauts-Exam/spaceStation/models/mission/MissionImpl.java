package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission {
    private int deadAstronauts = 0;


    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        Collection<String> items = planet.getItems();
        List<String> itemsToRemove = new ArrayList<>();
        for (Astronaut astronaut : astronauts) {
            if(astronaut.getOxygen() > 0){
                for (String item : items) {
                    astronaut.getBag().getItems().add(item);
                    astronaut.breath();
                    itemsToRemove.add(item);
                   // items.remove(item);
                    if(!astronaut.canBreath()){
                        deadAstronauts++;
                        break;
                    }
                }
                items.removeAll(itemsToRemove);
            }
        }

    }

    public int getDeadAstronauts() {
        return deadAstronauts;
    }
}
