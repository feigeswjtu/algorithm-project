package link;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/3.
 */
public class LinkService {
    //删除重复数据空间复杂度高
    public void deleteDuplecate1(Node head){
        Set<Integer> set = new HashSet<>();
        Node tmp = head;
        Node pre = null;
        while (null != tmp){
            if(set.contains(tmp.getData())){
                pre.setNext(tmp.getNext());
            }else {
                set.add(tmp.getData());
               pre = tmp;
            }
            tmp = tmp.getNext();
        }

    }
    //删除重复数据时间复杂度高
    public void deleteDuplecate2(Node head){
        Node tmp = head;
        Node next = null;
        while (null != tmp){
            next = tmp.getNext();
            while (null != next){
                if(next.getData() == tmp.getData()){
                    tmp.setNext(next.getNext());
                }else {
                    next = next.getNext();
                }
            }
            tmp = tmp.getNext();
        }
    }

    // 查找倒数第k个元素
    public Node FindElem(Node head, int length, int k){
        if(k < 1 || k > length){
            return null;
        }
        Node p1 = head;
        Node p2 = head;
        for (int i=0; i<k; i++){
            p1 = p1.getNext();
        }
        while(null != p1){
            p1 = p1.getNext();
            p2 = p2.getNext();
        }
        return p2;
    }

    // 链表反转
    public Node reverse(Node head){
        Node head1 = head;
        Node head2 = head.getNext();
        Node head3 = head;
        while (null != head2) {
           head3 = head2.getNext();
           head2.setNext(head1);
           head1 = head2;
           head2 = head3;
        }
        return head1;
    }

    //从尾到头输出链表
    public void printListReversely(Node head){
        if(null != head){
            printListReversely(head.getNext());
            System.out.println(head.getData());
        }
    }

    //查找链表的中间节点
    public Node findMid(Node head){
        Node p = head;
        Node q = head;
        while (null != p && null != p.getNext() && null != p.getNext().getNext()){
            p = p.getNext().getNext();
            q = q.getNext();
        }
        return q;
    }
}
