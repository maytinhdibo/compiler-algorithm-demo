/*******************************************************************************
 * Created at 15/1/2020  by maytinhdibo
 * Convert infix to postfix expression
 ******************************************************************************/

import java.util.Stack;

public class InToPost {
    public static int getPriority(char op) {
        if (op == '*' || op == '/' || op == '%')
            return 2;
        if (op == '+' || op == '-')
            return 1;
        return 0;
    }

    public static void inTopost(String smt) {
        Stack<Integer> num = new Stack<>();
        Stack<Character> op = new Stack<>();

        char[] smtArr = smt.toCharArray();

        for (int i = 0; i < smtArr.length; i++) {
            StringBuilder tmpnum = new StringBuilder();

            while (i < smtArr.length && Character.isDigit(smtArr[i])) {
                tmpnum.append(smtArr[i]);
                i++;
            }

            if (tmpnum.length() > 0) {
                num.push(Integer.parseInt(tmpnum.toString()));
                System.out.print(tmpnum.toString() + " ");
                i--;
            } else {
                if (smtArr[i] == '(') {
                    op.push(smtArr[i]);
                } else if (smtArr[i] == ')') {
                    //pop all
                    while (!op.isEmpty()) {
                        if (op.peek() != '(')
                            System.out.print(op.pop() + " ");
                        else op.pop();
                    }

                } else {
                    if (!op.isEmpty() && getPriority(smtArr[i]) <= getPriority(op.peek())) {
                        System.out.print(op.pop() + " ");
                        op.push(smtArr[i]);
                    } else {
                        op.push(smtArr[i]);
                    }
                }
            }
        }

        while (!op.isEmpty()) {
            System.out.print(op.pop());
        }

    }

    public static void main(String[] args) {
        inTopost("54*54+45/8-2*8");
    }
}