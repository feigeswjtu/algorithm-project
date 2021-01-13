package binarytree;

import model.BiTNode;

/**
 * Created by Administrator on 2017/7/31.
 */
public class BiTNodeSearchResult {
    private boolean status;
    private BiTNode node;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public BiTNode getNode() {
        return node;
    }

    public void setNode(BiTNode node) {
        this.node = node;
    }
}
