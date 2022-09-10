public class TestEx3{
    public static void main(String[] args) {
        IntegerLinkedList intList = new IntegerLinkedList();
        intList.addFirst(3);
        intList.addFirst(2);
        intList.addFirst(4);
        intList.addFirst(6);
        intList.addFirst(5);
        intList.addFirst(7);
        intList.print();
        System.out.println(intList.countEven());
        System.out.println(intList.countPrime());
        System.out.println(intList.max());
        intList.reverse();
        intList.print();
        // intList.sort(); not working properly
        // intList.print();
    }
}