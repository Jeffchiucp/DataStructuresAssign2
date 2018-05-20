import java.util.Arrays;
import java.util.Random;

public class Driver implements DriverInterface {

   
   //Generate and return an array of Integer values all initialized to 1
   
   public Integer[] getEqualNumbers(int arraySize) {
       Integer[] arr = new Integer[arraySize];
       Arrays.fill(arr, 1);

       return arr;
   }

   
   //Generate and return an array of Integer with random values
   
   public Integer[] getRandomNumbers(int arraySize) {
       Integer[] arr = new Integer[arraySize];

       Random r = new Random();
       for (int i = 0; i < arraySize; i++) {
           arr[i] = r.nextInt();
       }

       
       
       return arr;
   }

   
   //Generate and return an array of Integer values starting at 1 and ending at arraySize
   
   
   public Integer[] getIncreasingNumbers(int arraySize) {
       Integer[] arr = new Integer[arraySize];

       for (int i = 0; i < arraySize; i++) {
           arr[i] = i + 1;
       }
       return arr;
   }

   
   // Generate and return an array of Integer values starting at arraySize and ending at 1
   
   public Integer[] getDecreasingNumbers(int arraySize) {
       Integer[] arr = new Integer[arraySize];

       for (int i = 0; i < arraySize; i++) {
           arr[i] = arraySize - i;
       }
       return arr;
   }
   
   public Integer[] getIncreasing_Random_Numbers(int arraySize) {
       Integer[] arr = new Integer[arraySize];

       Random r = new Random();
       
       for (int i = 0; i < arraySize; i++) {
           arr[i] = r.nextInt();
       }
       
       Arrays.sort(arr);
       return arr;
   }

   
   //Creates a new array of Integer objects
  
   @Override
   public Integer[] createArray(ArrayType arrayType, int arraySize) {

       if (arrayType == DriverInterface.ArrayType.Equal) {
           return getEqualNumbers(arraySize);

       } else if (arrayType == DriverInterface.ArrayType.Random) {
           return getRandomNumbers(arraySize);

       } else if (arrayType == DriverInterface.ArrayType.Increasing) {
           return getIncreasingNumbers(arraySize);

       } else if (arrayType == DriverInterface.ArrayType.Decreasing){
           return getDecreasingNumbers(arraySize);
       }
       return getIncreasing_Random_Numbers(arraySize);
   }

  
   // This method will run the specified sort a specified number of times
   
   @Override
   public RunTime runSort(SortType sortType, ArrayType arrayType, int arraySize, int numberOfTimes) {

       if (sortType == DriverInterface.SortType.BubbleSort) {
           BubbleSort bubbleSort = new BubbleSort();
           // Start sort
           for (int i = 0; i < numberOfTimes; i++) {
               long startTime = System.nanoTime(); // Get start time
               // Create array
               Integer[] arrayToSort = createArray(arrayType, arraySize);

               bubbleSort.sort(arrayToSort);
               long endTime = System.nanoTime(); // Get end time

               // Add sort
               bubbleSort.addRuntime(endTime - startTime);
           }
           // Display runtime
           displayRunTime(bubbleSort, sortType, arrayType, arraySize);
           return bubbleSort;

       } else if (sortType == DriverInterface.SortType.InsertionSort) {
           InsertionSort insertionSort = new InsertionSort();
           // Start sort
           for (int i = 0; i < numberOfTimes; i++) {
               long startTime = System.nanoTime(); // Get start time
               // Create array
               Integer[] arrayToSort = createArray(arrayType, arraySize);

               insertionSort.sort(arrayToSort);
               long endTime = System.nanoTime(); // Get end time

               // Add sort
               insertionSort.addRuntime(endTime - startTime);
           }
           // Display runtime
           displayRunTime(insertionSort, sortType, arrayType, arraySize);
           return insertionSort;

       } else { 
           SelectionSort selectionSort = new SelectionSort();
           // Start sort
           for (int i = 0; i < numberOfTimes; i++) {
               long startTime = System.nanoTime(); // Get start time
               // Create array
               Integer[] arrayToSort = createArray(arrayType, arraySize);

               selectionSort.sort(arrayToSort);
               long endTime = System.nanoTime(); // Get end time

               // Add sort
               selectionSort.addRuntime(endTime - startTime);
           }
           // Display runtime
           displayRunTime(selectionSort, sortType, arrayType, arraySize);
           return selectionSort;
       }
   }

   
   public void displayRunTime(RunTime r, SortType sortType, ArrayType arrayType, int arraySize) {

       System.out.println("\n" + sortType + ", " + arrayType + ", " + arraySize);
       System.out.printf(String.format("%100s\n", " ").replaceAll(" ", "-"));

       // Display runtime
       for (long runtime : r.getRunTimes()) {
           System.out.print(runtime + " ");
       }

       // Display average runtime
       System.out.print("--- " + r.getAverageRunTime() + "\n");
   }

   public static void main(String[] args) {

       // Create a Driver object
       Driver driver = new Driver();

       // 1000 equal Integers
       driver.runSort(DriverInterface.SortType.BubbleSort, DriverInterface.ArrayType.Equal, 1000, 10);
       driver.runSort(DriverInterface.SortType.InsertionSort, DriverInterface.ArrayType.Equal, 1000, 10);
       driver.runSort(DriverInterface.SortType.SelectionSort, DriverInterface.ArrayType.Equal, 1000, 10);

       // 1000 random Integers
       driver.runSort(DriverInterface.SortType.BubbleSort, DriverInterface.ArrayType.Random, 1000, 10);
       driver.runSort(DriverInterface.SortType.InsertionSort, DriverInterface.ArrayType.Random, 1000, 10);
       driver.runSort(DriverInterface.SortType.SelectionSort, DriverInterface.ArrayType.Random, 1000, 10);

       // 1000 increasing Integers
       driver.runSort(DriverInterface.SortType.BubbleSort, DriverInterface.ArrayType.Increasing, 1000, 10);
       driver.runSort(DriverInterface.SortType.InsertionSort, DriverInterface.ArrayType.Increasing, 1000, 10);
       driver.runSort(DriverInterface.SortType.SelectionSort, DriverInterface.ArrayType.Increasing, 1000, 10);

       // 1000 decreasing Integers
       driver.runSort(DriverInterface.SortType.BubbleSort, DriverInterface.ArrayType.Decreasing, 1000, 10);
       driver.runSort(DriverInterface.SortType.InsertionSort, DriverInterface.ArrayType.Decreasing, 1000, 10);
       driver.runSort(DriverInterface.SortType.SelectionSort, DriverInterface.ArrayType.Decreasing, 1000, 10);
       
       // 1000 Increasing and Random Integers
       driver.runSort(DriverInterface.SortType.BubbleSort, DriverInterface.ArrayType.IncreasingAndRandom, 1000, 10);
       driver.runSort(DriverInterface.SortType.InsertionSort, DriverInterface.ArrayType.IncreasingAndRandom, 1000, 10);
       driver.runSort(DriverInterface.SortType.SelectionSort, DriverInterface.ArrayType.IncreasingAndRandom, 1000, 10);


       // 10000 equal Integers
       driver.runSort(DriverInterface.SortType.BubbleSort, DriverInterface.ArrayType.Equal, 10000, 10);
       driver.runSort(DriverInterface.SortType.InsertionSort, DriverInterface.ArrayType.Equal, 10000, 10);
       driver.runSort(DriverInterface.SortType.SelectionSort, DriverInterface.ArrayType.Equal, 10000, 10);

       // 10000 random Integers
       driver.runSort(DriverInterface.SortType.BubbleSort, DriverInterface.ArrayType.Random, 10000, 10);
       driver.runSort(DriverInterface.SortType.InsertionSort, DriverInterface.ArrayType.Random, 10000, 10);
       driver.runSort(DriverInterface.SortType.SelectionSort, DriverInterface.ArrayType.Random, 10000, 10);

       // 10000 increasing Integers
       driver.runSort(DriverInterface.SortType.BubbleSort, DriverInterface.ArrayType.Increasing, 10000, 10);
       driver.runSort(DriverInterface.SortType.InsertionSort, DriverInterface.ArrayType.Increasing, 10000,
               10);
       driver.runSort(DriverInterface.SortType.SelectionSort, DriverInterface.ArrayType.Increasing, 10000,
               10);

       // 10000 decreasing Integers
       driver.runSort(DriverInterface.SortType.BubbleSort, DriverInterface.ArrayType.Decreasing, 10000, 10);
       driver.runSort(DriverInterface.SortType.InsertionSort, DriverInterface.ArrayType.Decreasing, 10000,
               10);
       driver.runSort(DriverInterface.SortType.SelectionSort, DriverInterface.ArrayType.Decreasing, 10000,
               10);
       
    // 10000 Increasing and Random Integers
       driver.runSort(DriverInterface.SortType.BubbleSort, DriverInterface.ArrayType.IncreasingAndRandom, 10000, 10);
       driver.runSort(DriverInterface.SortType.InsertionSort, DriverInterface.ArrayType.IncreasingAndRandom, 10000,
               10);
       driver.runSort(DriverInterface.SortType.SelectionSort, DriverInterface.ArrayType.IncreasingAndRandom, 10000,
               10);
   }
}