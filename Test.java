public class Test{
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.addFirst("a");
        list.addFirst("b");
        list.addFirst("c");
        list.addFirst("d");
        list.addFirst("e");
        list.addFirst("h");
        list.print();
        list.removeFirst();
        list.removeLast();
        Node<String> cur = list.getHead();
        cur = cur.getNext();
        list.removeAfter(cur);
        list.print();
        
    }
}