import kotlin.math.max

fun main(){
    Arrays().duplicateZeros(intArrayOf(1,0,2,3,0,4,5,0))
}
class Arrays {

    fun duplicateZeros(arr: IntArray): Unit {

        val n = arr.size
        val zeroCount = IntArray(n)

        var counter = 0

        for(i in 0 until n){
            if(arr[i] == 0) {
                counter++
            }

            zeroCount[i] = counter
        }


        for (i in n-1 downTo 0) {
            var newPos = -1
            if(arr[i] != 0){
                newPos = i + zeroCount[i]
            } else {
                newPos = i + zeroCount[i] - 1
            }


            if(newPos < n && newPos >= 0) {
                arr[newPos] = arr[i]

                if(arr[i] == 0) {
                    arr[newPos + 1] = arr[i]
                }
            }
        }

        arr.forEach {
            print("$it ")
        }
    }


    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var count = 0
        var max = 0

        for (i in 0 until nums.size) {
            if (nums[i] == 1) {
                max = max(++count, max)
            } else {
                count = 0
            }
        }

        return max
    }

    fun getNumDigits(value: Int): Int {
        var digits = 0

        if (value == 0) {
            return 1
        }
        var temp = value
        while (temp != 0) {
            digits++
            temp /= 10
        }

        return digits
    }

    fun findNumbers(nums: IntArray): Int {
        return nums.filter { it.toString().length % 2 == 0 }.size
    }

    fun sortedSquares2(arr: IntArray): IntArray {
        val ans: IntArray = IntArray(arr.size)

        for (i in 0 until arr.size) {
            ans[i] = arr[i] * arr[i]
        }
        ans.sort()
        return ans
    }

    fun sortedSquares(arr: IntArray): IntArray {
        val ans: IntArray = IntArray(arr.size)

        // answer array index
        var j = 0

        while (arr[j] < 0) {
            j++
        }
        // traverse backwards
        var i = j - 1

        var k = 0
        while (i >= 0 && j < arr.size) {
            val negativeSquare = arr[i] * arr[i]
            val positiveSquare = arr[j] * arr[j]
            if (negativeSquare < positiveSquare) {
                ans[k++] = negativeSquare
                i--
            } else {
                ans[k++] = positiveSquare
                j++
            }
        }

        // either i < 0 or j ==  arr.size
        while (i >= 0) {
            ans[k++] = arr[i] * arr[i]
            i--
        }

        while (j < arr.size) {
            ans[k++] = arr[j] * arr[j]
            j++
        }

        return ans
    }
}