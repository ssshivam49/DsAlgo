/*
  developed by Shivam
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class TrieNode{
    Map<Character,TrieNode> map;
    String word;
    
    TrieNode(){
        map = new HashMap<>();
    }
    
}

class Codechef
{
    public static TrieNode insertUtil(TrieNode root, String str, int i){
        if(i==str.length()){
            root.word=str;
            return root;
        }
        if(root.map.get(str.charAt(i))==null){
            root.map.put(str.charAt(i),new TrieNode());
        }
        root.map.put(str.charAt(i) , insertUtil(root.map.get(str.charAt(i)),str,i+1));
        return root;
    }
    
    public static TrieNode insert(TrieNode root, String str){
        return insertUtil(root, str,0);
    }
    
    public static void printTrie(TrieNode root){
        if(root.word!=null){
            System.out.println(root.word);
        }
        for(Map.Entry<Character,TrieNode> entry : root.map.entrySet()){
            printTrie(entry.getValue());
        }
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		TrieNode root = new TrieNode();
		root = insert(root,"ABC");
		root = insert(root,"ABD");
		root = insert(root,"ADE");
		root = insert(root,"BCE");
		printTrie(root);
		root = insert(root,"ABCD");
		printTrie(root);
	}
}
