// bubbleSort.java
// demonstrates bubble sort
// to run this program: C>java BubbleSortApp
////////////////////////////////////////////////////////////////
// Joji Kashimura 9/30/20
////////////////////////////////////////////////////////////////
class OddEvenSortApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;            // array size
      ArrayOdd arr = new ArrayOdd(maxSize);              // reference to array
        // create the array

        for(int j=0; j<maxSize;j++)
        {
          long n = (long)(java.lang.Math.random()*(maxSize-1));
          arr.insert(n);
        }


      arr.display();                // display items

          System.out.println("Running Sort with numberSamples = " + maxSize);
          long startTime = System.currentTimeMillis();
          arr.OddEvenSort();// bubble sort them
          //arr.selectionSort(); // bubble sort them
          //arr.insertionSort(); // bubble sort them
          long endTime = System.currentTimeMillis();
          System.out.println("Total execution time: " + (endTime-startTime)/1000 + " secs");
      //      arr.oddEvenSort();  // After this assignment is done you can try this
       // create the array
                   // bubble sort them

      arr.display();                // display them again
      }  // end main()
   }  // end class BubbleSortApp

class ArrayOdd
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
//--------------------------------------------------------------
   public ArrayOdd(int max)          // constructor
      {
      a = new long[max];                 // create the array
      nElems = 0;                        // no items yet
      }
//--------------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      a[nElems] = value;             // insert it
      nElems++;                      // increment size
      }
//--------------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }
//-----This is my home work.
//---------------------------------------------------------
   public void OddEvenSort(){
      int flag = 1;
      while(flag==1){
        flag = 0;
         for(int i = 0;i<nElems-1;i+=2){ // Even number sort
            if( a[i] > a[i+1] ){
               swap(i,i+1);
              flag = 1;}
             }

          for(int i = 1;i<nElems-1;i+=2){ // Odd number sort
            if( a[i] > a[i+1] ){
               swap(i,i+1);
               flag = 1;}
          }
        }
      }
//--------------------------------------------------------------
   private void swap(int one, int two)
      {
      long temp = a[one];
      a[one] = a[two];
      a[two] = temp;
      }
//--------------------------------------------------------------
   } // end class ArrayBub
