// Mac 286 Joji Kashimura 9/29/20
class HighArrayApp
{
  public static void main(String[] args)
  {
  int maxSize = 100; // array size
  HighArray arr; // reference to array
  arr = new HighArray(maxSize); // create the array
        arr.insert(55);
        arr.insert(22);
        arr.insert(77); // insert 10 items
        arr.insert(33);
        arr.insert(44);
        arr.insert(99);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);

        System.out.print("current array items: ");
        arr.display(); // display items

        int searchKey = 66; // search for item
    if( arr.find(searchKey) )
      System.out.println("Found " + searchKey);
    else
      System.out.println("Can’t find " + searchKey);
        arr.delete(77); // delete 3 items
        arr.delete(22);
        arr.delete(44);
        System.out.print("array items after delete some values: ");
        arr.display(); // display items again


  // This is my homework //////////////////////////////////////
  /*  System.out.println("the Max is " + arr.getMax());
  System.out.print("the array after calling max method: ");
  arr.display();*/

  arr.removeMax();
  arr.removeMax();
  arr.removeMax();
  System.out.print("the array after calling remove max method: ");
  arr.display();

  System.out.println("the new Max is "+ arr.getMax());

  arr.reverse();
  System.out.print("the array after calling reverse method: ");
  arr.display();

  //////////////////////////////////////////////////////////////
    // end main()
    }
  } // end class HighArrayApp

class HighArray
{
  private long[] a; // ref to array a
  private int nElems; // number of data items
//-----------------------------------------------------------
  public HighArray(int max) // constructor
  {
   a = new long[max]; // create the array
   nElems = 0; // no items yet
  }
//-----------------------------------------------------------
  public boolean find(long searchKey)
  { // find specified value
    int j;
    for(j=0; j<nElems; j++) // for each element,
      if(a[j] == searchKey) // found item
    	break; // exit loop before end
	if(j == nElems) // gone to end?
	  return false; // yes, can’t find it
	else
      return true; // no, found it
  } // end find()

  //-----------------------------------------------------------
  public void insert(long value) // put element into array
  {
	a[nElems] = value; // insert it
	nElems++; // increment size
  }

  //-----------------------------------------------------------
  public boolean delete(long value)
  {
	int j;

	for(j=0; j<nElems; j++) // look for it
 	  if( value == a[j] )
    	break;
	if(j==nElems) // can’t find it
	 return false;
	else // found it
	 {
    	for(int k=j; k<nElems; k++) // move higher ones down
	     a[k] = a[k+1];
    	nElems--; // decrement size
	    return true;
     }
   } // end delete()

  //-----------------------------------------------------------
  public void display() // displays array contents
	{
    	for(int j=0; j<nElems; j++) // for each element,
	      System.out.print(a[j] + " "); // display it
    	System.out.println("");
	}
	//-----------------------------------------------------------
// These program is my homework//

  public long getMax(){
      long max = a[0]; // a[0] will be stored for the value as maximum
    if(a==null || a[0]<=0) // if array is empty, return -1
      return -1;
    for(int j=1; j < nElems; j++){
      if(a[j]>max) // find maximun in the array
        max = a[j];
      }
      return max; //return maxunum.
    }

  public void removeMax(){
    long max = getMax();
    for(int i= 0;i<nElems;i++){
      if(max == a[i]){ // find max number
      while(i<nElems-1){    // remove max mumber
            a[i] = a[i+1];
            i++;
          }
        nElems--;           // decriment array index
        break;
      }
    }
  }

  public void reverse(){
    long keep;
    for(int i = 0;i<nElems/2;i++){
      keep = a[i];
      a[i] = a[nElems - i -1];
      a[nElems - i -1] = keep;
    }
  }
}  //----------------------------------------------------------
 // end class HighArray

////////////////////////////////////////////////////////////////
