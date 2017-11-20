package by.itacademy.HomeWork3.Task1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*

 */
public class SolutionTask1 {
    public static void main(String[] args) {
        int[] array = new int[10];
        arrayInput(array);
        printArray(array);
        printArray(bubleSort(array));
        printArray(shakerSort(array));
        printArray(selectionSort(array));
        printArray(evenNumbers(array));
    }

    /**
     * This method initiates incoming array by integer values inputting from console
     * @param array  incoming array
     */
    public static int[] arrayInput(int[] array){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        return array;
    }

    /**
     * This method prints incoming array in specify format
     * @param array  incoming array
     */
    public static void  printArray(int[] array ){
        for (int i = 0; i < array.length; i++){
            if (i == 0) System.out.print("\"" + array[i] + "\"");
            else {
                System.out.print("|\"" + array[i] + "\"");
            }

        }
        System.out.println();
    }

    /**
     * This method sorts array by using "Bubble sort" algorithm
     * @param array incoming array
     * @return sorted array
     */
    public static int[] bubleSort(int[] array){
        for(int i = array.length-1; i >= 0; i--){
            for (int j = 0; j < i; j++)
                if(array[j] > array[j+1]){
                int temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
                }
        }
    return array;
    }

    /**
     * This method sorts array by using "Shaker sort" sorting algorithm
     * @param array incoming array
     * @return sorted array
     */
    public static int[] shakerSort(int[] array) {
        int buff;
        int left=0;
        int right=array.length-1;
        do {
            for (int i=left; i<right;i++) {
                if (array[i]>array[i+1]) {
                    buff = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buff;
                    }
                }
            right--;
            for (int i=right; i>left; i--) {
                if (array[i]<array[i-1]) {
                    buff = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = buff;
                    }
                }
            left++;
        } while (left <right);
        return array;
    }

    /**
     * This method sorts array by using "Selection sort" algorithm
     * @param array incoming array
     * @return sorted array
     */
    public static  int[] selectionSort (int[] array) {
        for (int min = 0; min < array.length-1; min++) {
            int least = min;
            for (int j = min+1; j < array.length; j++) {
                if(array[j] < array[least]) {
                    least = j;
                    }
                }
            int tmp = array[min];
            array[min] = array[least];
            array[least] = tmp;
            }
            return  array;
        }

    public static int[] evenNumbers (int[] array){
        int even = array.length;

        int[] evenArray = new int[even];
        // This loop lokig for even numbers and adding
        for(int i = 0; i < array.length; i++){
            if (array[i]%2 == 0) evenArray[i] = array[i];
            else evenArray[i] = -1;
        }
        evenArray = removeElement(evenArray, -1);
        return  evenArray;
        }

    public static int[] removeElement(int[] array, int elementToDelete)
    {
       List<Integer> list = new ArrayList<>();
       int outputArraySize = 0;
       for (int i = 0; i < array.length; i++){
           if(array[i] != elementToDelete) {
               list.add(array[i]);
               outputArraySize++;
           }
       }
       int[] outputArray = new int[outputArraySize];
       for(int k = 0; k < list.size(); k++){
           outputArray[k]= list.get(k);
       }
        return outputArray;
    }


}
