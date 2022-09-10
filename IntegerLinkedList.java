import java.util.NoSuchElementException;

public class IntegerLinkedList extends MyLinkedList<Integer>{
    
    public IntegerLinkedList(){
        super();
    }

    public int countEven() throws NoSuchElementException{
        if(this.size() == 0){
            throw new NoSuchElementException("Empty LinkedList!");
        }
        int count = 0;
        Node<Integer> curr = this.head;
        while(curr != null){
            if(curr.getData() % 2 == 0){
                count++;
            }
            curr = curr.getNext();
        }
        return count;
    }
    private boolean checkPrime(int x){
        if(x < 2){
            return false;
        }
        if(x == 2){
            return true;
        }
        for(int i = 2; i < x; i++){
            if(x % i == 0){
                return false;
            }
        }
        return true;
    }
    public int countPrime() throws NoSuchElementException{
        if(this.size() == 0){
            throw new NoSuchElementException("Empty LinkedList!");
        }
        int count = 0;
        Node<Integer> cur = this.head;
        while(cur != null){
            if(checkPrime(cur.getData())){
                count++;
            }
            cur = cur.getNext();
        }
        return count;
    }
    public void addFirstEven(int item) throws NoSuchElementException{
        if(this.size() == 0){
            throw new NoSuchElementException("Empty LinkedList!");
        }
        if(this.head.getData() % 2 == 0){
            addFirst(item);
            return;
        }
        Node<Integer> curr = this.head;
        while(curr.getNext() != null){
            if(curr.getNext().getData() % 2 == 0){
                this.addAfter(curr, item);
                return;
            }
            curr = curr.getNext();
        }
        throw new NoSuchElementException("Even number not found!");
    }

    public int max() throws NoSuchElementException{
        if(this.size() == 0){
            throw new NoSuchElementException("Empty LinkedList!");
        }
        if(this.size() == 1){
            return this.head.getData();
        }
        int max = this.head.getData();
        Node<Integer> curr = this.head.getNext();
        while(curr != null){
            if(curr.getData() > max){
                max = curr.getData();
            }
            curr = curr.getNext();
        }
        return max;
    }

    public void reverse(){
        if(this.head == null || this.size() == 1){
            return;
        }
        Node<Integer> tmp = this.head;
        Node<Integer> prev = null;
        Node<Integer> next = null;
        while(tmp != null){
            next = tmp.getNext();
            tmp.setNext(prev);
            prev = tmp;
            tmp = next;
        }
        this.head = prev;
    }

    public void sort(){
        if(this.head == null || this.head.getNext() == null){
            return;
        }
        Node<Integer> curr = this.head;
        Node<Integer> prev = curr;
        Node<Integer> next = null, tmp;
        while(curr.getNext() != null){
            next = curr.getNext();
            while(next != null){

                if(curr.getData() > next.getData()){
                    //swap next node
                    curr.setNext(next.getNext());
                    next.setNext(curr);
                    if(curr != this.head){
                        prev.setNext(next);
                    }else{
                        this.head = next;
                    }
                    //swap ref
                    tmp = curr;
                    curr = next;
                    next = tmp;
                }
                next = next.getNext();
            }
            prev = curr;
            curr = curr.getNext();
        }
        
    }
}
