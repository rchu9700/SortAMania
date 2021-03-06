/**
 * This version:
 * @author Ricky Chu and Kiran Khambhla
 * @version February 2019
 */
public class Team0SortCompetition extends SortCompetition {

    @Override
    public int challengeOne(int[] arr) {
        mergeSort(arr);
        return median(arr);
    }

    @Override
    public int challengeTwo(String[] arr, String query) {
        selectionSort(arr);
        return binarySearch(arr, query);
    }

    @Override
    public int challengeThree(int[] arr) {
        insertionSort(arr);
        return median(arr);
    }

    @Override
    public int challengeFour(int[][] arr) {
        int[] medianArr = new int[arr.length];
        for (int row = 0; row < arr.length; row++) {
            mergeSort(arr[row]);
            medianArr[row] = median(arr[row]);
        }
        mergeSort(medianArr);
        mergeSort(arr);
        int median = median(medianArr);
        return median;
    }

    @Override
    public int challengeFive(Comparable[] arr, Comparable query) {
        mergeSort(arr);
        return binarySearch(arr, query);
    }

    @Override
    public String greeting() {
        return "We are team zero Ricky and Kiran! Our speed is unmatched!";
    }

    //Challenge One Code
    public static void mergeSort(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        mergeSortHelper(arr, 0, n - 1, temp);
    }

    public static void mergeSortHelper(int[] arr, int from, int to, int[] temp) {
        if (from < to) {
            int mid = (from + to) / 2;
            mergeSortHelper(arr, from, mid, temp);
            mergeSortHelper(arr, mid + 1, to, temp);
            merge(arr, from, mid, to, temp);
        }
    }

    public static void merge(int[] arr, int from, int mid, int to, int[] temp) {
        int i = from;
        int j = mid + 1;
        int k = from;
        while (i <= mid && j <= to) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }
        while (j <= to) {
            temp[k] = arr[j];
            j++;
            k++;
        }
        for (k = from; k <= to; k++) {
            arr[k] = temp[k];
        }
    }

    //Challenge Two Code
    public static void selectionSort(String[] a) {
        int num = a.length;
        for (int i = 0; i < num - 1; i++) {
            int min = i;
            for (int j = i + 1; j < num; j++)
                if (a[j].compareTo(a[min]) < 0) {
                    min = j;
                }
            String temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
    }

    public static int binarySearch(String[] elements, String target) {
        int left = 0;
        int right = elements.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (target.compareTo(elements[middle]) < 0) {
                right = middle - 1;
            } else if (target.compareTo(elements[middle]) > 0) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    //Challenge Three Code
    public static void insertionSort(int[] a) {
        int num = a.length;
        for (int i = 1; i < num; ++i) {
            int max = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > max) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = max;
        }
    }

    //Challenge Four Code
    public static void mergeSort(int[][] arr) {
        int n = arr.length;
        int[][] temp = new int[n][arr[0].length];
        mergeSortHelper(arr, 0, n - 1, temp);
    }

    public static void mergeSortHelper(int[][] arr, int from, int to, int[][] temp) {
        if (from < to) {
            int mid = (from + to) / 2;
            mergeSortHelper(arr, from, mid, temp);
            mergeSortHelper(arr, mid + 1, to, temp);
            merge(arr, from, mid, to, temp);
        }
    }

    public static void merge(int[][] arr, int from, int mid, int to, int[][] temp) {
        int i = from;
        int j = mid + 1;
        int k = from;
        while (i <= mid && j <= to) {
            if (median(arr[i]) < median(arr[j])) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }
        while (j <= to) {
            temp[k] = arr[j];
            j++;
            k++;
        }
        for (k = from; k <= to; k++) {
            arr[k] = temp[k];
        }
    }

    //Challenge Five Code
    public static void mergeSort(Comparable[] arr) {
        int n = arr.length;
        Comparable[] temp = new Comparable[n];
        mergeSortHelper(arr, 0, n - 1, temp);
    }

    public static void mergeSortHelper(Comparable[] arr, int from, int to, Comparable[] temp) {
        if (from < to) {
            int mid = (from + to) / 2;
            mergeSortHelper(arr, from, mid, temp);
            mergeSortHelper(arr, mid + 1, to, temp);
            merge(arr, from, mid, to, temp);
        }
    }

    public static void merge(Comparable[] arr, int from, int mid, int to, Comparable[] temp) {
        int i = from;
        int j = mid + 1;
        int k = from;
        while (i <= mid && j <= to) {
            if (arr[i].compareTo(arr[j]) < 0) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }
        while (j <= to) {
            temp[k] = arr[j];
            j++;
            k++;
        }
        for (k = from; k <= to; k++) {
            arr[k] = temp[k];
        }
    }

    public static int binarySearch(Comparable[] elements, Comparable target) {
        int left = 0;
        int right = elements.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (target.compareTo(elements[middle]) < 0) {
                right = middle - 1;
            } else if (target.compareTo(elements[middle]) > 0) {
                left = middle + 1;
            } else if (target.equals(elements[middle])) {
                return middle;
            }
        }
        return -1;
    }

    //Helper Methods
    public static int median(int[] arr) {
        if (arr.length % 2 == 0) {
            return (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2;
        }
        else {
            return arr[arr.length / 2];
        }
    }

}