package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission {
    private int retiredExplorers;

    public int getRetiredExplorers() {
        return retiredExplorers;
    }

    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        Collection<String> exhibits = state.getExhibits();
        List<String> exhibitsToRemove = new ArrayList<>();

        for (Explorer explorer : explorers) {
            if (explorer.getEnergy() < 0) {
                continue;
            }
            for (String exhibit : exhibits) {
                if (explorer.canSearch()) {
                    explorer.getSuitcase().getExhibits().add(exhibit);
                    explorer.search();
                    exhibitsToRemove.add(exhibit);
                } else {
                    retiredExplorers++;
                    break;
                }
            }
            exhibits.removeAll(exhibitsToRemove);
        }

    }
}
