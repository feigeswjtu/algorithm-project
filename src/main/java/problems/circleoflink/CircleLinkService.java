package problems.circleoflink;

import model.Node;

/**
 * @author feigeswjtu.cyf
 * @version $Id: CircleLinkService.java, v 0.1 2021-01-13 14:02 feigeswjtu.cyf Exp $$
 */
public interface CircleLinkService {
    /**
     * 返回是否有环
     *
     * @param node
     * @return
     */
    boolean hasCircle(Node node);

    /**
     * 计算环的长度
     *
     * @param node
     * @return
     */
    int calculateCircleLength(Node node);

    /**
     * 返回入环节点
     *
     * @param node
     * @return
     */
    Node getEnterCircleNode(Node node);

}