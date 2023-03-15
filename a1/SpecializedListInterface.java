package a1;

public interface SpecializedListInterface {
	
		

		public void resetForward();
		// Effect: Initializes current forward position for this list
		// Postcondition: Current forward position is first element on this list

		public byte getNextItem ();
		// Effect: Returns the value of the byte at the current forward
		// position on this list and advances the value of the
		// current forward position
		//
		// Preconditions:
		// - Current forward position is defined
		// - There exists a list element at current forward position
		// - No list transformers (i.e. insertion methods) have been called
		// since the most recent call of getNextItem; and if list transformer calls
		// have been made since the most recent call of getNextItem,
		// or getNextItem has never been called on the list,
		// then a call must be made to resetForward before calling getNextItem.
		//
		// Postconditions:
		// - Return value = (value of byte at current forward position)
		// - If current forward position is the last element then
		// current forward position is set to the beginning of this
		// list, otherwise it is updated to the next position

		public void resetBackward();
		// Effect: Initializes current backward position for this list
		// Postcondition: Current backward position is last element on this list

		public byte getPriorItem ();
		// Effect: Returns the value of the byte at the current backward
		// position on this list and advances the value of the
		// current backward position (towards front of list)
		//
		// Preconditions:
		// - Current backward position is defined
		// - There exists a list element at current backward position
		// - No list transformers (i.e. insertion methods) have been called
		// since the most recent call of getPriorItem; and if list transformer calls
		// have been made since the most recent call of getPriorItem,
		// or getPriorItem has never been called on the list,
		// then a call must be made to resetBackward before calling getPriorItem.
		//
		// Postconditions:
		// - Return value = (value of byte at current backward
		// position)
		// - If current backward position is the first element then
		// current backward position is set to the end of this list;
		// otherwise, it is updated to the prior position

		public int lengthIs();
		// Effect: Determines the number of elements on this list
		// Postcondition: Return value = number of elements on this list
		public void insertFront (byte item);
		// Effect: Adds the value of item to the front of this list
		// PostCondition: Value of item is at the front of this list
		public void insertEnd (byte item);
		// Effect: Adds the value of item to the end of this list
		// PostCondition: Value of item is at the end of this list

}
