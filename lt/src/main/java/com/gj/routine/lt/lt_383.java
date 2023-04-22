package com.gj.routine.lt;

import java.util.Scanner;

public class lt_383 {

    public boolean canConstruct(String ransomNote, String magazine){
        if (ransomNote.length() > magazine.length()){
            return false;
        }
        int[] memo = new int[26];
        for (char c:
             magazine.toCharArray()) {
            memo[c-'a']++;
        }
        for (char c:
             ransomNote.toCharArray()) {
            memo[c-'a']--;
            if (memo[c-'a']<0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        lt_383 solution = new lt_383();
        Scanner in = new Scanner(System.in);
        System.out.println("ransomNote:");
        String rStr = in.nextLine();
        System.out.println("magazine:");
        String mStr = in.nextLine();

        boolean res = solution.canConstruct(rStr, mStr);
        System.out.println(res);
    }
}
