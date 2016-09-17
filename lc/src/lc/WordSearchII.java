package lc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by zzren on 9/16/2016.
 */
public class WordSearchII {


    public static void main(String[] args){
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
        {'i', 'h', 'k', 'r'},
    {'i', 'f', 'l', 'v'}};
        String[] words = {"oath"};
        System.out.println((new WordSearchII()).findWords(board, words));
    }


    public List<String> findWords(char[][] board, String[] words) {

        if(words.length == 0 || board.length == 0){
            return new ArrayList<String>();
        }

        Trie trie = new Trie();
        HashSet<String> set = new HashSet<String>();
        for(int i=0;i<words.length;i++){
            trie.insert(words[i]);
        }

        boolean[][] visited = new boolean[board.length][board[0].length];


        for(int a=0;a<board.length;a++){
            for(int b=0;b<board[0].length;b++){
                StringBuilder sb = new StringBuilder();
                helper(board, visited, a, b, set, trie, sb);
            }
        }

        return new ArrayList<String>(set);
    }

    private void helper(char[][] board, boolean[][] visited, int row, int column, HashSet<String> set, Trie trie, StringBuilder sb){
        sb.append(board[row][column]);

        if(!trie.startsWith(sb)){
            sb.deleteCharAt(sb.length()-1);
            return;
        }

        if(trie.search(sb)){
            set.add(sb.toString());
        }

        visited[row][column] = true;
        if(row > 0  && !visited[row-1][column]){
            helper(board, visited, row-1, column, set, trie, sb);
        }
        if(row+1 < board.length && !visited[row+1][column]){
            helper(board, visited, row+1, column, set, trie, sb);
        }

        if(column > 0 && !visited[row][column-1]){
            helper(board, visited, row, column-1, set, trie, sb);
        }

        if(column+1 < board[0].length && !visited[row][column+1]){
            helper(board, visited, row, column+1, set, trie, sb);
        }
        visited[row][column] = false;
        sb.deleteCharAt(sb.length()-1);
    }

    class TrieNode {
        // Initialize your data structure here.
        char val;
        TrieNode[] children;

        public TrieNode() {
            val = ' ';
            children = new TrieNode[27];
        }

        public TrieNode(char val) {
            this.val = val;
            children = new TrieNode[27];
        }
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode curNode = root;
            int len = word.length();
            for(int i = 0; i < len;i++){
                int idx = (int)(word.charAt(i)-'a');
                if(curNode.children[idx] == null){
                    curNode.children[idx] = new TrieNode(word.charAt(i));
                }
                curNode = curNode.children[idx];
            }
            curNode.children[26] = new TrieNode();
        }

        // Returns if the word is in the trie.
        public boolean search(StringBuilder word) {
            TrieNode curNode = root;
            int len = word.length();
            for(int i = 0; i < len;i++){
                int idx = (int)(word.charAt(i)-'a');
                if(curNode.children[idx] == null){
                    return false;
                }
                curNode = curNode.children[idx];
            }
            if(curNode.children[26] != null){
                return true;
            } else {
                return false;
            }
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(StringBuilder prefix) {
            TrieNode curNode = root;
            int len = prefix.length();
            for(int i = 0; i < len;i++){
                int idx = (int)(prefix.charAt(i)-'a');
                if(curNode.children[idx] == null){
                    return false;
                }
                curNode = curNode.children[idx];
            }
            return true;
        }
    }
}
