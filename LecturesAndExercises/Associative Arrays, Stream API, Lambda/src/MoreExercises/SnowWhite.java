package MoreExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SnowWhite {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Integer>> dwarfs = new LinkedHashMap<>();

        String input = sc.nextLine();
        while(!input.equals("Once upon a time")){
            String[] dwarfData = input.split("\\s+<:>\\s+");
            String dwarfName = dwarfData[0];
            String dwarfHatColor = dwarfData[1];
            int dwarfPhysics = Integer.parseInt(dwarfData[2]);
            if(!dwarfs.containsKey(dwarfName)){
                dwarfs.put(dwarfName,new LinkedHashMap<>());
                dwarfs.get(dwarfName).put(dwarfHatColor,dwarfPhysics);
            }else if(dwarfs.containsKey(dwarfName) && !dwarfs.get(dwarfName).containsKey(dwarfHatColor)){
                dwarfs.put(dwarfName,new LinkedHashMap<>());
                dwarfs.get(dwarfName).put(dwarfHatColor,dwarfPhysics);
            }else {
                int lastDwarfPhysics = dwarfs.get(dwarfName).get(dwarfHatColor);
                if (dwarfPhysics > lastDwarfPhysics) {
                    dwarfs.put(dwarfName, new LinkedHashMap<>());
                    dwarfs.get(dwarfName).put(dwarfHatColor, dwarfPhysics);
                }
            }



            input = sc.nextLine();
        }
    }
}
