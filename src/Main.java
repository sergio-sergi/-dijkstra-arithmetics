package src;

import utils.stack.linkedList.LinkedListStack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.in;

public class Main {
    //TODO: разобраться с выводом
    public static void main(String []args){
        LinkedListStack<String> ops = new LinkedListStack<>();
        LinkedListStack<Double> vals = new LinkedListStack<>();
        BufferedReader d = new BufferedReader(new InputStreamReader(in));
        while (true) {
            String s;
            try {
                s = d.readLine().trim();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if(s.isEmpty())
                break;
            if (s.equals("*") | s.equals("+") | s.equals("-") |s.equals("/")) {
                ops.push(s);
            } else if (s.matches("[0-9]")) {
                vals.push(Double.parseDouble(s));
            } else if (s.equals(")")) {
                String op = ops.pop();
                switch (op) {
                    case "+" -> vals.push(vals.pop() + vals.pop());
                    case "*" -> vals.push(vals.pop() * vals.pop());
                    case "-" -> vals.push(vals.pop() - vals.pop());
                    case "/" -> vals.push(vals.pop() / vals.pop());
                }
            } else if (s.equals("("));
            else {
                vals.push(Double.parseDouble(s));
            }
        }
        System.out.println(vals.pop());
    }
    public String toBin(int n){
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        while (n > 0) {
            stack.push(n % 2);
            n = n / 2;
        }
        StringBuilder res = new StringBuilder();
        for (int digit : stack) {
            res.append(digit);
        }
        return res.toString();
    }
}
