public class A4Exercises {
	
	/*
	 * Purpose: determine if the stack of plates has been
	 *          stacked correctly (ie. there is never a plate
	 *          on top of a smaller plate)
	 * Parameters: Stack<Plate> s - a stack of plates
	 * Returns: boolean - true if the plates are stacked correctly
	 *                    false otherwise
	 * Post-condition: the contents of s are not modified
	 */
	public static boolean stackedCorrectly(Stack<Plate> s) {
		Stack<Plate> temp = new A4Stack<Plate>();
		boolean result = true;
		int lastDiameter = 0;
		int curDiameter = 0;
		
		
		if (s.isEmpty()){
			return result;
		} 
		
		
		while ((s.top() != null)) {
			lastDiameter = (s.top().getDiameter());
			temp.push(s.pop());
			
			if(s.top()!=null){
				curDiameter = (s.top().getDiameter());
			}
			
			
			if (lastDiameter>curDiameter){
				result = false;
			}
		}
		
		while(temp.top()!=null){//put everything back.
			s.push(temp.pop());
		}
		
		
		
		return result;
	}
	
	/*
	 * Purpose: insert p into the correct location in the
	 *          stack such that there are no smaller plates 
	 *          below p and no larger plates above p
	 * Parameters: Stack<Plate> s - a stack of plates
	 *             Plate p - the plate to insert into s
	 * Returns: void - nothing
	 * Pre-condition: plates in s have been stacked correctly
	 */
	public static void insertPlate(Stack<Plate> s, Plate p) {

		
		if (s.isEmpty()){
			s.push(p);
		}
		
		
		Stack<Plate> temp = new A4Stack<Plate>();
		int prevDiameter = 0;
		int nextDiameter = 0;
		
		while (s.top()!=null){
			
			prevDiameter = (s.top().getDiameter());
			temp.push(s.pop());
			
			if (s.top()!=null){
				nextDiameter = (s.top().getDiameter());
				
				if((p.getDiameter()<=nextDiameter)&&(p.getDiameter()>=prevDiameter)){
					
					s.push(p);
					
					while(temp.top()!=null){//put everything back.
						s.push(temp.pop());
						
					}
					return;
				}
			}
			
			
			
		}

		

		
		
		
		//push(pop)s stuff from s to temp and pushes p to s 
		//when p is bigger than temp.top and smaller than s.top.
	}
	
}    