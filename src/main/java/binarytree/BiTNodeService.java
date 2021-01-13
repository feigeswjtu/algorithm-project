package binarytree;

import model.BiTNode;

/**
 * Created by Administrator on 2017/7/31.
 */
public class BiTNodeService {
    //二叉排序树的查找
    public BiTNodeSearchResult searchBST(BiTNode node, BiTNode nodeP, int key) {
        if (null == node) {
            BiTNodeSearchResult result = new BiTNodeSearchResult();
            result.setNode(nodeP);
            result.setStatus(false);
            return result;
        } else if (node.getData() == key) {
            BiTNodeSearchResult result = new BiTNodeSearchResult();
            result.setNode(node);
            result.setStatus(true);
            return result;
        } else if (key < node.getData()) {
            return searchBST(node.getLchild(), node, key);
        } else {
            return searchBST(node.getHchild(), node, key);
        }
    }
}
