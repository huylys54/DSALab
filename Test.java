public class Test{
    public static void main(String[] args) {
        //MyLinkedList test
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
        list.removeCurr(new Node<String>("d"));
        list.print();


        //Fraction list test
        MyLinkedList<Fraction> fracList = new MyLinkedList<>();
        fracList.addFirst(new Fraction(5, 2));
        fracList.addFirst(new Fraction(9, 6));
        fracList.addFirst(new Fraction(1024, 8));
        fracList.addFirst(new Fraction(128, 1));
        fracList.print();
        Node<Fraction> f1 = fracList.getHead();
        System.out.println(f1.getData().equals(f1.getNext().getData()));
    }
}