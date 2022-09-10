import java.util.NoSuchElementException;


public class MyLinkedList<E> implements ListInterface<E>{
    protected Node<E> head;
    protected int numNode;

    public MyLinkedList(){
        head = null;
        numNode = 0;
    }

    @Override
    public void addFirst(E item){
        head = new Node<E>(item, head);
        numNode++;
    }

    public void addAfter(Node<E> curr, E item){
        if(curr.getNext() != null){
            Node<E> newNode = new Node<>(item, curr.getNext());
            curr.setNext(newNode);
            numNode++;
            return;
        }
        if(curr.getNext() == null){
            addFirst(item);
        }
    }

    public void addLast(E item){
        if(head == null){
            addFirst(item);
        }
        Node<E> curr = head;
        while(curr.getNext() != null){
            curr = curr.getNext();
        }
        curr.setNext(new Node<E>(item));
        numNode++;
    }

    public E removeFirst() throws NoSuchElementException{
        if(head == null){
            throw new NoSuchElementException("Can't remove!\n");
        }
        E delData = head.getData();
        head = head.getNext();
        numNode--;
        return delData;
    }

    public E removeAfter(Node<E> curr) throws NoSuchElementException{
        if(curr == null){
            throw new NoSuchElementException("Can't remove!");
        }
        if(curr.getNext() == null){
            throw new NoSuchElementException("No Node after!");
        }
        E del = curr.getData();
        curr.setNext(curr.getNext().getNext());
        numNode--;
        return del;
    }

    public E removeLast() throws NoSuchElementException{
        if(numNode == 0){
            throw new NoSuchElementException("Can't remove!");
        }
        if(numNode == 1){;  
            return removeFirst();
        }
        Node<E> current = head;
        while(current.getNext().getNext() != null){
            current = current.getNext();
        }
        E del = current.getData();
        current.setNext(null);
        this.numNode--;
        return del;
    }

    public E removeCurr(Node<E> curr) throws NoSuchElementException{
        if(head == null){
            throw new RuntimeException("Empty list!");
        }

        if(curr.getData() == head.getData()){
            removeFirst();
        }
        Node<E> tmp = this.head;
        Node<E> prev = null;
        while(tmp != null && !(tmp.getData().equals(curr.getData()))){
            prev = tmp;
            tmp = tmp.getNext();
        }

        if(tmp == null){
            throw new NoSuchElementException("Element not found!");
        }

        prev.setNext(tmp.getNext());
        E del = tmp.getData();
        tmp = null;
        this.numNode--;
        return del;
    }

    public int size(){
        return numNode;
    }

    public boolean contain(E item){
        Node<E> cur = head;
        while(cur != null){
            if(cur.getData().equals(item)){
                return true;
            }
            cur = cur.getNext();
        }
        return false;
    }

    public void print(){
        if(head == null){
            System.out.println("Empty list!");
            return;
        }
        Node<E> cur = head;
        System.out.print(cur.getData());
        cur = cur.getNext();
        while(cur != null){
            System.out.print(", " + cur.getData());
            cur = cur.getNext();
        }
        System.out.println();
    }

    public boolean isEmpty(){
        return numNode == 0;
    }

    public Node<E> getHead(){
        return this.head;
    }

    public E getFirst(){
        return this.head.getData();
    }
}