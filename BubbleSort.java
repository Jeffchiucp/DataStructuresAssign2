public class BubbleSort extends RunTime implements SortInterface {

   @Override
   public void sort(Integer[] arrayToSort) {
       
      
       for (int i = 0; i < arrayToSort.length; i++) {
           for (int j = 0; j < arrayToSort.length - 1; j++) {
               if (arrayToSort[j] > arrayToSort[j + 1]) {
                   int temp = arrayToSort[j];
                   arrayToSort[j] = arrayToSort[j + 1];
                   arrayToSort[j + 1] = temp;
               }
           }
       }
   }
}