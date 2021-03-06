package weekly269;

/**
 * https://leetcode.com/contest/weekly-contest-269/
 * <p>
 * https://leetcode.com/problems/removing-minimum-and-maximum-from-array/
 * <p>
 * https://leetcode.com/problems/removing-minimum-and-maximum-from-array/discuss/1599848/JavaC%2B%2BPython-Straight-Forward-Solutions
 */

public class _2091_RemovingMinAndMaxFromArray {

  public static void main(String[] args) {
    System.out.println(minimumDeletions(new int[]{2, 10, 7, 5, 4, 1, 8, 6})); //  5
    System.out.println(minimumDeletions(new int[]{0, -4, 19, 1, 8, -2, -3, 5}));  // 3
    System.out.println(minimumDeletions(new int[]{101})); // 1
    System.out.println(minimumDeletions(new int[]{2, 10, 1, 3})); // 3
  }

  public static int minimumDeletions(int[] nums) {

    int n = nums.length;

    int min = nums[0], minIndex = 0;
    int max = nums[0], maxIndex = 0;

    for (int i = 1; i < n; i++) {
      if (nums[i] > max) {
        max = nums[i];
        maxIndex = i;
      } else if (nums[i] < min) {
        min = nums[i];
        minIndex = i;
      }
    }

    /**
     * There can only be three scenarios for deletions such that both minimum and maximum elements are removed:
     *       Scenario 1: Both elements are removed by only deleting from the front / left.
     *       Scenario 2: Both elements are removed by only deleting from the back / right.
     *       Scenario 3: Delete from the front to remove one of the elements,
     *                   and delete from the back to remove the other element.
     *
     *       Compare which of the three scenarios results in the minimum number of moves.
     */

    int deleteFromLeft = 1 + Math.max(minIndex, maxIndex); // Scenario 1

    int deleteFromRight = n - Math.min(minIndex, maxIndex); // Scenario 2

    int deleteFromBothSides = ((1 + Math.min(minIndex, maxIndex)) + (n - Math.max(minIndex, maxIndex)));  // Scenario 3

    return Math.min(deleteFromBothSides, Math.min(deleteFromLeft, deleteFromRight));
  }
}
