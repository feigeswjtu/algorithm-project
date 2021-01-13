package problems.circleoflink;

import model.Node;

/**
 * @author feigeswjtu.cyf
 * @version $Id: CircleLinkServiceImpl.java, v 0.1 2021-01-13 14:07 feigeswjtu.cyf Exp $$
 */
public class CircleLinkServiceImpl implements CircleLinkService {
    /**
     * 返回是否有环
     *
     * @param node
     * @return
     */
    @Override
    public boolean hasCircle(Node node) {
        if (node == null) {
            return false;
        }
        // 找到相遇的节点
        Node enterCircleNode = getEnterCircleNode(node);

        return enterCircleNode != null;
    }

    /**
     * 计算环的长度
     *
     * @param node
     * @return
     */
    @Override
    public int calculateCircleLength(Node node) {
        if (node == null) {
            return 0;
        }

        // 找到相遇的节点
        Node enterCircleNode = getMeetNode(node);
        if (enterCircleNode == null) {
            return 0;
        }

        int length = 0;

        // 定义步长分别为1和2的节点，从相遇的节点开始遍历
        Node step1Node = enterCircleNode;
        Node step2Node = enterCircleNode;
        do {
            step1Node = step1Node.getNext();
            step2Node = step2Node.getNext();

            if (step2Node != null) {
                step2Node = step2Node.getNext();
            }

            length++;
            // 直到相遇的时候，就得到换的长度
        } while (step1Node != step2Node && step1Node != null && step2Node != null);

        return length;
    }

    /**
     * 返回入环节点
     *
     * @param node
     * @return
     */
    @Override
    public Node getEnterCircleNode(Node node) {
        if (node == null) {
            return null;
        }

        Node enterCircleNode = getMeetNode(node);
        if (enterCircleNode == null) {
            return null;
        }

        // 头节点开始
        Node step1Node = node;
        // 从相遇的节点开始
        Node step2Node = enterCircleNode;
        do {
            step1Node = step1Node.getNext();
            step2Node = step2Node.getNext();

            // 当他们相遇的时候，就是入口节点
            if (step1Node == step2Node) {
                return step1Node;
            }
        } while (step1Node != null && step2Node != null);

        return null;
    }

    /**
     * 两个指针 一个步长为2， 一个步长为1，首次相遇的节点
     *
     * @param node
     * @return
     */
    private Node getMeetNode(Node node) {
        if (node.getNext() == null) {
            return null;
        }

        // 定义步长分别为1和2的节点
        Node step1Node = node;
        Node step2Node = node;
        do {
            step1Node = step1Node.getNext();
            step2Node = step2Node.getNext();
            if (step2Node != null) {
                step2Node = step2Node.getNext();
            }

            // 如果相等时返回相等的节点
            if (step1Node == step2Node) {
                return step1Node;
            }
            // 直到循环结束
        } while (step1Node != null && step2Node != null);

        return null;
    }

}