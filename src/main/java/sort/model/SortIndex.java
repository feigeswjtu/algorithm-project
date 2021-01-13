package sort.model;

/**
 * @author feigeswjtu.cyf
 * @version $Id: SortIndex.java, v 0.1 2020-11-06 10:29 feigeswjtu.cyf Exp $$
 */
public class SortIndex {
    /**
     * 默认构造方法
     */
    public SortIndex() {
    }

    /**
     * 带参数构造方法
     *
     * @param startIndex
     * @param endIndex
     */
    public SortIndex(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    /** 开始坐标 */
    private int startIndex;

    /** 结束坐标 */
    private int endIndex;

    /**
     * Getter method for property startIndex.
     *
     * @return property value of startIndex
     */
    public int getStartIndex() {
        return startIndex;
    }

    /**
     * Setter method for property startIndex.
     *
     * @param startIndex value to be assigned to property startIndex
     */
    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    /**
     * Getter method for property endIndex.
     *
     * @return property value of endIndex
     */
    public int getEndIndex() {
        return endIndex;
    }

    /**
     * Setter method for property endIndex.
     *
     * @param endIndex value to be assigned to property endIndex
     */
    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }
}