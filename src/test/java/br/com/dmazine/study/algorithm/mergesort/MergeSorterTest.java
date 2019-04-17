package br.com.dmazine.study.algorithm.mergesort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSorterTest {

    private Sorter sorter = new MergeSorter();

    @Test
    void sortingNullArray_shouldReturnIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            sorter.sort(null);
        });
    }

    @Test
    void sortingEmptyArray_shouldReturnTheSameArray() {
        final int[] arr = { };

        sorter.sort(arr);
        assertEquals(arr, arr);
    }

    @Test
    void sortingOneElementArray_shouldReturnTheSameArray() {
        final int[] arr = { 1 };

        sorter.sort(arr);
        assertEquals(arr, arr);
    }

    @Test
    void sortingUnsortedArray_shouldReturnSortedArray() {
        final int[] unsortedArray = { 2, 1 };
        final int[] sortedArray = { 1, 2 };


        sorter.sort(unsortedArray);
        assertArrayEquals(sortedArray, unsortedArray);
    }

    @Test
    void sortingUnsortedArray_shouldReturnSortedArray2() {
        final int[] unsortedArray = { 9, 4, 2, 5, 0, 1, 8, 1, 6, 3, 7 };
        final int[] sortedArray = { 0, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        sorter.sort(unsortedArray);
        assertArrayEquals(sortedArray, unsortedArray);
    }

}