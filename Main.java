public class Main {
    public static void main(String[] args) {
        String infix = "3+(4*5)-2";
        String postfix = InfixToPostfix.infixToPostfix(infix);

        if (postfix.equals("This expression is invalid")) {
            System.out.println(postfix);
        } else {
            System.out.println("Postfix: " + postfix);
            String[] tokens = postfix.split(" ");
            int result = PostfixToAnswer.evaluatePostfix(tokens);
            System.out.println("Result: " + result);
        }
    }
}