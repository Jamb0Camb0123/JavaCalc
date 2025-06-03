import java.util.Stack;

class InfixToPostfix {

    static int getPrecedence(char op) {
        return switch (op) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    static String infixToPostfix(String expression) {
        Stack<Character> stack = new Stack<>();
        StringBuilder output = new StringBuilder();

        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                output.append(c).append(" ");
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.append(stack.pop()).append(" ");
                }
                if (stack.isEmpty() || stack.pop() != '(') {
                    return "This expression is invalid"; // Mismatched parentheses
                }
            } else { // Operator
                while (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())) {
                    output.append(stack.pop()).append(" ");
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') return "This expression is invalid";
            output.append(stack.pop()).append(" ");
        }

        return output.toString().trim(); // Remove trailing space
    }
}