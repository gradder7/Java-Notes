package LinkedList.singlell;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        this.next=null;
    }
}

public class mergeSortinLL {
    Node head;
    //add
    public void add(int data){
        Node newNode=new Node(data);
        if(head==null){
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }

    //print
    public  void print(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"-->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public Node mergeSortSLL(Node head){
        if(head.next==null){
            return head;
        }
        Node mid=findMid();
        Node midNext=mid.next;
        mid.next=null;
        Node left=mergeSortSLL(head);
        Node right= mergeSortSLL(midNext);
        Node finalMerged= merge(left,right);
        return finalMerged;
    }

    public Node merge(Node left,Node right){
        Node merge=new Node(-1);
        Node temp= merge;
        while(left!=null && right!=null){
            if(left.data<right.data){
                temp.next=left;
                left=left.next;
            } else{
                temp.next=right;
                right=right.next;
            }
            temp=temp.next;
        }
        while(left!=null){
            temp.next=left;
            left=left.next;
            temp=temp.next;
        }

        while(right!=null){
            temp.next=right;
            right=right.next;
            temp=temp.next;
        }
        return merge.next;
    }

    public Node findMid(){
        Node slow = head;
        Node fast= head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        mergeSortinLL mll= new mergeSortinLL();
        mll.add(12);
        mll.add(2);
        mll.add(5);
        mll.mergeSortSLL(head);
    }
}

