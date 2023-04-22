package com.gj.routine.lt;

import java.util.HashMap;

/**
 * @title: 有效的数独
 * @description: 请你判断一个9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *               数字1-9在每一行只能出现一次。
 *               数字1-9在每一列只能出现一次。
 *               数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 *               数独部分空格内已填入了数字，空白格用'.'表示。
 *               注意：
 *                  一个有效的数独（部分已被填充）不一定是可解的。
 *                  只需要根据以上规则，验证已经填入的数字是否有效即可。
 * @author: jguo
 * @date: 2021/5/18
 */
public class lt_36 {

    //一次遍历，建立多个哈希数组，用空间来换时间。
//    public boolean isValidSudoku(char[][] board){
//        if (board == null || board.length == 0)return false;
//        HashMap<Integer,Integer> [] rows = new HashMap[9];
//        HashMap<Integer,Integer> [] cols = new HashMap[9];
//        HashMap<Integer,Integer> [] boxes = new HashMap[9];
//        for (int i = 0; i < 9; i++) {
//            rows[i] = new HashMap<Integer,Integer>();
//            cols[i] = new HashMap<Integer,Integer>();
//            boxes[i] = new HashMap<Integer,Integer>();
//        }
//        //遍历
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                if (board[i][j]!='.'){
//                    int num = (int)board[i][j];
//                    int boxIndex = (i/3)*3+j/3;    //关键想清楚这个式子
//                    rows[i].put(num,rows[i].getOrDefault(num,0)+1);
//                    cols[j].put(num,cols[j].getOrDefault(num,0)+1);
//                    boxes[boxIndex].put(num,boxes[boxIndex].getOrDefault(num,0)+1);
//                    if (rows[i].get(num)>1 ||cols[j].get(num)>1 || boxes[boxIndex].get(num)>1){
//                        return false;
//                    }
//                }
//            }
//        }
//        return true;
//    }
    public boolean isValidSudoku(char[][] board){
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subboxes = new int[3][3][9];
        for (int i =0;i<9;i++){
            for (int j=0; j<9;j++){
                char c = board[i][j];
                if (c != '.'){
                    int n = c - '1';
                    rows[i][n]++;
                    columns[j][n]++;
                    subboxes[i/3][j/3][n]++;
                    if (rows[i][n] >1 || columns[j][n]>1 || subboxes[i/3][j/3][n]>1){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'}
                         ,{'6','.','.','1','9','5','.','.','.'}
                         ,{'.','9','8','.','.','.','.','6','.'}
                         ,{'8','.','.','.','6','.','.','.','3'}
                         ,{'4','.','.','8','.','3','.','.','1'}
                         ,{'7','.','.','.','2','.','.','.','6'}
                         ,{'.','6','.','.','.','.','2','8','.'}
                         ,{'.','.','.','4','1','9','.','.','5'}
                         ,{'.','.','.','.','8','.','.','7','9'}};
        lt_36 solution = new lt_36();
        System.out.println(solution.isValidSudoku(board));

    }
}
