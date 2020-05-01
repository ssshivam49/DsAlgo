/*
@developed by shivam dated on 02/05/2020
*/

class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data = data;
    }
}

public class MyClass {
    
    public static Node push(Node root, Node head){
        root.right = head;
        if(head!=null){
            head.left = root;
        }
        head =root;
        return head;
        
    }
    
    public static Node convertToDll(Node root,Node head){
        if(root == null){
            return head;
        }
        head = convertToDll(root.right,head);
        head = push(root,head);
        head = convertToDll(root.left,head);
        return head;
    }
    
    public static void printList(Node head){
        Node curr = head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr = curr.right;
        }
    }
    
    public static void main(String args[]) {
      Node root = new Node(20);
      root.left = new Node(10);
      root.right = new Node(30);
      root.left.left = new Node(5);
      root.right.right = new Node(40);
      root.left.right = new Node(15);
      Node head = null;
      head = convertToDll(root,head);
      printList(head);
    }
}
