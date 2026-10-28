// class Solution {
//     public int evalRPN(String[] tokens) {
//         ArrayDeque<String> stack = new ArrayDeque<>();
//         for (String s: tokens) {
//             if (Character.isDigit(s.charAt(0))) {
//                 // 是数字
//                 stack.offerFirst(s);
//             } else {
//                 // 是运算符
//                 String res;
//                 int num2 = stack.pollFirst().charAt(0) - '0';
//                 int num1 = stack.pollFirst().charAt(0) - '0';
//                 if (s.equals("+")) {
//                    res = String.valueOf(num1 + num2);                     
//                 }
//                 else if (s.equals("-")) {
//                     res = String.valueOf(num1 - num2);
//                 }
//                 else if (s.equals("*")) {
//                     res = String.valueOf(num1 * num2);
//                 }
//                 else {
//                     res = String.valueOf(num1 / num2);
//                 }
//                 stack.offerFirst(res);
//             }
//         }
//         return stack.peek().charAt(0) - '0';
//     }
// }


class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (String s : tokens) {
            if (!s.equals("+") && !s.equals("-") &&
                !s.equals("*") && !s.equals("/")) {
                stack.offerFirst(s);
            } else {
                int num1 = Integer.parseInt(stack.pollFirst());
                int num2 = Integer.parseInt(stack.pollFirst());

                String res;

                if (s.equals("+")) {
                    res = String.valueOf(num2 + num1);
                } else if (s.equals("-")) {
                    res = String.valueOf(num2 - num1);
                } else if (s.equals("*")) {
                    res = String.valueOf(num2 * num1);
                } else {
                    res = String.valueOf(num2 / num1);
                }

                stack.offerFirst(res);
            }
        }

        return Integer.parseInt(stack.peekFirst());
    }
}