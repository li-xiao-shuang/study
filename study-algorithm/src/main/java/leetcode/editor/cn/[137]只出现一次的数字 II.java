package leetcode.editor.cn;
//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
//
// 说明：
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//
// 示例 1:
//
// 输入: [2,2,3,2]
//输出: 3
//
//
// 示例 2:
//
// 输入: [0,1,0,1,0,1,99]
//输出: 99
// Related Topics 位运算
// 👍 466 👎 0

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Topic137 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : countMap.entrySet()) {
            if (integerIntegerEntry.getValue() == 1) {
                return integerIntegerEntry.getKey();
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

