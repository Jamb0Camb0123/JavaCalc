import Model.Model;
import View.View;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        View calculator = new View();
        calculator.launch();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter infix expression: ");
        String input = scanner.nextLine();

        Model model = new Model();
        int result = model.processExpression(input);

        if (result != Integer.MIN_VALUE) {
            System.out.println("Result: " + result);
        }
    }
}
