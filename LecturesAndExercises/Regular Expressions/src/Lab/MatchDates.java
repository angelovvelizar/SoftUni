package Lab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dates = sc.nextLine();
        String regex = "\\b(?<day>\\d{2})(?<separator>[.\\-\\/])(?<month>[A-Z][a-z]{2})\\2(?<year>\\d{4})\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher dateMatcher = pattern.matcher(dates);
        while (dateMatcher.find()){
            System.out.println("Day: " + dateMatcher.group("day")+ ", Month: "
                    + dateMatcher.group("month") +
                    ", Year: " + dateMatcher.group("year"));
        }
    }
}
