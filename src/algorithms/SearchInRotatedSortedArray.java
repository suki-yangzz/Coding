package algorithms;

public class SearchInRotatedSortedArray {

    static int findRec(int A[], int target, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) / 2;

        if (A[mid] == target)
            return mid;
        else if (A[start] < A[mid]) { //start ~ mid, sorted
            return A[start] <= target && target <= A[mid] ? findRec(A, target, start, mid) : findRec(A, target, mid + 1, end);
        } else {
            return A[mid] <= target && target <= A[end] ? findRec(A, target, mid + 1, end) : findRec(A, target, start, mid - 1);
        }
    }

    static int find(int A[], int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;
        int mid;

        while (start + 1 < end) {
            mid = (start + end) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[start] < A[mid]) {
                // situation 1, numbers between start and mid are sorted
                if (A[start] <= target && target <= A[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                // situation 2, numbers between mid and end are sorted
                if (A[mid] <= target && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        } // while

        if (A[start] == target) {
            return start;
        }
        if (A[end] == target) {
            return end;
        }
        return -1;
    }

    static int findMinRec(int A[], int start, int end) {
        if (start + 1 == end) return A[start] < A[end] ? start : end;
        int mid = (start + end) / 2;

        if (A[start] < A[mid]) {
            return findMinRec(A, mid, end);
        } else if (A[mid] < A[end]) {
            return findMinRec(A, start, mid);
        } else {
            return findMinRec(A, start, end - 1);
        }
    }

    static int findMin(int A[]) {
        int start = 0;
        int end = A.length - 1;
        int mid;

        while (start + 1 < end) {
            mid = (start + end) / 2;
            if (A[start] < A[mid])
                start = mid;
            else if (A[mid] < A[end])
                end = mid;
            else
                --end;
        }
        if (A[start] < A[end])
            return start;
        else
            return end;
    }

    public static void main (String[] args) {
        int arr[] = {4, 5, 6, 0, 1, 2, 3};
        System.out.println("Index is " + findRec(arr, 0, 0, arr.length - 1));
        System.out.println("Index is " + find(arr, 0));
        System.out.println("Index is " + findMinRec(arr, 0, arr.length - 1));
        System.out.println("Index is " + findMin(arr));
    }
}
