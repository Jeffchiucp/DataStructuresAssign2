public class InsertionSort extends RunTime implements SortInterface {

   @Override
   public void sort(Integer[] arrayToSort) {
      
       for (int i = 1; i < arrayToSort.length; i++) {
           int key = arrayToSort[i];
           int j;
           // Shift one position down until key is greater than arrayToSort[j]
           for (j = (i - 1); ((j >= 0) && (key < arrayToSort[j])); j--) {
               arrayToSort[j + 1] = arrayToSort[j];
           }
           arrayToSort[j + 1] = key;
       }
   }
}
