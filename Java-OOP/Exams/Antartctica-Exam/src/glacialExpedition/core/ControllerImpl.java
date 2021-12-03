package glacialExpedition.core;

import glacialExpedition.models.explorers.*;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.StateRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static glacialExpedition.common.ConstantMessages.*;
import static glacialExpedition.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private ExplorerRepository explorers;
    private StateRepository states;
    private int statesExplored;

    public ControllerImpl(){
        this.explorers = new ExplorerRepository();
        this.states = new StateRepository();

    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer;
        switch (type){
            case "AnimalExplorer":
            explorer = new AnimalExplorer(explorerName);
            break;
            case "GlacierExplorer":
                explorer = new GlacierExplorer(explorerName);
                break;
            case "NaturalExplorer":
                explorer = new NaturalExplorer(explorerName);
                break;
            default:
                throw new IllegalArgumentException(EXPLORER_INVALID_TYPE);
        }

        this.explorers.add(explorer);
        return String.format(EXPLORER_ADDED,type,explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);
        this.states.add(state);
        state.getExhibits().addAll(Arrays.asList(exhibits));

        return String.format(STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorer = this.explorers.byName(explorerName);
        if(explorer == null){
            throw new IllegalArgumentException(String.format(EXPLORER_DOES_NOT_EXIST,explorerName));
        }

        this.explorers.remove(explorer);

        return String.format(EXPLORER_RETIRED, explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        List<Explorer> explorers = this.explorers.getCollection().stream().filter(e -> e.getEnergy() > 50).collect(Collectors.toList());
        if(explorers.size() == 0){
            throw new IllegalArgumentException(STATE_EXPLORERS_DOES_NOT_EXISTS);
        }

        State state = this.states.byName(stateName);
        MissionImpl mission = new MissionImpl();
        mission.explore(state,explorers);
        statesExplored++;


        return String.format(STATE_EXPLORER,stateName,mission.getRetiredExplorers());
    }

    @Override
    public String finalResult() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(FINAL_STATE_EXPLORED,statesExplored)).append(System.lineSeparator());
        sb.append(FINAL_EXPLORER_INFO).append(System.lineSeparator());

        for (Explorer explorer : explorers.getCollection()) {
            sb.append(String.format(FINAL_EXPLORER_NAME,explorer.getName())).append(System.lineSeparator());
            sb.append(String.format(FINAL_EXPLORER_ENERGY, explorer.getEnergy())).append(System.lineSeparator());

            if(explorer.getSuitcase().getExhibits().size() == 0){
                sb.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS, "None")).append(System.lineSeparator());
            }else{
                sb.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS,
                        String.join(FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER,
                                explorer.getSuitcase().getExhibits()))).append(System.lineSeparator());
            }
        }
        sb.append(System.lineSeparator());


        return sb.toString().trim();
    }
}
