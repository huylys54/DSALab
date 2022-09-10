public class TestEx1_2 {
    public static void main(String[] args) {
        MyLinkedList<Fraction> fracList = new MyLinkedList<>();
        fracList.addFirst(new Fraction(5, 2));
        fracList.addFirst(new Fraction(9, 6));
        fracList.addFirst(new Fraction(1024, 8));
        fracList.addFirst(new Fraction(128, 1));
        fracList.print();
        Node<Fraction> f1 = fracList.getHead();
        System.out.println(f1.getData().equals(f1.getNext().getData()));
        fracList.removeCurr(new Node<Fraction>(new Fraction(9, 6)));
        fracList.print();
    }
}
