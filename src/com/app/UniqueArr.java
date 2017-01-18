package com.app;

/**
 * Created by admin on 2016/9/6.
 * 数组去重
 * 分析：声明另外的一个数组去存放去重过后的数据
 *      遍历原数组挨个去比较新存放的数组
 *      如果新数组里不包含原数组里的数，则添加
 */
public class UniqueArr {

    public static void main(String[] args) {
        int[] nums = {123, 0, 12, 123, 1211, 43, 1, 0, 123, 26, 234};
        int[] tmpNums = new int[nums.length];
        tmpNums[0] = nums[0];
        int index = 1;
        for (int i = 1, len = nums.length; i < len; i++) {
            boolean flag = true;
            for (int j = 0; j < index; j++) {
                if (tmpNums[j] == nums[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                tmpNums[index++] = nums[i];
            }
        }
        nums = new int[index];
        for (int i = 0; i < index; i++) {
            nums[i] = tmpNums[i];
        }
        for (int num : nums) {
            System.out.print(num + "\t");
        }
    }
}
