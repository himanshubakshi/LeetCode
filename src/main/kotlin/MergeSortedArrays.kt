class MergeSortedArrays {

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        // start at the end of each array
        var l1 = m - 1
        var l2 = n - 1
        var k = m + n - 1

        while (l1 >= 0 && l2 >= 0) {
            nums1[k--] = if (nums1[l1] > nums2[l2]) nums1[l1--] else nums2[l2--]
        }

        while (l2 >= 0) {
            nums1[k--] = nums2[l2--]
        }
    }
}

fun main() {
    val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
    val m = 3

    val nums2 = intArrayOf(2, 3, 6)
    val n = 3

    MergeSortedArrays().merge(nums1, m, nums2, n)
}