
public class RecursiveInsertion {
    static class Node{
        int value;
        Node next;

        Node(int value){
            this.value= value;
        }

        Node(int value, Node next){
            this.value= value;
            this.next = next;
        }
    }
    Node head;
    Node tail;
    int size;
    
    public void display(){
        Node temp = head;
        while (temp!= null){
             System.out.println(temp.value + " ->");
             temp= temp.next;

        }
        System.out.println("null");
      }

    //Insert using recursion 
    public void insertRec( int value ,int index){
        head = insertRec(value , index ,head);
        
    }
    private Node insertRec(int value, int index , Node node){
        if(index == 0){
            
            Node temp =  new Node(value ,node);
            size ++;
            return temp;
        }
        node.next = insertRec(value, index-1, node.next);
        return node;
    }

       public static void main(String[] args) {

        RecursiveInsertion list = new RecursiveInsertion();

        // Insert some elements
        list.insertRec(10, 0);
        list.insertRec(20, 1);
        list.insertRec(30, 2);

        System.out.println("Before insertion:");
        list.display();

        // Insert 15 at index 1
        list.insertRec(15, 1);

        System.out.println("After insertion at index 1:");
        list.display();
    }


    
}
