package model;

/**
 * Created by Administrator on 2017/7/31.
 */
public class BiTNode {
    private int data;
    private BiTNode lchild;
    private BiTNode hchild;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BiTNode getLchild() {
        return lchild;
    }

    public void setLchild(BiTNode lchild) {
        this.lchild = lchild;
    }

    public BiTNode getHchild() {
        return hchild;
    }

    public void setHchild(BiTNode hchild) {
        this.hchild = hchild;
    }

}
