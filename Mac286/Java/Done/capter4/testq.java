class QueueApp
   {
   public static void main(String[] args)
      {
      Queue theQueue = new Queue(5);  // queue holds 5 items

      theQueue.insert(10);            // insert 4 items
      theQueue.insert(20);
      theQueue.insert(30);
      theQueue.insert(40);
      theQueue.remove();
      theQueue.remove();
      theQueue.remove();
      theQueue.insert(60);
      theQueue.insert(80);
      theQueue.insert(100);
      // insert 4 more items


      theQueue.display();
      System.out.println();
    }  // end main()
   }  // end class QueueApp
class Queue
   {
   private int maxSize;
   private long[] queArray;
   private int front;
   private int rear;
   private int nItems;
//--------------------------------------------------------------
   public Queue(int s)          // constructor
      {
      maxSize = s;
      queArray = new long[maxSize];
      front = 0;
      rear = -1;
      nItems = 0;
      }
//--------------------------------------------------------------
   public void insert(long j)   // put item at rear of queue
      {
      if(rear == maxSize-1)         // deal with wraparound
         rear = -1;
      queArray[++rear] = j;         // increment rear and insert
      nItems++;                     // one more item
      }
//--------------------------------------------------------------
   public long remove()         // take item from front of queue
      {
      long temp = queArray[front++];// get value and incr front
      if(front == maxSize)           // deal with wraparound
         front = 0;
      nItems--;  // one less item
      return temp;
      }
//--------------------------------------------------------------
   public long peekFront()      // peek at front of queue
      {
      return queArray[front];
      }
//--------------------------------------------------------------
   public boolean isEmpty()    // true if queue is empty
      {
      return (nItems==0);
      }
//--------------------------------------------------------------
   public boolean isFull()     // true if queue is full
      {
      return (nItems==maxSize);
      }
//--------------------------------------------------------------
   public int size()           // number of items in queue
      {
      return nItems;
      }

      public void display()           // number of items in queue
            {int i = front;
                if( isEmpty() )                                                                                                           //if queue is empty
                System.out.println("The queue is empty.");

                else if(i<=rear){                                                                                                       //if queue is not empty and  front is <= rear
                      for(;i<=rear;i++)
                            System.out.println(queArray[i]);
                }else if(i>rear){                      //if queue is not empty and front is greater than rear
                      for(;i<=maxSize-1;i++)
                            System.out.println(queArray[i]);
                      i=0;
                      for(;i<=rear;i++)
                            System.out.println(queArray[i]);
                          }
        }
      //--------------------------------------------------------------

    }
//--------------------------------------------------------------  // end class Queue
////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////
