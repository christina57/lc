package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzren on 9/15/2016.
 */
public class PalindromePairs {

    public static void main(String[] args){
        String[] words = {"a","abc","aba",""};
        List<List<Integer>> res = (new PalindromePairs()).palindromePairs(words);
        for(List<Integer> l : res){
            for(Integer i : l){
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }

    }

    class TrieNode {
        // Initialize your data structure here.
        char val;
        TrieNode[] children;
        ArrayList<Integer> subPalindrome;

        public TrieNode() {
            val = ' ';
            children = new TrieNode[27];
            subPalindrome = new ArrayList<Integer>();
        }

        public TrieNode(char val) {
            this.val = val;
            children = new TrieNode[27];
            subPalindrome = new ArrayList<Integer>();
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(words.length == 0){
            return res;
        }

        //build Trie
        TrieNode root = new TrieNode();
        for(int i=0;i<words.length;i++){
            /*if(isPalindrome(words[i], 0, words[i].length())){
                root.subPalindrome.add(i);
            }*/
            insert(root, words[i], i);
        }

        //search
        search(root, words, res);

        return res;
    }

    // Inserts a word into the trie.
    private void insert(TrieNode root, String word, int index) {
        TrieNode curNode = root;
        int len = word.length();
        for(int i = len-1; i >= 0;i--){
            int idx = (int)(word.charAt(i)-'a');
            if(curNode.children[idx] == null){
                curNode.children[idx] = new TrieNode(word.charAt(i));
            }

            if(isPalindrome(word, 0, i+1)){
                curNode.subPalindrome.add(index);
            }

            curNode = curNode.children[idx];
        }
        curNode.children[26] = new TrieNode((char)index);
    }

    // Returns if the word is in the trie.
    private void search(TrieNode root, String[] words, List<List<Integer>> res) {

        for(int i=0;i<words.length;i++){
            TrieNode curNode = root;
            int len = words[i].length();
            boolean exist = true;

            for(int j = 0; j < len; j++){
                int idx = (int)(words[i].charAt(j)-'a');
                if(curNode.children[26] != null){
                    if((int)(curNode.children[26].val) != i && isPalindrome(words[i], j, len)){
                        ArrayList<Integer> item = new ArrayList<Integer>();
                        item.add(i);
                        item.add((int)(curNode.children[26].val));
                        res.add(item);
                    }
                }

                if(curNode.children[idx] == null){
                    exist = false;
                    break;
                }

                curNode = curNode.children[idx];
            }

            if(exist){
                if(curNode.children[26] != null){
                    if((int)(curNode.children[26].val) != i){
                        ArrayList<Integer> item = new ArrayList<Integer>();
                        item.add(i);
                        item.add((int)(curNode.children[26].val));
                        res.add(item);
                    }
                }

                for(Integer id : curNode.subPalindrome){
                    if(id != i){
                        ArrayList<Integer> item = new ArrayList<Integer>();
                        item.add(i);
                        item.add(id);
                        res.add(item);
                    }
                }
            }

        }
    }

    private boolean isPalindrome(String word, int start, int end){
        if(start >= end){
            return false;
        }
        while(start < end){
            if(word.charAt(start) == word.charAt(end-1)){
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
