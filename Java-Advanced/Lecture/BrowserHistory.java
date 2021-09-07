package Lecture;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String command = sc.nextLine();
        ArrayDeque<String> urls = new ArrayDeque<>();

        while(!command.equals("Home")){
            if(!command.equals("back")){
                urls.push(command);
            }else{
                if(urls.size() <= 1){
                    System.out.println("no previous URLs");
                    command = sc.nextLine();
                    continue;
                }else{
                    urls.pop();
                }
            }

            String currentURL = urls.peek();

            System.out.println(currentURL);

            command = sc.nextLine();
        }

    }
}
