package exercise;

import java.util.Stack;

public class IntToBinary {

    public static String convertToBinary(int n){
        Stack<Integer> stack = new Stack<>();
        while (n>0) {
            stack.push(n%2);
            n = n/2;
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args){
        System.out.println(convertToBinary(50));
    }
}
