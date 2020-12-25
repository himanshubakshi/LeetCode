class BruteForce {
    // brute force
    fun lengthOfLongestSubstring(s: String): Int {
        val n = s.length
        var max = 0

        if (n > 1) {
            for (i in 0 until n) {
                for (j in i until n) {
                    if (areCharsUnique(s, i, j)) {
                        max = Math.max(max, j - i + 1)
                    }
                }
            }
            return max
        } else {
            return n
        }
    }

    private fun areCharsUnique(s: String, start: Int, end: Int): Boolean {
        val hashSet = mutableSetOf<Char>()

        for (i in start..end) {
            if (hashSet.contains(s[i])) {
                return false
            }

            hashSet.add(s[i])
        }

        return true
    }
}

class SlidingWindow {
    fun lengthOfLongestSubstring(s: String): Int {
        var i = 0
        var j = 0
        var max = 0
        val hashSet = mutableSetOf<Char>()
        val n = s.length

        while (i < n && j < n) {
            if (!hashSet.contains(s[j])) {
                hashSet.add(s[j++])
                max = Math.max(max, j - i)
            } else {
                hashSet.remove(s[i])
                i++
            }
        }

        return max
    }
}
class OptimizedSlidingWindow {
    fun lengthOfLongestSubstring(s: String): Int {
        var i = 0
        var j = 0
        var max = 0
        val hashMap = mutableMapOf<Char, Int>()
        val n = s.length

        while (i < n && j < n) {
            if (!hashMap.contains(s[j])) {
                hashMap.put(s[j], j++)
                max = Math.max(max, j - i)
            } else {
                i = hashMap.get(s[j])!! + 1
                hashMap.remove(s[j])
            }
        }

        return max
    }
}

fun main(args: Array<String>) {
    println(":" + OptimizedSlidingWindow().lengthOfLongestSubstring(""))
    println("abba: " + OptimizedSlidingWindow().lengthOfLongestSubstring("abba"))
    println("abcabcbb: " + OptimizedSlidingWindow().lengthOfLongestSubstring("abcabcbb"))
//    println(" :" + SlidingWindow().lengthOfLongestSubstring(" "))
//    println("a: " + SlidingWindow().lengthOfLongestSubstring("a"))
//    println("aa: " + SlidingWindow().lengthOfLongestSubstring("aa"))
//    println("abc: " + SlidingWindow().lengthOfLongestSubstring("abc"))
//    println("abcdabc: " + SlidingWindow().lengthOfLongestSubstring("abcdabc"))
//    println("abcdabdcx: " + SlidingWindow().lengthOfLongestSubstring("abcdabdcx"))
}