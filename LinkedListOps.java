/*
  @developed by shivam dated on 02/05/2020
*/

class Node{
    int data;
    Node next;
}

public class MyClass {
    public static Node insertNode(Node head, int val){
        Node newNode = new Node();
        newNode.data = val;
        newNode.next = head;
        head = newNode;
        return head; 
    }
    
    public static Node append(Node head, int val){
        Node newNode = new Node();
        newNode.data = val;
        if(head==null){
            head=newNode;
        }else{
            Node current = head;
            while(current.next != null){
                current=current.next;
            }
            current.next = newNode;
        }
        
        return head;
    }
    
    public static Node insertSorted(Node head, int val){
        Node newNode = new Node();
        newNode.data = val;
        if(head==null){
            head = newNode;
        }else{
            Node prev = head;
            Node curr = head;
            while(curr != null){
                if(curr.data>=val){
                    break;
                }
                prev = curr;
                curr = curr.next;
            }
            newNode.next = curr;
            prev.next=newNode;
        }
        
        return head;
    }
    
    public static Node[] split(Node head){
        if(head==null || head.next==null){
            return new Node[]{head,null};
        }
        Node slow = head;
        Node fast = head.next;
        while(fast!=null){
            fast=fast.next;
            if(fast!=null){
                slow=slow.next;
                fast=fast.next;
            }
        }
        Node[] res = {head,slow.next};
        slow.next=null;
        return res;
        
    }
    
    public static Node merge(Node front, Node back){
        if(front == null){
            return back;
        }
        if(back == null){
            return front;
        }
        Node result;
        if(front.data<back.data){
            result=front;
            result.next = merge(front.next,back);
        }else{
            result=back;
            result.next = merge(front,back.next);
        }
        return result;
    }
    
    public static Node mergeSort(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node[] nodes = split(head);
        Node front,back;
        front = mergeSort(nodes[0]);
        back = mergeSort(nodes[1]);
        Node res = merge(front,back);
        return res;
    }
    
    public static Node reverse(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node newNode = reverse(head.next);
        head.next.next = head;
        head.next = null;
        System.out.println("(In Reverse) Now newNode is : ");
        printList(newNode);
        return newNode;
    }
    
    public static void printList(Node head){
        Node current = head;
        while(current.next!=null){
            System.out.print(current.data+" -> ");
            current= current.next;
        }
        System.out.println(current.data);
    }
    
    public static void main(String[] args){
        int[] values = {7,3,5,4,2,0,1};
        Node head = null;
        for(int i=0;i<values.length;i++){
            head = append(head,values[i]);
        }
        printList(head);
        
        System.out.println("Reversing the List");
        head = reverse(head);
        
        System.out.println("Merge Sort");
        head = mergeSort(head);
        printList(head);
        
        Node[] nodes = split(head);
        System.out.println("===First half===");
        printList(nodes[0]);
        System.out.println("===Second Half===");
        printList(nodes[1]);
    }
}
