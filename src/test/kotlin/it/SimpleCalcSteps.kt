package it

import SimpleCalc
import com.google.common.truth.Truth
import io.cucumber.java.Before
import io.cucumber.java.ParameterType
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import java.util.stream.Collectors

class SimpleCalcSteps {

    private var result: Number? = null

    @Before
    fun setup() {
        result = null
    }

    @Given("SimpleCalc exists")
    fun `SimpleCalc exists`() {
        // if an object creation was needed
    }

    @When("I add {int} and {int}")
    fun `Sum x and y`(x: Int, y: Int) {
        result = SimpleCalc.add(x, y)
    }

    @When("I multiply {double} and {double}")
    fun `Multiply x and y`(x: Double, y: Double) {
        result = SimpleCalc.multiply(x, y)
    }

    @When("I sum the evens of [{intArray}]")
    fun `Sum evens of array`(list: IntArray) {
        result = SimpleCalc.sumOffEvens(list)
    }

    @When("I sum the evens of empty array")
    fun `Sum evens of empty array`() {
        result = SimpleCalc.sumOffEvens(intArrayOf())
    }

    @Then("the result should be int {int}")
    fun `Compare int result`(expectedResult: Int) {
        Truth.assertThat(result!!.toInt()).isEqualTo(expectedResult)
    }

    @Then("the result should be double {double}")
    fun `Compare double result`(expectedResult: Double) {
        Truth.assertThat(result!!.toDouble()).isEqualTo(expectedResult)
    }

    @ParameterType("([^;]+),?")
    fun intArray(input: String): IntArray {
        return input.split(", ").stream()
            .map { it.toInt() }
            .collect(Collectors.toList())
            .toIntArray()
    }
}