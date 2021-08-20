package ForLoop.MoreExercises;

import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int period = Integer.parseInt(sc.nextLine());

        int doctors = 7;
        int day = 1;
        int treatedPatients = 0;
        int untreatedPatients = 0;
        for (int i = 0; i < period; i++) {
            int patients = Integer.parseInt(sc.nextLine());
            if(day % 3 == 0 && untreatedPatients > treatedPatients){
                doctors++;
            }
            if(patients <= doctors){
                treatedPatients += patients;
            }else{
                untreatedPatients += patients - doctors;
                treatedPatients = treatedPatients + doctors;
            }

            day++;

        }
        System.out.println("Treated patients: " + treatedPatients + ".");
        System.out.println("Untreated patients: " + untreatedPatients + ".");

    }
}
