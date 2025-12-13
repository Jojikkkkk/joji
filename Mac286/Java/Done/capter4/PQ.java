class PriorityQApp
   {
   public static void main(String[] args)
      {
      PriorityQ thePQ = new PriorityQ(5);
      thePQ.remove();
      thePQ.insert(127);
      thePQ.insert(124);
      thePQ.insert(12);
      thePQ.insert(125);


      while(!thePQ.isEmpty())
          {
          long item = thePQ.remove();
          System.out.print(item + " ");  // 10, 20, 30, 40, 50
           }  // end while


      }  // end main()
//-------------------------------------------------------------
   }  // end class PriorityQApp
class PriorityQ
   {
   // array in sorted order, from max at 0 to min at size-1
   private int maxSize;
   private long[] queArray;
   private int nItems;
//-------------------------------------------------------------
   public PriorityQ(int s)          // constructor
      {
      maxSize = s;
      queArray = new long[maxSize];
      nItems = 0;
      }
//-------------------------------------------------------------
   public void insert(long item)    // insert item
      {
        queArray[nItems++] = item;
      }  // end insert()
//-------------------------------------------------------------
   public long remove(){
      long min = queArray[nItems-1];
      for(int j=nItems-1; j>=0; j--){      // start from nItems - 1,
              if(queArray[j] < min){     // find minimum nuber on the Queue
                long sw = min;         // swap minimum
                min = queArray[j];
                queArray[j] = sw;
                }
              }
      queArray[nItems-1] = 0;       // Erase nItems-1's variable becase min is stored
      nItems--;
      return min;
    }
//-------------------------------------------------------------
   public long peekMin()            // peek at minimum item
      { return queArray[nItems-1]; }
//-------------------------------------------------------------
   public boolean isEmpty()         // true if queue is empty
      { return (nItems==0); }
//-------------------------------------------------------------
   public boolean isFull()          // true if queue is full
      { return (nItems == maxSize); }
//-------------------------------------------------------------
   }  // end class PriorityQ
