public interface DriverInterface {
  
   // Specify the type of Array
	public static enum ArrayType {Equal, Random, Increasing, Decreasing, IncreasingAndRandom};
  
   // Specify the sort type
	public static enum SortType {BubbleSort, SelectionSort, InsertionSort};

	public Integer[] createArray(ArrayType arrayType, int arraySize);
	public RunTime runSort(SortType sortType, ArrayType arrayType, int arraySize, int numberOfTimes);
}