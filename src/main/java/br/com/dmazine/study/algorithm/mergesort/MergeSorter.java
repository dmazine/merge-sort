package br.com.dmazine.study.algorithm.mergesort;

public class MergeSorter implements Sorter {

    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length);
    }

    public void sort(int[] arr, int startIndex, int endIndex) {
        if (arr == null) {
            throw new IllegalArgumentException("arr is null");
        }

        System.out.println(String.format("startIndex: %d, endIndex: %d", startIndex, endIndex));
        dump(arr);

        if (endIndex - startIndex < 2) {
            return;
        }

        final int middleIndex = startIndex + ((endIndex - startIndex) / 2);
        sort(arr, startIndex, middleIndex);
        sort(arr, middleIndex, endIndex);
        merge(arr, startIndex, endIndex);

        dump(arr);
    }

    private void merge(int[] arr, int startIndex, int endIndex) {
        final int[] tmp = new int[endIndex];
        int tmpIndex = 0;

        final int middleIndex = startIndex + ((endIndex - startIndex) / 2);

        int leftIndex = startIndex;
        int rightIndex = middleIndex;

        while ((leftIndex < middleIndex) && (rightIndex < endIndex)) {
            if (arr[leftIndex] <= arr[rightIndex]) {
                tmp[tmpIndex] = arr[leftIndex];
                leftIndex++;
            } else {
                tmp[tmpIndex] = arr[rightIndex];
                rightIndex++;
            }

            tmpIndex++;
        }

        while (leftIndex < middleIndex) {
            tmp[tmpIndex] = arr[leftIndex];
            leftIndex++;
            tmpIndex++;
        }

        while (rightIndex < endIndex) {
            tmp[tmpIndex] = arr[rightIndex];
            rightIndex++;
            tmpIndex++;
        }

        System.arraycopy(tmp, 0, arr, startIndex, endIndex - startIndex);
    }

    private static void dump(int[] arr) {
        System.out.print("arr = [ ");
        for (int index = 0; index < arr.length; index++) {
            System.out.print(String.format("%d, ", arr[index]));
        }
        System.out.println(" ]");
    }

}

