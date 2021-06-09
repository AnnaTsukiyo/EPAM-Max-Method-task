package org.example;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MaxMethodTests {
    @Test
    @DisplayName("For a null returns empty")
    public void testReturnsEmptyForNull() {
        int[] values = null;
        OptionalInt result = MaxMethod.max(values);
        assertEquals(OptionalInt.empty(), result);
    }

    @Test
    @DisplayName("For an empty array return empty")
    void testReturnsEmptyForEmptyArray() {
        int[] values = new int[0];
        OptionalInt result = MaxMethod.max(values);
        assertEquals(OptionalInt.empty(), result);
    }

    @Test
    @DisplayName("For an array of length 1 returns its only value")
    void testReturnArraysSingleValue() {
        int[] values = new int[]{10};
        OptionalInt result = MaxMethod.max(values);
        assertNotNull(result);
        assertTrue(result.isPresent());
        assertEquals(values[0], result.getAsInt());
    }

    @Test
    @DisplayName("For an array of negative ints returns correct max")
    void testReturnMaxForNegativeValues() {
        int[] values = new int[]{-4, -3, -3, -10, -2, -145};
        OptionalInt result = MaxMethod.max(values);
        assertNotNull(result);
        assertTrue(result.isPresent());
        assertEquals(-2, result.getAsInt());
    }

    @ParameterizedTest
    @MethodSource("makeValues")
    @DisplayName("For an array of length 10 returns its max value")
    void testReturnsMaxValue(int[] values) {
        int max = IntStream.of(values).reduce(Integer.MIN_VALUE, Math::max);
        OptionalInt result = MaxMethod.max(values);
        assertNotNull(result);
        assertTrue(result.isPresent());
        assertEquals(max, result.getAsInt());
    }

    static Stream<int[]> makeValues() {
        int rangeLen = 10000;
        int halfRange = rangeLen / 2;
        int maxLen = 1000000;

        Random rand = new Random();
        Stream.Builder<int[]> builder = Stream.builder();
        for (int len = 1; len <= maxLen; len *= 2) {
            int[] values = new int[len];
            for (int i = 0; i < len; ++i) {
                values[i] = rand.nextInt(rangeLen) - halfRange;
            }
            builder.add(values);
        }

        return builder.build();
    }
}
