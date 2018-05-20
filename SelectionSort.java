public class SelectionSort extends RunTime implements SortInterface {

   @Override
   public void sort(Integer[] arrayToSort) {

       for (int i = 0; i < arrayToSort.length - 1; i++) {
           int minIndex = i;
          
           // Find index where the element is less than the element at minIndex
           for (int j = i + 1; j < arrayToSort.length; j++) {
               if (arrayToSort[minIndex] > arrayToSort[j]) {
                   minIndex = j;
               }
           }
          
           if (minIndex != i) {
               int temp = arrayToSort[i];
               arrayToSort[i] = arrayToSort[minIndex];
               arrayToSort[minIndex] = temp;
           }
       }
   }
}