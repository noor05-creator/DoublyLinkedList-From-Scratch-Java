
//this code is written using head and tail
class Node{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = null;
        prev = null;
    }


}

class doublyLL{
   Node head;
   Node tail;
   doublyLL()
   {
       head = null;
       tail = null;
   }
   void pushFront(int data)
   {
       Node newNode = new Node(data);
       if(isEmpty())
       {
           head = tail = newNode;
           return;
       }
       newNode.next= head;
       head.prev = newNode;
       newNode.prev= null;
       head = newNode;


   }
   void pushBack(int data)
   {
       Node newNode = new Node(data);
       if(isEmpty())
       {
           head = tail=newNode;
           return;
       }
       newNode.prev = tail;
       tail.next = newNode;
       newNode.next = null;

       tail = newNode;
   }

   void popBack()
   {
       if(isEmpty())
       {
           System.out.println("nothing to pop");
           return;
       }
       if(tail.prev == null)
       {
           head = tail = null;
           return;
       }
       tail = tail.prev;
       tail.next = null;


   }
   void popFront()
   {
       if(isEmpty())
       {
           System.out.println("nothing to pop");
           return;
       }
       if(head.next == null)
       {
           head = tail = null;
           return;
       }
       head = head.next;
       head.prev = null;
   }
   void insertAtIndex(int data, int location)
   {
       int i;
       if(location<0)
       {
           System.out.println("invalid position");
           return;
       }
       if(location == 0)
       {
           pushFront(data);
           return;
       }
       Node newNode = new Node(data);
       if(head == null)
       {
           head = tail = newNode;
           return;
       }
       Node temp= head;
    for(i = 0;i<location-1;i++)
    {
        temp= temp.next;
        if(temp == null)
        {
            System.out.println("Invalid location");
            return;
        }
    }

       if(temp.next == null){ //inserting at tail
           pushBack(data);
           return;
       }
       temp.next.prev = newNode;
       newNode.next = temp.next;
       newNode.prev = temp;
       temp.next = newNode;


   }
void deleteAtIndex(int location){
       if(isEmpty())
       {
           System.out.println("ll is empty");
           return;
       }
       if(location<0)
       {
           System.out.println("invalid location");
           return;
       }
       int i;
       Node temp = head;
       for( i = 0;i<location;i++)
       {
           temp = temp.next;
           //check is placed here to ensure there is no null pointer exception
           if(temp == null)
           {
               System.out.println("invalid location");
               return;
           }

       }
       if(temp == head){
           popFront();
           return;
       }
       if(temp == tail){
           popBack();
           return;
       }
    temp.prev.next = temp.next;
    temp.next.prev = temp.prev;





}
void deleteThroughdata(int data) {
    if (isEmpty()) {
        System.out.println("ll is empty");
        return;
    }
    int i;
    Node temp = head;
    boolean isFound = false;
    while (temp != null) {
        if (temp.data == data) {
            isFound = true;
            if(temp == head)
            {
                popFront();
                return;
            }
            else if(temp == tail)
            {
                popBack();
                return;
            }
            temp.prev.next = temp.next;
            temp.prev = null;
            return;
        }
        temp = temp.next;
    }
    if (!isFound) {
        System.out.println("Node with such data do not exists");
        return;
    }
}
    boolean isEmpty(){
        if(head == null && tail == null)
        {
            return true;
        }
        return false;

}

void print()
{
    if(head == null)
    {
        System.out.println("ll is empty");
        return;
    }
    Node temp = head;
    int i;
    while(temp!= null)
    {
        System.out.print(temp.data);
        if(temp.next != null)
        {
            System.out.print("->");
        }
        temp = temp.next;
    }
    System.out.println();
}






}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
doublyLL dl1 = new doublyLL();
//dl1.popBack();
        //dl1.popFront();
        dl1.pushFront(1);
        dl1.pushBack(2);
        //dl1.print();
       dl1.insertAtIndex(3,1);
        //dl1.print();
        //dl1.insertAtIndex(5,-3);
       // dl1.deleteThroughdata(5);
        //dl1.deleteThroughdata(1);
        dl1.print();
        //dl1.deleteAtIndex(-1);
        //dl1.deleteAtIndex(0);
        dl1.deleteAtIndex(2);
        dl1.print();
    }
}