// firstLastList.java
// demonstrates list with first and last references
// to run this program: C>java FirstLastApp
////////////////////////////////////////////////////////////////

class FirstLastApp
{
		public static void main(String[] args)
		{ // make a new list
	 	DoublyLinkedList theList = new DoublyLinkedList();// display again

		theList.insertFirst(22);
		theList.insertFirst(44);
		theList.insertFirst(66);

		theList.insertLast(11);
		theList.insertLast(33);
		theList.insertLast(55);

		theList.displayForward();
		theList.displayBackward();

		theList.deleteFirst();
		theList.deleteLast();
		theList.deleteKey(11);

 	  theList.displayForward();

		theList.insertAfter(22, 77);
		theList.insertAfter(33, 88);

		theList.displayForward();

		} // end main()
		} // end class FirstLastApp

		class Link
		{
		public long dData; // data item
		public Link next; // next link in list
		public Link previous;
		// -------------------------------------------------------------
		public Link(long d) // constructor
		{ dData = d; }
		// -------------------------------------------------------------
		public void displayLink() // display this link
		{ System.out.print(dData + " "); }
		//-------------------------------------------------------------
		} // end class Link
		////////////////////////////////////////////////////////////////
class DoublyLinkedList
{
		private Link first; // ref to first link
		private Link last; // ref to last link
		//-------------------------------------------------------------
		public DoublyLinkedList() // constructor
			{
			first = null; // no links on list yet
			last = null;
			}
			//-------------------------------------------------------------
		public boolean isEmpty() // true if no links
			{ return first==null; }
		//-------------------------------------------------------------
		public void insertFirst(long dd) // insert at front of list
			{
		Link newLink = new Link(dd); // make new link
			if( isEmpty() ) // if empty list,
				last = newLink; // newLink <-- last
			else
				first.previous = newLink;

				newLink.next = first; // newLink --> old first
				first = newLink; // first --> newLink
}
//-------------------------------------------------------------
		public void insertLast(long dd) // insert at end of list
			{
			Link newLink = new Link(dd); // make new link
			if( isEmpty() ) // if empty list,
			first = newLink; // first --> newLink
			else{
			last.next = newLink; // old last --> newLink
			last = newLink; // newLink <-- last
		}
			last = newLink;
			}
//-------------------------------------------------------------
public Link deleteFirst() // delete first link
		{ // (assumes non-empty list)
		Link temp = first;
		if(first.next == null) // if only one item
				last = null; // null <-- last
		else
				first.next.previous = null;
			first = first.next; // first --> old next
			return temp;
			}
	// -------------------------------------------------------------

	public Link deleteLast() // delete first link
			{ // (assumes non-empty list)
			Link temp = last;
			if(first.next == null) // if only one item
					first = null; // null <-- last
			else
					last.previous.next = null;
			last = last.previous; // first --> old next
			return temp;
				}

		public boolean insertAfter(long key,long dd)
		{
			Link current = first;
			while(current.dData != key)
			{
				current = current.next;
				if(current == null)
					return false;
			}

			Link newLink = new Link(dd);

			if(current == last)
			{
					newLink.next = null;
					last = newLink;
			}
			else
			{
				newLink.next = current.next;
				current.next.previous = newLink;
			}
			newLink.previous = current;
			current.next = newLink;
			return true;
		}

	public Link deleteKey(long key)
	{
		Link current = first;
		while(current.dData != key)
		{
			current = current.next;
			if(current == null)
				return null;
		}
		if(current == first)
			first = current.next;
		else
			current.previous.next = current.next;

		if(current == last)
			last = current.previous;
		else
			current.next.next = current.next;

		return current;
	}

	public void displayForward(){
		System.out.print("Last (first -> last): ");
		Link current = first;
		while(current != null)
		{
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}

	public void displayBackward(){
		System.out.print("Last (last -> first): ");
		Link current = last;
		while(current != null)
		{
			current.displayLink();
			current = current.previous;
		}
		System.out.println("");
	}


	// -------------------------------------------------------------
	} // end class FirstLastList
	////////////////////////////////////////////////////////////////
