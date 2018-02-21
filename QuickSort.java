import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
 class QuickSort {
   
   public static  int[] small() {
    Random rgen0 = new Random();
    int snumber =  10;
    int[]  small = new int[snumber];
    for(int j=0;j<small.length;j++) {
      int randomPosition0 = rgen0.nextInt(small.length);
      small[j] = rgen0.nextInt(snumber);
       
      
    }
    return  small;
  }
  
  
  //Medium method 1000 data items for medium
  public static  int[] medium() {
    Random rgen1 = new Random(); 
    int medNum = 1000;
    int[]  medium = new int[medNum];
    for(int i=0;i<medium.length;i++) {
       int randomPosition1 = rgen1.nextInt(medium.length);
       medium[i] =  rgen1.nextInt(medNum);
    }
    return  medium;
  }
  
  
  //Large  method items for large.
  
  public static  int[] large() {
    Random rgen2 = new Random();
    int lnumber=  10000;
    int[]  large = new int[lnumber];
    
    for(int k=0;k<large.length;k++) {
      int randomPosition2 = rgen2.nextInt(large.length);
      large[k]=rgen2.nextInt(lnumber);;
       
      
    }
    return  large;
  }
  public static  void writeToFile(int[] array, FileWriter  fw) throws IOException {
  for (int i = 0; i < array.length; i++) {
	   
      fw.write( array[i] + ",");
    }
  }
 
  public static void main(String[] args) throws IOException {
    int[] small = small();
    int[] mediumDataSet = medium();
    int[] lDataSet = large();
    long startTime;//wait timer variables
    long endTime;
    long wait; //individual customer wait time
    long totalTimeUnSorted;
    long totalTimeSorted;
    
    FileWriter fw = new FileWriter("results5.txt");
    startTime =  System.nanoTime();
    fw.write("QuickSort UNSORT Items:\n");
    fw.write("SmallSet [");
    writeToFile(small,fw);
    	fw.write("]");
    
    fw.write("\n Medium: Set [");
    writeToFile(mediumDataSet,fw);
    fw.write("]");
    writeToFile( lDataSet,fw);
    fw.write("]");
    
      endTime   = System.nanoTime();
      
      totalTimeUnSorted= endTime - startTime;
      System.out.println("Unsorted Array results in Results text the runtime for the Unsort items are:"+totalTimeUnSorted/1000+" Seconds");
   
      
    int low = 0;
    int high = small.length - 1;
    
    
    startTime = 0;
    endTime  = 0;
    
    
    startTime = System.nanoTime();
    
    quickSort(small, low, high);
    fw.write("\nSmall Sort Set:");
    writeToFile(small,fw);
    high = mediumDataSet.length - 1;
    quickSort(mediumDataSet, low, high);
    fw.write("\nMedium Sorted Set:");
    writeToFile( mediumDataSet,fw);
    high = lDataSet.length - 1;
    fw.write("\nLarge Sorted Set:");
    quickSort(lDataSet, low, high);
    writeToFile(lDataSet, fw);
    endTime  =System.nanoTime();
    totalTimeSorted= endTime - startTime;
    System.out.print("Summary for QuickSort: time elasped: "+totalTimeSorted/1000+" seconds"); 
    
    small=small();
    mediumDataSet=medium();
    lDataSet=large();
    
    
    
    System.out.println("\nDataSet for Bubblesort UNSORT Items written to file ");
    startTime =  System.nanoTime(); 
    
    fw.write("\nSmallSet [");
    writeToFile(small,fw);
    	fw.write("]\n");
    fw.write("\n Medium Set [");
    writeToFile(mediumDataSet,fw);
    fw.write("]\n");
    fw.write("\n Large Set [");
    writeToFile( lDataSet,fw);
    fw.write("]\n");
     
     endTime   = System.nanoTime();
   
    totalTimeUnSorted= endTime - startTime;
    System.out.println("Sorted Array results in Results text the runtime for the Unsort items are: "+totalTimeUnSorted/1000+" Seconds");
   
    startTime =  System.nanoTime();
    
    bubbleSort(small);
    writeToFile(small,fw);
    bubbleSort(mediumDataSet);
    writeToFile(mediumDataSet,fw);
    bubbleSort(lDataSet);
    writeToFile( lDataSet,fw);
    endTime   = System.nanoTime();
    totalTimeSorted= endTime - startTime;
    
    fw.close();
    System.out.println("Summary for Bubble Sort is: "+totalTimeSorted/1000+" Seconds");
    
    
  }
 
  
  
  
  public static void quickSort(int[] arr, int low, int high) {
    if (arr == null || arr.length == 0)
      return;
 
    if (low >= high)
      return;
 
    // pick the pivot
    int middle = low + (high - low) / 2;
    int pivot = arr[middle];
 
    // make left < pivot and right > pivot
    int i = low, j = high;
    while (i <= j) {
      while (arr[i] < pivot) {
        i++;
      }
 
      while (arr[j] > pivot) {
        j--;
      }
 
      if (i <= j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
      }
    }
 
    // recursively sort two sub parts
    if (low < j)
      quickSort(arr, low, j);
 
    if (high > i)
      quickSort(arr, i, high);
  }
   
       static void bubbleSort(int[] arr) {  
        int n = arr.length;  
        int temp = 0;  
         for(int i=0; i < n; i++){  
                 for(int j=1; j < (n-i); j++){  
                          if(arr[j-1] > arr[j]){  
                                 //swap elements  
                                 temp = arr[j-1];  
                                 arr[j-1] = arr[j];  
                                 arr[j] = temp;  
                         }  
                          
                 }  
         }  
  
    }   
  
}
