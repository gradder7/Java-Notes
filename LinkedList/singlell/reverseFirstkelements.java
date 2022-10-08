package LinkedList.singlell;

public class reverseFirstkelements {
    Node head;

    class Node{
        int data;
        Node next;
        Node(int data){
            this.data= data;
            this.next=null;
        }
    }

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

    public void reverseFirstKNodesinLL(int k){
        Node temp =head;
        if(k==0){
            return;
        }
        // while(k>1){
        //     temp=temp.next;
        //     k--;
        // }
        for(int i=0;i<k;i++){
            temp=temp.next;
            k--;
        }
        Node joint = temp.next;
        temp.next=null;
        
        Node prev = null;
        Node next= null;
        Node current=head;
        while(current!=null){
            next= current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        head=prev;
        current= head;
        while(current.next!=null){
            current=current.next;
        }
        current.next=joint;
        }

    public Node reverse(){
        Node prev = null;
        Node next= null;
        Node current = head;
        if(current==null){
            return null;
        }
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev = current;
            current=next;
        }
        head.next=null;
        head= prev;
        return prev;
    }

    public void print(){
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
    public static void main(String[] args) {
        reverseFirstkelements rl = new reverseFirstkelements();
        rl.add(1);
        rl.add(3);
        rl.add(5);
        rl.add(2);
        rl.add(8);
        rl.print();
       // rl.reverse();
       rl.reverseFirstKNodesinLL(3);
        rl.print();
    }
}
