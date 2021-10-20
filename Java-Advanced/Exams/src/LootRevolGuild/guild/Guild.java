package LootRevolGuild.guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player){
        if(this.roster.size() < capacity){
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name){
        return this.roster.removeIf(p -> p.getName().equals(name));
    }

    public void promotePlayer(String name){
        for (Player player : roster) {
            if(player.getName().equals(name) && !player.getRank().equals("Member")){
                player.setRank("Member");
                break;
            }else if(player.getRank().equals(name) && player.getRank().equals("Member")){
                break;
            }
        }
    }

    public void demotePlayer(String name){
        for (Player player : roster) {
            if(player.getName().equals(name) && !player.getRank().equals("Trial")){
                player.setRank("Trial");
                break;
            }else if(player.getRank().equals(name) && player.getRank().equals("Trial")){
                break;
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz){
        Player[] players = this.roster.stream().filter(p -> p.getClazz().equals(clazz)).toArray(Player[]::new);

        this.roster.removeIf(p -> p.getClazz().equals(clazz));

        return players;
    }

    public int count(){
        return this.roster.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append("Players in the guild: ").append(this.name).append("\n");
        for (Player player : roster) {
            sb.append(player.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
