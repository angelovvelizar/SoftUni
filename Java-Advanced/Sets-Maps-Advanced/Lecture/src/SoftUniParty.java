import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String guestInvited = sc.nextLine();

        Set<String> vips = new TreeSet<>();
        Set<String> regulars = new TreeSet<>();

        while (!guestInvited.equals("PARTY")) {
            if (isDigit(guestInvited)) {
                vips.add(guestInvited);
            } else {
                regulars.add(guestInvited);
            }
            guestInvited = sc.nextLine();
        }

        String presentGuest = sc.nextLine();

        while (!presentGuest.equals("END")) {
            if (isDigit(presentGuest)) {
                vips.remove(presentGuest);
            } else {
                regulars.remove(presentGuest);
            }

            presentGuest = sc.nextLine();
        }

        int size = regulars.size() + vips.size();
        System.out.println(size);

        printGuests(vips);
        printGuests(regulars);
    }

    private static void printGuests(Set<String> guests){
        for (String guest : guests) {
            System.out.println(guest);
        }
    }

    private static boolean isDigit (String guest){
        return Character.isDigit(guest.charAt(0));
    }
}
