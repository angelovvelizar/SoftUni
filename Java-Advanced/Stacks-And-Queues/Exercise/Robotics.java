package Exercise;

import java.util.*;

public class Robotics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String inputRobots = sc.nextLine();
        String[] robotsData = inputRobots.split(";");

        Map<String,Integer> robots = getRobotsMap(robotsData);
        LinkedHashMap<String, Integer> robotsWorkingTime = getRobotsWorkingTime(robotsData);

        String startTime = sc.nextLine();
        //turn into seconds
        int startTimeInSeconds = getTimeInSeconds(startTime);

        ArrayDeque<String> products = new ArrayDeque<>();
        String product = sc.nextLine();

        while(!product.equals("End")){
            products.offer(product);


            product = sc.nextLine();
        }
        while(!products.isEmpty()){
            String currentProduct = products.poll();
            startTimeInSeconds++;
            //decrease the time of all robots which are working on product
            decreaseWorkingTime(robotsWorkingTime);
            boolean isTaken = false;
            //check which robot is free
            for (Map.Entry<String, Integer> robot : robotsWorkingTime.entrySet()) {
                if(robot.getValue() == 0){//robot is free -> robot starts working on the product
                    System.out.println(robot.getKey() + " - " + currentProduct + " [" + getStartTime(startTimeInSeconds) + "]");
                    robotsWorkingTime.put(robot.getKey(), robots.get(robot.getKey()));
                    isTaken = true;
                    break;
                }
            }

            if(!isTaken){
                products.offer(currentProduct);
            }

        }

    }

    private static void decreaseWorkingTime(LinkedHashMap<String, Integer> robotsWorkingTime) {
        for (Map.Entry<String, Integer> robot:robotsWorkingTime.entrySet()) {
            if(robot.getValue() > 0 ){// robot is not free
                 robotsWorkingTime.put(robot.getKey(),robot.getValue() - 1);
            }

        }
    }

    private static LinkedHashMap<String, Integer> getRobotsWorkingTime(String[] robotsData) {
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        for (String robotDatum : robotsData) {
            String robotName = robotDatum.split("-")[0];
            robots.put(robotName,0);
        }
        return  robots;
    }

    private static int getTimeInSeconds(String startTime) {
        int hours = Integer.parseInt(startTime.split(":")[0]);
        int minutes = Integer.parseInt(startTime.split(":")[1]);
        int seconds = Integer.parseInt(startTime.split(":")[2]);
        return hours * 3600 + minutes * 60 + seconds;
    }

    private static String getStartTime(int startTimeInSeconds){
        //from seconds to 00:00:00
            int hours = (startTimeInSeconds / 3600)  % 24;
            int minutes = startTimeInSeconds % 3600 / 60;
            int seconds = startTimeInSeconds % 60;
            return String.format("%02d:%02d:%02d",hours, minutes, seconds);
    }

    private static Map getRobotsMap(String[] robotsData) {
        Map<String,Integer> robots = new LinkedHashMap<>( );
        for (String robotsDatum : robotsData) {
            String robotName = robotsDatum.split("-")[0];
            int processingTime = Integer.parseInt(robotsDatum.split("-")[1]);
            robots.put(robotName, processingTime);
        }
        return robots;
    }
}
