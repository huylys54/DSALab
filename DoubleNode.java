public class DoubleNode{
    private double data;
    private DoubleNode next;

    public DoubleNode(){
        this.next = null;
    }

    public DoubleNode(double data, DoubleNode next){
        this.data = data;
        this.next = next;
    }

    public DoubleNode(double data){
        this(data, null);
    }

    public double getData(){
        return this.data;
    }
    
    public DoubleNode getNext(){
        return this.next;
    }

    public void setNext(DoubleNode next){
        this.next = next;
    }
}