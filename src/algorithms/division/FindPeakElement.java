package algorithms.division;

public class FindPeakElement {
    static int findPeakRec(int arr[], int start, int end, int length) {
        int mid = (start + end) / 2;
        if ((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == length - 1 || arr[mid] > arr[mid + 1]))
            return arr[mid];
        else if (arr[mid] < arr[mid - 1]) {
            return findPeakRec(arr, start, mid, length);
        } else {
            return findPeakRec(arr, mid + 1, end, length);
        }
    }

    static int findPeak(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end) / 2;

        while (start + 1 < end) {
            mid = (start + end) / 2;
            if ((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == arr.length - 1 || arr[mid] > arr[mid + 1]))
                return arr[mid];
            else if (arr[mid] < arr[mid - 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return arr[(start + end) / 2];
    }

    public static void main (String[] args) {
        int arr[] = {1, 2, 4, 7, 1, 0};
        int n = arr.length;
        System.out.println("Index of a peak point is " + findPeakRec(arr, 0, n - 1, n));
        System.out.println("Index of a peak point is " + findPeak(arr));
    }
}
