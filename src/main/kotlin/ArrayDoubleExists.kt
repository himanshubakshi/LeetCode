class ArrayDoubleExists {

    fun checkIfDoubleExists(arr: IntArray): Boolean {
        val hashSet = mutableSetOf<Int>()
        for (n in arr) {
            if (hashSet.contains(2 * n) || (n % 2 == 0 && hashSet.contains(n / 2))) {
                    return true
                }

                hashSet.add(n)
        }
        return false
    }
}