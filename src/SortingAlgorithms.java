public class SortingAlgorithms {


    // SELECTION SORT
    public static void selectionSort(int[] arr) {
        for(int lastUnsortedIndex = arr.length - 1; lastUnsortedIndex >0; lastUnsortedIndex--) {
            int max = 0;
            for(int i = 1; i <= lastUnsortedIndex; i++) {
                if(arr[max] < arr[i]) {
                    max = i;
                }
                swapElements(arr, max, lastUnsortedIndex);
            }
        }

    }

    private static void swapElements(int[] arr, int i, int j) {
        if(i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // INSERTION SORT
    public static void insertionSort(int[] arr) {
        for(int firstUnsortedIndex = 1; firstUnsortedIndex < arr.length; firstUnsortedIndex++) {
            int newElement = arr[firstUnsortedIndex];

            int i;
            for(i = firstUnsortedIndex; i > 0 && arr[i - 1] > newElement; i--) {
                arr[i] = arr[i - 1];
            }
            arr[i] = newElement;
        }
    }

    // INSERTION SORT Recursive
    public static void insertionSortRecursive(int[] arr) {
        //to implement
    }

    //SHELL SORT
    public static void shellSort(int[] arr) {
        for(int gap = arr.length / 2; gap > 0; gap /= 2) {

            for(int i = gap; i < arr.length; i++) {
                int newElement = arr[i];
                int j;

                for(j = i; j >= gap && arr[j - gap] > newElement; j -= gap) {
                    arr[j] = arr[j-gap];
                }
                arr[j] = newElement;
            }
        }
    }

    // MERGE SORT
    public static void mergeSort(int[] input, int start, int end) {

        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }

    private static void merge(int[] input, int start, int mid, int end) {

        if (input[mid - 1] <= input[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);


    }

    public static void mergeSortDesc(int[] input, int start, int end) {

        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSortDesc(input, start, mid);
        mergeSortDesc(input, mid, end);
        mergeDesc(input, start, mid, end);
    }

    private static void mergeDesc(int[] input, int start, int mid, int end) {

        if (input[mid - 1] >= input[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] >= input[j] ? input[i++] : input[j++];
        }

        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);


    }

    // QUICK SORT
    public static void quickSort(int[] input, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int pivotIndex = partition(input, start, end);
        quickSort(input, start, pivotIndex);
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
        quickSort(input, pivotIndex + 1, end);
    }

    private static int partition(int[] input, int start, int end) {
        // This is using the first element as the pivot
        int pivot = input[start];
        int i = start;
        int j = end;

        while (i < j) {

            // NOTE: empty loop body
            while (i < j && input[--j] >= pivot);
            if (i < j) {
                input[i] = input[j];
            }

            // NOTE: empty loop body
            while (i < j && input[++i] <= pivot);
            if (i < j) {
                input[j] = input[i];
            }

        }

        input[j] = pivot;
        return j;

    }

    // COUNTING SORT
    public static void countingSort(int[] input, int min, int max) {

        int[] countArray = new int[(max - min) + 1];

        for (int i = 0; i < input.length; i++) {
            countArray[input[i] - min]++;
        }

        int j = 0;
        for (int i = min; i <= max; i++) {
            while (countArray[i - min] > 0) {
                input[j++] = i;
                countArray[i - min]--;
            }
        }

    }

    // RADIX SORT
    public static void radixSort(int[] input, int radix, int width) {
        for (int i = 0; i < width; i++) {
            radixSingleSort(input, i, radix);
        }
    }

    private static void radixSingleSort(int[] input, int position, int radix) {

        int numItems = input.length;
        int[] countArray = new int[radix];

        for (int value: input) {
            countArray[getDigit(position, value, radix)]++;
        }
        // Adjust the count array
        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        int[] temp = new int[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(position, input[tempIndex], radix)]] =
                    input[tempIndex];
        }

        for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }

    }

    private static int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(radix, position) % radix;
    }



    public static long factorialForLoop(int num) {
        if(num < 0) {
            throw new NumberFormatException("You cannot count factorial from a negative" +
                    "number");
        }
        if(num == 0) {
            return 1L;
        }
        long factorial = 1;
        for(int i = 1; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static long factorialRecursion(int num) {
        if(num < 0) {
            throw new NumberFormatException("You cannot count factorial from a negative" +
                    "number");
        }
        if(num == 0) {
            return 1L;
        }
        return num * factorialRecursion(num -1);
    }

}
