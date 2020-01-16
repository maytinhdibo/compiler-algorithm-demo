import java.util.Stack;

/*******************************************************************************
 * Created at 15/1/2020  by maytinhdibo
 ******************************************************************************/

public class CalcPostFix {
    public static double calcOp(double num2, double num1, String op) throws Exception {
        if (op == "/" && num2 == 0) throw new Exception("Can not divide by 0");
        switch (op) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
        }
        return 0;
    }

    public static double calc(String[] input) {
        Stack<Double> stack = new Stack<>();
        double result = 0;
        try {
            for (int i = 0; i < input.length; i++) {
                if (isOp(input[i])) {
                    result = calcOp(stack.pop(), stack.pop(), input[i]);
                    stack.push(result);
                } else {
                    stack.push(Double.parseDouble(input[i]));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//        System.out.println(stack.pop());
        return result;
    }

    public static void main(String arg[]) {
        String[] input;
        input = new String[]{"20", "3", "3", "*", "+", "7", "+"};

        calc(input);
    }

    public static boolean isOp(String ch) {
        return ch == "+" || ch == "-" || ch == "*" || ch == "/";
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
