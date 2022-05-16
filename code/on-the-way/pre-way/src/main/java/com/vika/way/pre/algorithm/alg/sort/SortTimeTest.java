package com.vika.way.pre.algorithm.alg.sort;



import com.vika.way.pre.algorithm.alg.common.RandomArray;

import java.util.Arrays;

public class SortTimeTest {

    QuickSort quickSort = new QuickSort();
    MergeSort mergeSort = new MergeSort();
    HeapSort heapSort = new HeapSort();
    SelectSort selectSort = new SelectSort();
    InsertSort insertSort = new InsertSort();
    BubbleSort bubbleSort = new BubbleSort();
    ShellSort shellSort = new ShellSort();
    CountingSort countingSort = new CountingSort();
    BucketSort bucketSort = new BucketSort();
    RadixSort radixSort = new RadixSort();

    int x;

    public void testQuickSort(int[] nums) {
        long startTime = System.currentTimeMillis();
        quickSort.quickSort(nums, 0, nums.length - 1);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("quickSort:" + duration);
    }

    public void testQuickPassSort(int[] nums) {
        long startTime = System.currentTimeMillis();
        quickSort.quickPassSort(nums, 0, nums.length - 1);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("quickPassSort:" + duration);
    }

    public void testQuickSortRandom(int[] nums) {
        long startTime = System.currentTimeMillis();
        quickSort.quickSortRandom(nums, 0, nums.length - 1);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("quickSortRandom:" + duration);
    }

    public void testQuickSortMidOfThree(int[] nums) {
        long startTime = System.currentTimeMillis();
        quickSort.quickSortMidOfThree(nums, 0, nums.length - 1);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("quickSortMidOfThree:" + duration);
    }

    public void testQuickSortThreeWay(int[] nums) {
        long startTime = System.currentTimeMillis();
        quickSort.quickSortThreeWay(nums, 0, nums.length - 1);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("quickSortThreeWay:" + duration);
    }

    public void testQuickSortInsert(int[] nums) {
        long startTime = System.currentTimeMillis();
        quickSort.quickSortInsert(nums, 0, nums.length - 1);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("quickSortInsert:" + duration);
    }

    public void testQuickSortNonRecur0(int[] nums) {
        long startTime = System.currentTimeMillis();
        quickSort.quickSortNonRecur0(nums, 0, nums.length - 1);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("quickSortNonRecur0:" + duration);
    }


    public void testQuickSortNonRecur(int[] nums) {
        long startTime = System.currentTimeMillis();
        quickSort.quickSortNonRecur(nums, 0, nums.length - 1);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("quickSortNonRecur:" + duration);
    }

    public void testMergeSort(int[] nums) {
        long startTime = System.currentTimeMillis();
        mergeSort.mergeSort(nums, 0, nums.length - 1);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("mergeSort:" + duration);
    }

    public void testMergeSort1(int[] nums) {
        long startTime = System.currentTimeMillis();
        mergeSort.mergeSort1(nums, 0, nums.length - 1);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("mergeSort1:" + duration);
    }

    public void testMergeSortNonRecur(int[] nums) {
        long startTime = System.currentTimeMillis();
        mergeSort.mergeSortNonRecur(nums);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("mergeSortNonRecur:" + duration);
    }

    public void testMergeSortNonRecur1(int[] nums) {
        long startTime = System.currentTimeMillis();
        mergeSort.mergeSortNonRecur1(nums);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("mergeSortNonRecur1:" + duration);
    }

    public void testMergeSortNonRecur2(int[] nums) {
        long startTime = System.currentTimeMillis();
        mergeSort.mergeSortNonRecur2(nums);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("mergeSortNonRecur2:" + duration);
    }

    public void testSelectSort(int[] nums) {
        long startTime = System.currentTimeMillis();
        selectSort.selectSort(nums);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("selectSort:" + duration);
    }

    public void testSelectSort1(int[] nums) {
        long startTime = System.currentTimeMillis();
        selectSort.selectSort1(nums);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("selectSort1:" + duration);
    }

    public void testBubbleSort(int[] nums) {
        long startTime = System.currentTimeMillis();
        bubbleSort.bubbleSort(nums);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("bubbleSort:" + duration);
    }

    public void testBubbleSortFlag(int[] nums) {
        long startTime = System.currentTimeMillis();
        bubbleSort.bubbleSortFlag(nums);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("bubbleSortFlag:" + duration);
    }

    public void testBubbleTwoSort(int[] nums) {
        long startTime = System.currentTimeMillis();
        bubbleSort.bubbleTwoSort(nums);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("bubbleTwoSort:" + duration);
    }

    public void testShellSort(int[] nums) {
        long startTime = System.currentTimeMillis();
        shellSort.shellSort(nums);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("shellSort:" + duration);
    }

    public void testInsertSort(int[] nums) {
        long startTime = System.currentTimeMillis();
        insertSort.insertSort(nums);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("insertSort:" + duration);
    }

    public void testInsertSortBinary(int[] nums) {
        long startTime = System.currentTimeMillis();
        insertSort.insertSortBinary(nums);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("insertSortBinary:" + duration);
    }

    public void testHeapSortMin(int[] nums) {
        long startTime = System.currentTimeMillis();
        heapSort.heapSortMin(nums);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("heapSortMin:" + duration);
    }

    public void testHeapSortMax(int[] nums) {
        long startTime = System.currentTimeMillis();
        heapSort.heapSortMax(nums);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("heapSortMax:" + duration);
    }

    public void testHeapSortMax1(int[] nums) {
        long startTime = System.currentTimeMillis();
        heapSort.heapSortMax1(nums);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("heapSortMax1:" + duration);
    }

    public void testCountingSort(int[] nums) {
        long startTime = System.currentTimeMillis();
        countingSort.countingSort(nums);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("countingSort:" + duration);
    }

    public void testCountingSortOne(int[] nums) {
        long startTime = System.currentTimeMillis();
        countingSort.countingSortOne(nums);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("countingSortOne:" + duration);
    }

    public void testRadixSort(int[] nums) {
        long startTime = System.currentTimeMillis();
        radixSort.radixSort(nums);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("radixSort:" + duration);
    }

    public void testArraySort(int[] nums) {
        long startTime = System.currentTimeMillis();
        Arrays.sort(nums);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Arrays#sort:" + duration);
    }

    public static void main(String[] args) {


        final int n = 1000 * 1000;
        int[] nums = RandomArray.randomArray(n / 10, n);
        int[] sorted = nums.clone();
        SortTimeTest sortTimeTest = new SortTimeTest();
        sortTimeTest.testArraySort(sorted);
        int m = 25;
        int[][] sorteds = new int[m][];
        for (int i = 0; i < m; i++) {
            sorteds[i] = nums.clone();
        }
        int k = 0;
        sortTimeTest.testQuickSort(sorteds[++k]);
        System.out.println(Arrays.equals(sorted, sorteds[k]));

        sortTimeTest.testQuickPassSort(sorteds[++k]);
        System.out.println(Arrays.equals(sorted, sorteds[k]));

        sortTimeTest.testQuickSortRandom(sorteds[++k]);
        System.out.println(Arrays.equals(sorted, sorteds[k]));

        sortTimeTest.testQuickSortMidOfThree(sorteds[++k]);
        System.out.println(Arrays.equals(sorted, sorteds[k]));

        sortTimeTest.testQuickSortInsert(sorteds[++k]);
        System.out.println(Arrays.equals(sorted, sorteds[k]));

        sortTimeTest.testQuickSortThreeWay(sorteds[++k]);
        System.out.println(Arrays.equals(sorted, sorteds[k]));

        sortTimeTest.testQuickSortNonRecur0(sorteds[++k]);
        System.out.println(Arrays.equals(sorted, sorteds[k]));

        sortTimeTest.testQuickSortNonRecur(sorteds[++k]);
        System.out.println(Arrays.equals(sorted, sorteds[k]));

        sortTimeTest.testMergeSort(sorteds[++k]);
        System.out.println(Arrays.equals(sorted, sorteds[k]));

        sortTimeTest.testMergeSort1(sorteds[++k]);
        System.out.println(Arrays.equals(sorted, sorteds[k]));

        sortTimeTest.testMergeSortNonRecur(sorteds[++k]);
        System.out.println(Arrays.equals(sorted, sorteds[k]));

        sortTimeTest.testMergeSortNonRecur1(sorteds[++k]);
        System.out.println(Arrays.equals(sorted, sorteds[k]));

        sortTimeTest.testMergeSortNonRecur2(sorteds[++k]);
        System.out.println(Arrays.equals(sorted, sorteds[k]));

        //sortTimeTest.testBubbleSort(sorteds[++k]);
        //System.out.println(Arrays.equals(sorted, sorteds[k]));

        //sortTimeTest.testBubbleSortFlag(sorteds[++k]);
        //System.out.println(Arrays.equals(sorted, sorteds[k]));

        //sortTimeTest.testBubbleTwoSort(sorteds[++k]);
        //System.out.println(Arrays.equals(sorted, sorteds[k]));

        //sortTimeTest.testSelectSort(sorteds[++k]);
        //System.out.println(Arrays.equals(sorted, sorteds[k]));

        //sortTimeTest.testSelectSort1(sorteds[++k]);
        //System.out.println(Arrays.equals(sorted, sorteds[k]));

        //sortTimeTest.testInsertSort(sorteds[++k]);
        //System.out.println(Arrays.equals(sorted, sorteds[k]));

        //sortTimeTest.testInsertSortBinary(sorteds[++k]);
        //System.out.println(Arrays.equals(sorted, sorteds[k]));

        sortTimeTest.testShellSort(sorteds[++k]);
        System.out.println(Arrays.equals(sorted, sorteds[k]));

        sortTimeTest.testCountingSort(sorteds[++k]);
        System.out.println(Arrays.equals(sorted, sorteds[k]));

        sortTimeTest.testCountingSortOne(sorteds[++k]);
        System.out.println(Arrays.equals(sorted, sorteds[k]));

        sortTimeTest.testRadixSort(sorteds[++k]);
        System.out.println(Arrays.equals(sorted, sorteds[k]));

        sortTimeTest.testHeapSortMax(sorteds[++k]);
        System.out.println(Arrays.equals(sorted, sorteds[k]));

        sortTimeTest.testHeapSortMax1(sorteds[++k]);
        System.out.println(Arrays.equals(sorted, sorteds[k]));

        sortTimeTest.testHeapSortMin(sorteds[++k]);
        System.out.println(Arrays.equals(sorted, sorteds[k]));

    }
}
