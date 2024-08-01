package ru.ksergey.datastructures.ex108;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void sortedArrayToBSTTestEmptyArray() {
        int[] nums = {};
        TreeNode result = solution.sortedArrayToBST(nums);
        assertNull(result);
    }

    @Test
    void sortedArrayToBSTTestSingleElementArray() {
        int[] nums = {5};
        TreeNode result = solution.sortedArrayToBST(nums);
        assertEquals(5, result.val);
        assertNull(result.left);
        assertNull(result.right);
    }

    @Test
    void sortedArrayToBSTTestTwoElementArray() {
        int[] nums = {1, 3};
        TreeNode result = solution.sortedArrayToBST(nums);
        assertEquals(1, result.val);
        assertEquals(3, result.right.val);
        assertNull(result.left);
    }

    @Test
    void sortedArrayToBSTTestOddNumberOfElements() {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode result = solution.sortedArrayToBST(nums);
        assertEquals(0, result.val);

        assertEquals(-10, result.left.val);
        assertEquals(-3, result.left.right.val);

        assertEquals(5, result.right.val);
        assertEquals(9, result.right.right.val);
    }

    @Test
    void sortedArrayToBSTTestEvenNumberOfElements() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        TreeNode result = solution.sortedArrayToBST(nums);
        assertEquals(1, result.left.val);
        assertEquals(2, result.left.right.val);
        assertEquals(5, result.right.val);
        assertEquals(4, result.right.left.val);
        assertEquals(6, result.right.right.val);
    }

    @Test
    void sortedArrayToBSTTestLargeArray() {
        int[] nums = new int[1000];
        for (int i = 0; i < 1000; i++) {
            nums[i] = i;
        }
        TreeNode result = solution.sortedArrayToBST(nums);
        assertEquals(499, result.val);
        assertEquals(249, result.left.val);
        assertEquals(749, result.right.val);
    }

    @Test
    void sortedArrayToBSTTestBalanced() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        TreeNode result = solution.sortedArrayToBST(nums);
        assertTrue(isBalanced(result));
    }

    private boolean isBalanced(TreeNode node) {
        if (node == null) {
            return true;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}
