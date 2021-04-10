import java.util.Arrays;
import java.util.Random;

import javax.lang.model.util.ElementScanner6;


public class BinarySearch {
    
    public static void main(String[] args) {

    // int[] arr = {1,3,5,7};
    // System.out.println(binarySearchRec(7, arr));
    // System.out.println(binarySearchIter(7, arr));

        Random PRG = new Random(1);
        int[] sortedList = PRG.ints(100, 0, 100).toArray();
        Arrays.sort(sortedList);

        int[] testValues = PRG.ints(5, 0, 100).toArray();

        System.out.println("Testing recursive binary search ...");
        for (int value: testValues) {
            int answer = binarySearchRec(value, sortedList);

            if (answer == -1) {
                System.out.printf("List does not contain value %d\n", value);
            } else {
                System.out.printf("List contain value %d at index %d\n", value, answer);
            }
        }

        System.out.println("Testing iterative binary search ...");
        for (int value: testValues) {
            int answer = binarySearchIter(value, sortedList);

            if (answer == -1) {
                System.out.printf("List does not contain value %d\n", value);
            } else {
                System.out.printf("List contain value %d at index %d\n", value, answer);
            }
        }
     }

    /**
     * this function uses binary search to determine whether an ordered array
     * contains a specified value.
     * If you need, you can use a helper function.
     * @param x the value needed to be searched
     * @param sortedList target array
     * @return index of the value if availbe, -1 otherwise 
     */

    public static int binarySearchRec(int x, int[] sortedList)
    {
           int low = 0;
           int high = sortedList.length;
           return HelperBinarySearchRec(x, sortedList, low, high);
    }
    public static int HelperBinarySearchRec(int x, int[] sortedList, int low, int high) {
        if(low>high)
        {return -1;}
        else
        {
           int mid = (low+high)/2;
           if(x==sortedList[mid])
           {return mid;}
           else if(x<sortedList[mid])
           {return HelperBinarySearchRec(x, sortedList, low, mid-1);}
           else
           {return HelperBinarySearchRec(x, sortedList, mid+1, high);}
        }
    }

    public static int binarySearchRec2(int x, int[] sortedList) {
        if (sortedList[0] > x) {
            return -1;
        }

        if (sortedList[sortedList.length - 1] < x) {
            return -1;
        }

        if (sortedList[sortedList.length - 1] == x) {
            return sortedList.length - 1;
        }

        if (sortedList[0] == x) {
            return 0;
        }
        return helperBinarySearchRec2(x, sortedList, 0, sortedList.length-1);
    }

    public static int helperBinarySearchRec2(int x, int[] sortedList, int lower, int upper) {
        if (upper - lower <= 1) return -1;

        int temp = (upper + lower) >>> 1;

        if (sortedList[temp] > x) {
            return helperBinarySearchRec2(x, sortedList, lower, temp);
        } else if (sortedList[temp] < x) {
            return helperBinarySearchRec2(x, sortedList, temp, upper);
        } else {
            return temp;
        }
    }
    /**
     * this function uses binary search to determine whether an ordered array
     * contains a specified value.
     * 
     * @param x the value needed to be searched
     * @param sortedList target array
     * @return index of the value if availbe, -1 otherwise 
     */
    public static int binarySearchIter(int x, int[] sortedList) {
        // TODO
        int low=0;
        int high=sortedList.length-1;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(x==sortedList[mid])
            {return mid;}
            else if(x<sortedList[mid])
            {high = mid-1;}
            else if(x>sortedList[mid]) 
            {low = mid+1;}
        }
        return -1;
    }
}
