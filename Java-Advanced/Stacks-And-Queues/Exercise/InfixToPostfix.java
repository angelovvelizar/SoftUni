package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\s+");
        ArrayDeque<String> numbersQueue = new ArrayDeque<>();
        ArrayDeque<String> operatorStack = new ArrayDeque<>();

        for (String element : input) {
            if (Character.isDigit(element.charAt(0)) || Character.isLetter(element.charAt(0))) {
                numbersQueue.offer(element);
            } else {
                if (operatorStack.isEmpty()) {
                    operatorStack.push(element);
                } else {
                    String lastOperator = operatorStack.peek();
                    switch (element) {
                        case "+":
                        case "-":
                            if (!lastOperator.equals("(")) {
                                numbersQueue.offer(operatorStack.pop());
                            }
                            operatorStack.push(element);
                            break;
                        case "*":
                        case "/":
                            if (lastOperator.equals("*") || lastOperator.equals("/")) {
                                numbersQueue.offer(operatorStack.pop());
                            }
                            operatorStack.push(element);
                            break;
                        case "(":
                            operatorStack.push(element);
                            break;
                        case ")":
                            while (!operatorStack.peek().equals("(")) {
                                numbersQueue.offer(operatorStack.pop());
                            }
                            //Removing the non-necessary open parenthesis '('
                            operatorStack.pop();
                            break;
                    }
                }
            }
        }

        while (!numbersQueue.isEmpty()) {
            System.out.print(numbersQueue.poll() + " ");
        }

        while (!operatorStack.isEmpty()) {
            System.out.print(operatorStack.pop() + " ");
        }
        System.out.println();
    }
}
