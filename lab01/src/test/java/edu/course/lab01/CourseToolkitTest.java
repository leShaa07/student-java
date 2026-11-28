package edu.course.lab01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CourseToolkitTest {

    // ----------isEven-----------

    @Test
    void returnsTrueForEvenNumber() {
        boolean result = CourseToolkit.isEven(8);

        assertTrue(result);
    }

    @Test
    void returnsFalseForOddNumber() {
        boolean result = CourseToolkit.isEven(7);

        assertFalse(result);
    }

    @Test
    void returnsTrueForZero() {
        boolean result = CourseToolkit.isEven(0);

        assertTrue(result);
    }

    @Test
    void returnsTrueForNegativeEvenNumber() {
        boolean result = CourseToolkit.isEven(-8);

        assertTrue(result);
    }

    // ----------isPrime-----------

    @ParameterizedTest 
    @ValueSource(ints = {-7, 0, 1, 4, 9, 15, 16, 49})
    void returnsFalseForNonPrimeNumbers(int num) {
        boolean result = CourseToolkit.isPrime(num);

        assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 17, 97})
    void returnsTrueForPrimeNumbers(int num) {
        boolean result = CourseToolkit.isPrime(num);

        assertTrue(result);
    }

    // ----------isPalindrome-----------

    @Test 
    void returnsTrueForPalindrome() {
        boolean result = CourseToolkit.isPalindrome("abba");

        assertTrue(result);
    }

    @Test
    void returnsFalseForNonPalindrome() {
        boolean result = CourseToolkit.isPalindrome("abc");

        assertFalse(result);
    }

    @Test 
    void returnsTrueForSingleCharacter() {
        boolean result = CourseToolkit.isPalindrome("a");

        assertTrue(result);
    }

    @Test 
    void returnsTrueForEmptyString() {
        boolean result = CourseToolkit.isPalindrome("");

        assertTrue(result);
    }

    @Test
    void throwsForNullText() {
        assertThrows(IllegalArgumentException.class,
            () -> CourseToolkit.isPalindrome(null));
    }

    @Test
    void returnsFalseWhenLetterCaseDiffers() {
        boolean result = CourseToolkit.isPalindrome("Abba");

        assertFalse(result);
    }


    // ----------average-----------

    @Test
    void returnsAveragePositiveNumbers() {
        double result = CourseToolkit.average(new int[]{1, 2, 3, 4, 5});
        assertEquals(3.0, result, 1e-9);
    }

    @Test 
    void returnsFractionalAverage() {
        double result = CourseToolkit.average(new int[]{1, 2});
        assertEquals(1.5, result, 1e-9);
    }

    @Test
    void returnsAverageNegativeNumbers() {
        double result = CourseToolkit.average(new int[]{-1, -2, -3});
        assertEquals(-2.0, result, 1e-9);
    }

    @Test
    void throwsForNullArray() {
        assertThrows(IllegalArgumentException.class,
            () -> CourseToolkit.average(null));
    }

    @Test
    void throwsForEmptyArray() {
        assertThrows(IllegalArgumentException.class,
            () -> CourseToolkit.average(new int[]{}));
    }

    @Test
    void doesNotModifyArray() {
        int[] values = {3, 1, 2};
        int[] copy = values.clone();

        CourseToolkit.average(values);

        assertArrayEquals(copy, values);
    }

    @Test
    void returnsTrueForLargestIntPrime() {
        assertTrue(CourseToolkit.isPrime(Integer.MAX_VALUE));
    }

    @Test
    void returnsTrueForOddLengthPalindrome() {
        assertTrue(CourseToolkit.isPalindrome("aba"));
    }

    @Test
    void averageDoesNotOverflowOnLargeValues() {
        double result = CourseToolkit.average(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE});
        assertEquals(Integer.MAX_VALUE, result, 1e-9);
    }
}
