package lc;

/**
 * Created by zzren on 9/14/2016.
 */
public class AddandSearchWordDatastructuredesign {

    public static void main(String[] args){
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        wordDictionary.addWord("add");
        wordDictionary.addWord("bat");
        System.out.println(wordDictionary.search(".at"));
    }
}

class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
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

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchHelper(root, word);
    }

    private boolean searchHelper(TrieNode cur, String word) {
        TrieNode curNode = cur;
        int len = word.length();
        for(int i = 0; i < len;i++){
            char c = word.charAt(i);
            if(c == '.'){
                for(int j=0;j<26;j++){
                    if(curNode.children[j] != null){
                         TrieNode child = curNode.children[j];
                         if(searchHelper(child, word.substring(i+1, len))){
                             return true;
                         }
                    }
                }
                return false;
            } else {
                int idx = (int)(word.charAt(i)-'a');
                if(curNode.children[idx] == null){
                    return false;
                }
                curNode = curNode.children[idx];
            }
        }
        if(curNode.children[26] != null){
            return true;
        } else {
            return false;
        }
    }
}