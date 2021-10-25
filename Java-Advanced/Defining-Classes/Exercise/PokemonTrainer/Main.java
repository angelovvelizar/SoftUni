package Exercise.PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        Map<String, Trainer> trainers = new LinkedHashMap<>();


        String command = sc.nextLine();
        while(!command.equals("Tournament")){
            String[] tokens = command.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName,pokemonElement,pokemonHealth);

            trainers.putIfAbsent(trainerName, new Trainer());
            trainers.get(trainerName).addPokemon(pokemon);


            command = sc.nextLine();
        }

        String type = sc.nextLine();
        while(!type.equals("End")){
        for(Map.Entry<String, Trainer> kvp : trainers.entrySet()){
            boolean hasPokemon = false;
            for(Pokemon pokemon : kvp.getValue().getPokemons()){
                if(pokemon.getElement().equals(type)){
                    hasPokemon = true;
                    kvp.getValue().increaseBadges();
                    break;
                }
            }
            if(!hasPokemon){
                kvp.getValue().missingPokemonPenalty();
            }
            kvp.getValue().getPokemons().removeIf(pokemon -> pokemon.getHealth() <= 0);
            //currentTrainer.getPokemonList().removeIf(pokemon -> pokemon.getHealth()<=0);
        }

            type = sc.nextLine();
        }

        trainers.entrySet().stream()
                .sorted((t1, t2) -> Integer.compare(t2.getValue().getNumberOfBadges(), t1.getValue().getNumberOfBadges()))
                .forEach(t -> {
                    System.out.printf("%s %s %s%n", t.getKey(),t.getValue().getNumberOfBadges(),
                            t.getValue().getPokemons().size());
                });
    }
}
