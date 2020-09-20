package com.lgj.algorithm.leetcode;

/**
 * 没有做出来
 */
public class LeetCode5519 {
    static class Solution {
        public String reorderSpaces(String text) {
            int spaceCount = 0;
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == ' ') {
                    spaceCount++;
                }
            }
            String[] arr = text.split("\\s+");
            int wordCount = arr.length;
            if (wordCount > 0 && arr[0].equals("")) {
                wordCount--;
            }
            int s = spaceCount / (wordCount - 1);
            int y = spaceCount % (wordCount - 1);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
                if(i!=arr.length-1){
                    for (int j = 0; j < s; j++) {
                        sb.append(" ");
                    }
                }
            }
            for (int j = 0; j < y; j++) {
                sb.append(" ");
            }
            return sb.toString();
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reorderSpaces(" hello   world  "));
    }
}
