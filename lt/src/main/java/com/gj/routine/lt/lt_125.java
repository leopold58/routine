package com.gj.routine.lt;

import java.util.Scanner;

public class lt_125 {

    public boolean isPalindrome(String s){
        int n = s.length();
        int left = 0, right = n-1;
        while (left<right){
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while (right > left && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if (left<right){
                if (Character.toLowerCase(s.charAt(left))!= Character.toLowerCase(s.charAt(right))){
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        lt_125 solution = new lt_125();
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        boolean res = solution.isPalindrome(s);
        System.out.println("result:"+ res);

    }
}
