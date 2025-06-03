import java.util.Stack;

class PostfixToAnswer {

    // Function to evaluate a postfix expression
    static int evaluatePostfix(String[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (String token : arr) {

            if (token.matches("-?\\d+")) {
                stack.push(Integer.parseInt(token));
                continue;
            }

            int b = stack.pop();
            int a = stack.pop();

            switch (token) {
                case "+" -> stack.push(a + b);
                case "-" -> stack.push(a - b);
                case "*" -> stack.push(a * b);
                case "/" -> stack.push(a / b); // Assumes no divide-by-zero
                default -> throw new IllegalArgumentException("Invalid operator: " + token);
            }
        }

        return stack.pop();
    }
}