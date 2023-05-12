package leetcode;

public class Node{
    int val;
    Node next;

    public Node() {
        val = 0;
        next = null;
    }



    public void hash() {
        this.hashCode();
    }

    public Node(int val) {
        this.val = val;
        this.next = null;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public String toString() {
        return "from to toString";
    }
    public static void main(String[] args) {
        Node n = new Node(1, null);
        System.out.println(n.hashCode());
        System.out.println(n.toString());
    }
}
