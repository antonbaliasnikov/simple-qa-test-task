import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(Lifecycle.PER_CLASS)
class SimpleCalcTest {

    @ParameterizedTest
    @MethodSource("addPositiveCases")
    fun `Add - Positive Cases`(x: Int, y: Int, expectedResult: Int) {
        val result = SimpleCalc.add(x, y)
        assertThat(result).isEqualTo(expectedResult)
    }

    @ParameterizedTest
    @MethodSource("addNegativeCases")
    fun `Add - Negative Cases`(x: Int, y: Int) {
        val result = SimpleCalc.add(x, y).toLong()
        assertThat(result).isNotEqualTo(x.toLong() + y.toLong())
    }

    @ParameterizedTest
    @MethodSource("multiplyCases")
    fun `Multiply - Positive Cases`(x: Double, y: Double, expectedResult: Double) {
        val result = SimpleCalc.multiply(x, y)
        assertThat(result).isEqualTo(expectedResult)
    }

    @ParameterizedTest
    @MethodSource("sumOffEvensCases")
    fun `Sum Off Evens`(array: IntArray, expectedResult: Int) {
        val result = SimpleCalc.sumOffEvens(array)
        assertThat(result).isEqualTo(expectedResult)
    }

    private fun addPositiveCases(): Stream<Arguments> {
        return Stream.of(
            arguments(0, 0, 0),
            arguments(1, -2, -1),
            arguments(-2, 1, -1),
            arguments(0, Int.MAX_VALUE, Int.MAX_VALUE),
            arguments(Int.MAX_VALUE, 0, Int.MAX_VALUE),
            arguments(0, Int.MIN_VALUE, Int.MIN_VALUE),
            arguments(Int.MIN_VALUE, 0, Int.MIN_VALUE),
            arguments(Int.MAX_VALUE, Int.MIN_VALUE, -1)
        )
    }

    private fun addNegativeCases(): Stream<Arguments> {
        return Stream.of(
            arguments(Int.MAX_VALUE, 1),
            arguments(Int.MIN_VALUE, -1),
        )
    }

    private fun multiplyCases(): Stream<Arguments> {
        return Stream.of(
            arguments(0, 0, 0),
            arguments(Double.MAX_VALUE, 0, 0),
            arguments(0, Double.MIN_VALUE, 0),
            arguments(-1, 1, -1),
            arguments(1, 1, 1),
            arguments(-1, -1, 1),
            arguments(Double.POSITIVE_INFINITY, 1, Double.POSITIVE_INFINITY),
            arguments(Double.NEGATIVE_INFINITY, 1, Double.NEGATIVE_INFINITY)
        )
    }

    private fun sumOffEvensCases(): Stream<Arguments> {
        return Stream.of(
            arguments(intArrayOf(1, 2, 3, 4, 5), 6),
            arguments(intArrayOf(1, 3), 0),
            arguments(intArrayOf(), 0)
        )
    }
}