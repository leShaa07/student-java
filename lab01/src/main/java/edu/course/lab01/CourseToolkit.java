package edu.course.lab01;

public final class CourseToolkit {

    private CourseToolkit() {  
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int div = 2; (long) div * div <= num; div++) {
            if (num % div == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text must not be null");
        }
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static double average(int[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Values must not be null or empty");
        }
        long sum = 0;
        for (int value : values) {
            sum += value;
        }
        return (double) sum / values.length;
    }
}