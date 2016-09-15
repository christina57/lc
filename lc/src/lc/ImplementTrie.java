package lc;

/**
 * Created by zzren on 9/14/2016.
 */
public class ImplementTrie {
    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("abc");
        trie.insert("abd");
        trie.insert("ab");
        System.out.println(trie.search("abd"));
        System.out.println(trie.startsWith("ac"));
    }
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
    public boolean search(String word) {
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
    public boolean startsWith(String prefix) {
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
