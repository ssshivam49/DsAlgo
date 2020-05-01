import java.util.*;

/*
  developed by shivam dated 02/05/2020
*/

class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data = data;
    }
    
}

public class Main {
    public static void printInorderIterative(Node root){
        Stack<Node> stack = new Stack<>();
        while(!stack.isEmpty() || root!=null){
            if(root!=null){
                stack.push(root);
                root=root.left;
            }else{
                Node pop = stack.pop();
                System.out.print(pop.data+" ");
                root = pop.right;
            }
        }
    }
    
    public static void printPreOrderIterative(Node root){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node pop = stack.pop();
            System.out.print(pop.data+" ");
            if(pop.right!=null){
                stack.push(pop.right);
            }
            if(pop.left!=null){
                stack.push(pop.left);
            }
        }
    }
    
    public static void printPostOrderIterative(Node root){
        Stack<Node> stack = new Stack<>();
        while(!stack.isEmpty() || root!=null){
            if(root!=null){
                if(root.right!=null){
                    stack.push(root.right);
                }
                stack.push(root);
                root=root.left;
            }else{
                Node pop = stack.pop();
                if(pop.right!=null && !stack.isEmpty() && stack.peek().data==pop.right.data){
                    Node right = stack.pop();
                    stack.push(pop);
                    root= pop.right;
                }else{
                    System.out.print(pop.data+" ");
                    root=null;
                }
            }
        }
        
        
    }
    
    public static void main(String[] args) throws Exception {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("Inorder Traversal");
        printInorderIterative(root);
        System.out.println("\nPreorder Traversal");
        printPreOrderIterative(root);
        System.out.println("\nPostorder Traversal");
        printPostOrderIterative(root);
    }
}
