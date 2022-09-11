public class TestEx4 {
    public static void main(String[] args) {
        MyDoubleLinkedList douList = new MyDoubleLinkedList();
        douList.addFirst(7.5);
        douList.addFirst(7.2);
        douList.addFirst(3.5);
        douList.addFirst(5.8);
        douList.addFirst(9.25);
        douList.addFirst(7.593);
        douList.addFirst(11.333);
        douList.print();
        DoubleNode curr = douList.getHead().getNext().getNext();
        System.out.println(douList.removeAfter(curr));
        douList.print();
        System.out.println(douList.removeFirst());
        System.out.println(douList.removeLast());
        douList.print();
        System.out.println(douList.removeCurr(curr));
        douList.print();
        System.out.println(douList.contains(7.593));
        System.out.println(douList.isEmpty());
        System.out.println(douList.size());
    }
}
