import java.util.NoSuchElementException;

public class MyDoubleLinkedList{
    private DoubleNode head;
    private int numNode;

    public MyDoubleLinkedList(){
        this.head = null;
        this.numNode = 0;
    }


    public void addFirst(double item) {
        if(this.head == null){
            this.head = new DoubleNode(item);
            this.numNode++;
            return;
        }
        this.head = (new DoubleNode(item, this.head));
        this.numNode++;
    }

    public void addAfter(DoubleNode curr, double item){
        if(curr.getNext() != null){
            curr.setNext(new DoubleNode(item, curr.getNext()));
            numNode++;
            return;
        }
        if(curr.getNext() == null){
            addFirst(item);
        }
    }

    public void addLast(double item){
        if(this.head == null){
            addFirst(item);
        }
        DoubleNode curr = this.head;
        while(curr.getNext() != null){
            curr = curr.getNext();
        }
        curr.setNext(new DoubleNode(item));
        this.numNode++;
    }

    public double removeFirst() throws NoSuchElementException{
        if(this.head == null){
            throw new NoSuchElementException("Can't remove!");
        }
        double del = this.head.getData();
        this.head = this.head.getNext();
        this.numNode--;
        return del;
    }

    public double removeAfter(DoubleNode curr) throws NoSuchElementException{
        if(this.head == null || this.head.getNext() == null){
            throw new NoSuchElementException("Can't remove");
        }
        double del = curr.getNext().getData();
        curr.setNext(curr.getNext().getNext());
        this.numNode--;
        return del;
    }

    public double removeCurr(DoubleNode curr) throws NoSuchElementException{
        if(head == null){
            throw new RuntimeException("Empty list!");
        }

        if(curr.getData() == head.getData()){
            removeFirst();
        }
        DoubleNode tmp = this.head;
        DoubleNode prev = null;
        while(tmp != null && Double.compare(tmp.getData(), curr.getData()) != 0){
            prev = tmp;
            tmp = tmp.getNext();
        }

        if(tmp == null){
            throw new NoSuchElementException("Element not found!");
        }

        prev.setNext(tmp.getNext());
        double del = tmp.getData();
        tmp = null;
        this.numNode--;
        return del;
    }

    public double removeLast() throws NoSuchElementException{
        if(numNode == 0){
            throw new NoSuchElementException("Can't remove!");
        }
        if(numNode == 1){;  
            return removeFirst();
        }
        DoubleNode curr = this.head;
        while(curr.getNext().getNext() != null){
            curr = curr.getNext();
        }
        double del = curr.getNext().getData();
        curr.setNext(null);
        this.numNode--;
        return del;
    }

    public int size(){
        return this.numNode;
    }

    public boolean contains(double item){
        DoubleNode curr = this.head;
        while(curr != null){
            if(Double.compare(curr.getData(), item) == 0){
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }

    public boolean isEmpty(){
        return this.numNode == 0;
    }

    public DoubleNode getHead(){
        return this.head;
    }

    public double getFirst(){
        return this.head.getData();
    }

    public void print(){
        if(head == null){
            System.out.println("Empty list!");
            return;
        }
        DoubleNode cur = head;
        System.out.print(cur.getData());
        cur = cur.getNext();
        while(cur != null){
            System.out.print(", " + cur.getData());
            cur = cur.getNext();
        }
        System.out.println();
    }
}