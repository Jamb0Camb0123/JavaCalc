package Model;

public class Model {
    public int processExpression(String infix) {
        String postfix = InfixToPostfix.infixToPostfix(infix);

        if (postfix.equals("This expression is invalid")) {
            System.out.println(postfix);
            return Integer.MIN_VALUE; // or throw an exception
        } else {
            String[] tokens = postfix.split(" ");
            return PostfixToAnswer.evaluatePostfix(tokens);
        }
    }
}
