package com.gj.routine.lt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @title: 文本左右对齐
 * @description: 给定一个单词数组和一个长度maxWidth，重新排版单词，使其成为每行恰好有maxWidth个字符，且左右两端对齐的文本。
 *               你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格' '填充，使得每行恰好有 maxWidth个字符。
 *               要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 *               文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 *               说明:
 *                  单词是指由非空格字符组成的字符序列。
 *                  每个单词的长度大于 0，小于等于maxWidth。
 *                  输入单词数组 words至少包含一个单词。
 *               示例1:
 *                  输入:
 *                  words = ["This", "is", "an", "example", "of", "text", "justification."]
 *                  maxWidth = 16
 *                  输出:
 *                  [
 *                  "This   is    an",
 *                  "example of text",
 *                  "justification. "
 *                  ]
 *                示例2:
 *                  输入:
 *                  words = ["What","must","be","acknowledgment","shall","be"]
 *                  maxWidth = 16
 *                  输出:
 *                  [
 *                  "What   must   be",
 *                  "acknowledgment  ",
 *                  "shall be        "
 *                  ]
 *                解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *                     因为最后一行应为左对齐，而不是左右两端对齐。
 *                     第二行同样为左对齐，这是因为这行只包含一个单词。
 *                示例3：
 *                  输入:
 *                  words = ["Science","is","what","we","understand","well","enough","to","explain",
 *                          "to","a","computer.","Art","is","everything","else","we","do"]
 *                  maxWidth = 20
 *                  输出:
 *                  [
 *                   "Science is what we",
 *                   "understand   well",
 *                   "enough to explain to",
 *                   "a computer. Art is",
 *                   "everything else we",
 *                   "do                "
 *                  ]
 *
 * @author: jguo
 * @date: 2021/7/18
 */
public class lt_68 {

    //网上解法。
    public List<String> fullJustify(String[] words, int maxWidth) {
        //定义0-maxWidth个空格字符串，方便之后直接调用
        final String[] space = new String[maxWidth+1];
        StringBuffer s = new StringBuffer();
        for(int i = 0;i<maxWidth+1;i++){
            space[i] = s.toString();
            s.append(" ");
        }
        //新建List，用来存最后的结果。
        List<String> pWords = new ArrayList<String>();
        //遍历整个words，一行一行的排版
        for(int i=0; i<words.length; i++){
            int curlen = words[i].length(); //记录当前已读取单词的长度，当>=maxWidth时进行排版
            int startI = i;                //记录本次读取单词的起点
            while(i < words.length-1 && curlen<maxWidth){
                i++;
                curlen = curlen+words[i].length()+1;  // 每多读一个单词都要加一个空格
            }
            if(curlen>maxWidth){       //当前长度>maxWidth，说明已经多读取了一个单词
                curlen = curlen-words[i].length()-1;
                i--;
            }
            //一行一行的排版
            pWords.add(processCurline(words,startI,i,curlen,maxWidth,space));
        }
        return pWords;
    }
    public String processCurline(String[] words,int si,int ei,int curlen,int maxWidth,String[] space){
        StringBuffer sb = new StringBuffer();   //用来进行排版
        int map = ei-si;                   // 记录单词之间的有几个间隙
        int addSpace = maxWidth - curlen+map;   //记录这一行总共有多少个空格
        if(map==0){               //间隙为0，证明只有一个单词
            sb.append(words[ei]);
            sb.append(space[addSpace]);
            return sb.toString();
        }
        if(ei == words.length-1){            //证明要排版最后一行了，格式特殊
            for(int i =si;i<ei;i++){
                sb.append(words[i]).append(" ");
            }
            sb.append(words[ei]);             //最后一个单词不用加空格
            sb.append(space[addSpace-map]);   //如果还有多余空格，一起加上
            return sb.toString();
        }
        int allAddSpace = addSpace/map;     //所有的空格数 / 间隙 = 每个间隙必加的空格数
        int left = addSpace % map + si;     //多出来的空格要从si开始，依次加在间隙中
        for(int i = si;i<ei;i++){
            sb.append(words[i]).append(space[allAddSpace]);
            if(i < left) sb.append(" ");     // <left就要多加一个空格
        }
        sb.append(words[ei]);
        return sb.toString();
    }

    /**
     * 输入参考
     * What,must,be,acknowledgment,shall,be
     * 16
     * Science,is,what,we,understand,well,enough,to,explain,to,a,computer.,Art,is,everything,else,we,do
     * 20
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int num = in.nextInt();
        String[] words = s.trim().split(",");
        lt_68 solution = new lt_68();
        System.out.println(solution.fullJustify(words, num));
    }

}
