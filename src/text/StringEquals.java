package text;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class StringEquals {
    public static void main(String[] args) {
        System.out.println("Hello World");

    }

    public static boolean isNumeric(String s){
        for(int i = 0; i < s.length(); i++){
            if(!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }

















}


