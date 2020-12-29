import kotlin.math.max

class MaxConsecutiveOnes {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        val listZero = mutableListOf<Int>()
        var counter = 0
        var max = 0

        for (i in 0 until nums.size) {
            if (nums[i] == 1) {
                counter++
            } else {
                // encountered 0
                max = max(max, listZero.lastOrNull() ?: 0 + counter + 1)
                listZero.add(counter)
                counter = 0
            }
        }

        if (listZero.isEmpty()) {
            // no zeros found in the array
            return counter
        } else {
            // at least 1 zero was found,
            // handle edge case of the array ending in consecutive 1s

            return max(max, listZero.last() + counter + 1)
        }
    }
}

fun main() {
    val result = MaxConsecutiveOnes().findMaxConsecutiveOnes(intArrayOf(1, 1, 1))

    println(result)
}