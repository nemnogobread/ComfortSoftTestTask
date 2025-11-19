package com.example.ComfortSoftTestTask;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@org.springframework.stereotype.Service
public class Service {
    private final Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public Integer findNStatistics(String path, int n) {
        List<Integer> numbers = repository.getDataFromXLSX(path);

        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
        }
        if (n < 1 || n > numbers.size()) {
            throw new IllegalArgumentException("n must be between 1 and list size");
        }

        // Convert List to array for in-place operations
        Integer[] nums = numbers.toArray(new Integer[0]);
        return recursiveQuickSelect(nums, 0, nums.length - 1, n - 1);
    }

    private static Integer recursiveQuickSelect(Integer[] arr, int left, int right, int n) {
        if (left >= right) {
            return arr[left];
        }

        int posPivot = ThreadLocalRandom.current().nextInt(left, right + 1);
        Integer pivot = arr[posPivot];
        int[] pointers = partition(arr, pivot, left, right);

        if (n <= pointers[0]) {
            return recursiveQuickSelect(arr, left, pointers[0], n);
        } else if (n >= pointers[1]) {
            return recursiveQuickSelect(arr, pointers[1], right, n);
        } else {
            return pivot;
        }
    }

    private static int[] partition(Integer[] arr, Integer pivot, int left, int right) {
        int low = left;
        int cur = left;
        int high = right;

        while (cur <= high) {
            int comparison = arr[cur].compareTo(pivot);

            if (comparison < 0) {
                // Move element to left partition (less than pivot)
                swap(arr, cur, low);
                low++;
                cur++;
            } else if (comparison == 0) {
                // Element equals pivot, just move current pointer
                cur++;
            } else {
                // Move element to right partition (greater than pivot)
                swap(arr, cur, high);
                high--;
            }
        }

        return new int[]{low - 1, high + 1};
    }

    private static void swap(Integer[] arr, int i, int j) {
        Integer temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
