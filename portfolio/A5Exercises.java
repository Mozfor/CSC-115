public class A5Exercises {

	// PART 1

	/*
	 * Purpose: get a count of the number of elements in the array
	 *          with a value that is a multiple of x
	 * Parameters: int[] arr
	 * Returns: int - the number multiples of x
	 * Pre-condition: x > 0
	 * Post-condition - the array contents are unchanged
	 */
	public static int countMultiples(int[] arr, int x) {
		int index = 0;
		int count = 0;
		if (arr.length==0){
			return count;
		} else if (arr.length==1){
			if (arr[index]%x==0){
				count++;
			}
			return count;
		}
		
		
		return countMultiplesRec(arr, x, index, count);
		
	}
	
	public static int countMultiplesRec(int[] arr, int x, int index, int count){
		if (index==arr.length){
			return count;
		}
		if (arr[index]%x==0){
			count++;
		}
			
		index++;
		return countMultiplesRec(arr, x, index, count);
	}
	
	//YOOO IT WORKS
	
	
	
	/*
	 * Purpose: double all values in the given array
	 * Parameters: int[] array - the array to modify
	 * Returns: void - nothing
	 */
	public static void doubleAll(int[] array) {
		int[] newArray = new int[array.length];
		int index = 0;
		
		if (array.length==1){
			array[index]*=2;
		} else {
			
			newArray = doubleAllRec(array, index);
			
		}
		array = newArray;
	}
	
	public static int[] doubleAllRec(int[] array, int index){
		if (index==array.length){
			return array;
		} else {
			array[index]*=2;
			index++;
			return doubleAllRec(array, index);
		}
	}
	//wooooo
	
	
	
	/*
	 * Purpose: get the minimum value found in the array
	 * Parameters: int[] array - the array to search
	 * Returns: int - minimum value found in the array
	 *                or -1 if the array is empty
	 * Post-condition - the array contents are unchanged
	 */
	public static int getMinimum(int[] array) {
		if (array.length==0){
			return -1;
		}
		
		int index = 0;
		int lowest = array[index];
		if (array.length==1){
			return lowest;
		}
		
		return getMinimumRec(array, index, lowest);
		

	}
	
	public static int getMinimumRec(int[] array, int index, int lowest){
		if (index==array.length){
			return lowest;
		} else {
			if (array[index]<lowest){
				lowest = array[index];
			}
			
			index++;
			return getMinimumRec(array, index, lowest);
		}
	}
	
	//hu3pg9wu8e0ob[42w9tk[-0-r3gptrpbgfo


	// PART II

	/*
	 * Purpose: get the total number of books in s
	 * Parameters: Stack<Book> s - the stack of books
	 * Returns: int - the total number of books
	 * Post-condition: s is not modified
	 */
	public static int totalBooks(Stack<Book> s) {
		A5Stack<Book> temp = new A5Stack<Book>();
		if (s.isEmpty()){
			return 0;
		}
		return totalBooksRec(s, temp, 0);

	}

	public static int totalBooksRec(Stack<Book> s, Stack<Book> temp, int count){
		if (s.top()!=null){
			temp.push(s.pop());
			count++;
			return totalBooksRec(s, temp, count);
		} else {
			putBack(s, temp);
			return count;
		}
	}
	
	public static void putBack(Stack<Book> s, Stack<Book> temp){
		if (temp.isEmpty()){
			return;
		} else {
			s.push(temp.pop());
			putBack(s, temp);
		}
	}


	/*
	 * Purpose: get the total number of pages of all 
	 *          books in the stack
	 * Parameters: Stack<Book> s - the stack of books
	 * Returns: int - the total number of pages
	 * Post-condition: s is not modified
	 */
	public static int totalPages(Stack<Book> s) {
		A5Stack<Book> temp = new A5Stack<Book>();
		if (s.isEmpty()){
			return 0;
		}
		
		return totalPagesRec(s, temp, 0);

	}

	public static int totalPagesRec(Stack<Book> s, Stack<Book> temp, int count){
		if (s.top()!=null){
			
			temp.push(s.pop());
			count = (count + temp.top().getPages());

			return totalPagesRec(s, temp, count);
			
		} else {
			
			putBack(s, temp);
			return count;
		}
	}
	
	/*
	 * Purpose: get the average number of pages of books in s
	 * Parameters: Stack<Book> s - the stack of books
	 * Returns: double - the average number of pages
	 *                   0.0 if there are no books in s
	 * Post-condition: s is not modified
	 */
	public static double averagePages(Stack<Book> s) {
		// You don't need to change this, if you have
		// completed the previous two exercises
		// correctly, it should pass all the tests
		if (s.isEmpty()) {
			return 0.0;
		} else {
			double sum = totalPages(s);
			int count = totalBooks(s);
			return sum/count;
		}
	}

	/*
	 * Purpose: determine whether toFind is contained in s
	 * Parameters: Stack<Book> s - the stack of books
	 *             Book toFind - the book to search for
	 * Returns: boolean - true if s contains toFind, false otherwise
	 * Post-condition: s is not modified
	 */
	public static boolean containsBook(Stack<Book> s, Book toFind) {
		A5Stack<Book> temp = new A5Stack<Book>();
		if (s.isEmpty()){
			return false;
		}
	
		return containsBookRec(s, temp, toFind);
	}

	public static boolean containsBookRec(Stack<Book> s, Stack<Book> temp, Book toFind){
		
		if (s.top()!=null){
			
			temp.push(s.pop());
			if(temp.top().equals(toFind)){
				putBack(s, temp);
				return true;
			}

			return containsBookRec(s, temp, toFind);
			
		} else {
			
			putBack(s, temp);
			return false;
		}
	}

	/*
	 * Purpose: determine the books in s are stacked correctly
	 *          (ie. there is never a book stacked on top of 
	 *               another book with fewer pages)
	 * Parameters: Stack<Book> s - the stack of books
	 * Returns: boolean - true if books in s are stacked correctly
	 * Post-condition: s is not modified
	 */
	public static boolean stackedCorrectly(Stack<Book> s) {
		if (s.top()==null){
			return true;
		}
		
		A5Stack<Book> temp = new A5Stack<Book>();
		
		return (stackedCorrectlyRec(s, temp));
	}
	
	public static boolean stackedCorrectlyRec(Stack<Book> s, Stack<Book> temp){
		if (s.top()==null){
			putBack(s, temp);
			return true;
		}
		
		temp.push(s.pop());
		
		if (s.top()==null){
			putBack(s, temp);
			return true;
		}
		
		
		if(temp.top().getPages()>s.top().getPages()){
			putBack(s, temp);
			return false;
		} else {
			return stackedCorrectlyRec(s, temp);
		}
		
		
	}
}