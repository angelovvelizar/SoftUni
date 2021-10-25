package Exercise.PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemons;

    public Trainer() {
        this.numberOfBadges = 0;
        this.pokemons = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon){
        this.pokemons.add(pokemon);
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public String getName() {
        return name;
    }

    public void increaseBadges(){
        this.numberOfBadges++;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void missingPokemonPenalty(){
        for(Pokemon pokemon : pokemons){
            pokemon.setHealth(pokemon.getHealth() - 10);
        }
    }
}
