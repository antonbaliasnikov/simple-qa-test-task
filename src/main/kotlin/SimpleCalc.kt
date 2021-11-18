object SimpleCalc {

    /**
     * Adds 2 integers
     */
    fun add(x: Int, y: Int): Int {
        return x + y
    }

    /**
     * Multiplies 2 doubles
     */
    fun multiply(x: Double, y: Double): Double {
        return x * y
    }

    /**
     * Returns sum of all even array elements
     */
    fun sumOffEvens(arr: IntArray): Int {
        var result = 0
        for (i in arr) {
            if (i % 2 == 0) result += i
        }
        return result
    }
}