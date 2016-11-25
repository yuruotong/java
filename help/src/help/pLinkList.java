package help;
public class pLinkList{
static class Node {
String study;
   String date;
   Node next;
   public Node(String date,String study) {// 构造方法，为data赋值
       this.date = date;
       this.study=study;
       this.next = null;
   }
}
public pLinkList() {
    head = null;// 链表的构造方法
}
Node head;
public int size() {// 节点个数
    Node p = head;
    int sum = 0;
    while (p != null) {
        sum++;
        p = p.next;
    }
    return sum;
}
public void insert(String date,String study, int pos) {
    if (pos < 0 || pos > size()) {
        throw new RuntimeException("下标错误");
    }
    Node newNode = new Node(date,study);
    if (pos == 0) {
        newNode.next = head;
        head = newNode;
    } else if (pos >= size() - 1) {
        get(size() - 1).next = newNode;
    } else {
        newNode.next = get(pos);
        get(pos - 1).next = newNode;
    }
}
public Node get(int pos) {
    if (pos < 0 || pos > size()) {
        throw new RuntimeException("下标错误");
    }
    if (pos == 0)
        return head;
    Node p = head;
    for (int i = 0; i < pos; i++)
        p = p.next;
    return p;
}
}

