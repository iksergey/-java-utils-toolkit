package ru.ksergey;

public class Utils {
    private int lastResult;

    public int add(int a, int b) {
        lastResult = a + b;
        return lastResult;
    }

    public int subtract(int a, int b) {
        lastResult = a - b;
        return lastResult;
    }

    public int multiply(int a, int b) {
        lastResult = a * b;
        return lastResult;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Деление на ноль недопустимо");
        }
        return (double) a / b;
    }

    public int getLastResult() {
        return lastResult;
    }

    public void clearLastResult() {
        lastResult = 0;
    }

    public boolean isPositive(int number) {
        return number > 0;
    }

    public int[] sortArray(int[] collection) {
        if (collection == null || collection.length == 0) {
            return new int[0];
        }

        int[] sortedArray = collection.clone();

        sort(sortedArray, 0, collection.length - 1);

        return sortedArray;
    }

    private void sort(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int pivot = array[(left + right) / 2];

        while (i <= j) {
            while (array[i] < pivot)
                i++;
            while (array[j] > pivot)
                j--;

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (i < right)
            sort(array, i, right);
        if (left < j)
            sort(array, left, j);
    }

    public void longOperation() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
