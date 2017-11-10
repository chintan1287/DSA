package exercise;

import java.util.Stack;

public class Parentheses {

    private static final char LEFT_PAREN     = '(';
    private static final char RIGHT_PAREN    = ')';
    private static final char LEFT_BRACE     = '{';
    private static final char RIGHT_BRACE    = '}';
    private static final char LEFT_BRACKET   = '[';
    private static final char RIGHT_BRACKET  = ']';

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if( c == LEFT_BRACE || c == LEFT_BRACKET || c == LEFT_PAREN) stack.push(c);
            else if(c == RIGHT_BRACE && stack.pop() != LEFT_BRACE) return false;
            else if(c == RIGHT_BRACKET && stack.pop() != LEFT_BRACKET) return false;
            else if(c == RIGHT_PAREN && stack.pop() != LEFT_PAREN) return false;
        }
        if(stack.isEmpty()) return true;
        return false;
    }

    public static void main(String[] args){
        String s = "[()]{}{[()()]()}";
        System.out.println(isBalanced(s));
        s = "[(])";
        System.out.println(isBalanced(s));
    }
}
