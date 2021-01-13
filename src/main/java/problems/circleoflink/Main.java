package problems.circleoflink;

import model.Node;
import org.testng.Assert;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Main.java, v 0.1 2021-01-13 14:00 feigeswjtu.cyf Exp $$
 */
public class Main {
    public static void main(String[] args) {
        CircleLinkService circleLinkService = new CircleLinkServiceImpl();

        // 有环
        Node node = buildCircleLink();
        boolean hasCircle = circleLinkService.hasCircle(node);
        Assert.assertTrue(hasCircle);

        int circleLength = circleLinkService.calculateCircleLength(node);
        Assert.assertEquals(circleLength, 56);

        Node enterCircleNode = circleLinkService.getEnterCircleNode(node);
        Assert.assertNotNull(enterCircleNode);
        Assert.assertEquals(enterCircleNode.getData(), 44);

        // 无环
        node = buildNoCircleLink();
        hasCircle = circleLinkService.hasCircle(node);
        Assert.assertFalse(hasCircle);

        circleLength = circleLinkService.calculateCircleLength(node);
        Assert.assertEquals(circleLength, 0);

        enterCircleNode = circleLinkService.getEnterCircleNode(node);
        Assert.assertNull(enterCircleNode);

        // 环为null
        node = buildNullLink();
        hasCircle = circleLinkService.hasCircle(node);
        Assert.assertFalse(hasCircle);

        circleLength = circleLinkService.calculateCircleLength(node);
        Assert.assertEquals(circleLength, 0);

        enterCircleNode = circleLinkService.getEnterCircleNode(node);
        Assert.assertNull(enterCircleNode);
    }

    /**
     * 构造一个有环链表
     *
     * @return
     */
    private static Node buildCircleLink() {
        Node enterCircleNode = null;

        Node node = new Node();
        node.setData(0);
        Node resultNode = node;
        for (int i = 1; i < 100; i++) {
            Node nextNode = new Node();
            nextNode.setData(i);
            node.setNext(nextNode);
            if (i == 44) {
                enterCircleNode = nextNode;
            }
            node = nextNode;
        }

        node.setNext(enterCircleNode);

        return resultNode;
    }

    /**
     * 构造一个无环链表
     *
     * @return
     */
    private static Node buildNoCircleLink() {
        Node node = new Node();
        node.setData(0);
        Node resultNode = node;
        for (int i = 1; i < 100; i++) {
            Node nextNode = new Node();
            nextNode.setData(i);
            node.setNext(nextNode);

            node = nextNode;
        }

        return resultNode;
    }

    /**
     * 构造null链表
     *
     * @return
     */
    private static Node buildNullLink() {
        return null;
    }
}