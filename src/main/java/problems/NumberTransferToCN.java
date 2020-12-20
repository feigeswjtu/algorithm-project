package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字转中文大写
 *
 * @author chenyafei
 * @version 1.0
 * @date 19/03/2018 23:04
 */

public class NumberTransferToCN {
    private static final String[] CN_UPPER_NUMBER = { "零", "壹", "贰", "叁", "肆",
            "伍", "陆", "柒", "捌", "玖" };
    private static final String[] CN_UNIT_NAME = {"", "拾", "佰", "仟"};

    private static final String[] CN_HIGH_UNIT_NAME = {"", "万", "亿"};

    public static void main(String[] args) {
        System.out.println(transferHigh(1100006789));
    }

    private static String transferHigh(int number){
        List<String> list = new ArrayList<>();
        boolean hasLow = false;
        int position = 0;
        while (number > 0) {
            int tmp = number % 10000;
            if (tmp > 0) {
                list.add(CN_HIGH_UNIT_NAME[position]);
                list.add(transferLow(tmp));
                hasLow = true;
            }else {
                if(hasLow){
                    list.add("零");
                    hasLow = false;
                }
            }
            ++position;
            number = number /10000;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            stringBuilder.append(list.get(i));
        }
        return stringBuilder.toString();
    }

    private static String transferLow(int number){
        List<String> list = new ArrayList<>(8);
        int position = 0;
        boolean hasLow = false;
        while (number > 0) {
            int tmp = number % 10;
            if(tmp > 0) {
                list.add(CN_UNIT_NAME[position]);
                list.add(CN_UPPER_NUMBER[tmp]);
                hasLow = true;
            }else {
                if(hasLow) {
                    list.add("零");
                    hasLow = false;
                }
            }
            ++position;
            number = number/10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            stringBuilder.append(list.get(i));
        }
        return stringBuilder.toString();
    }
}
