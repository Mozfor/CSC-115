//Name: Owen Lutwyche
//SID: V00977111

public class A2Exercises {

	/*
	 * Purpose: get the number of students in the given course  	
	 *          with a grade above the given grade threshold
	 * Parameters: UvicCourse course
	 *             int gradeThreshold 
	 * Returns: int - the number of enrolled students with 	
	 *                a grade above gradeThreshold
	 */
	public static int countAbove(UvicCourse course, int gradeThreshold) {
		int count = 0;
		// TODO: implement this
		
		Student[] list = course.getClassList();
		int length = list.length;
		
		
		for (int i=0;i<length;i++){
			
			if (list[i].getGrade()>gradeThreshold){
				count +=1;
			}
			
		}
		
		
		return count; // so it compiles
	}
	
	/*
	 * Purpose: get the name of the class with the highest average
	 * Parameters: UvicCourse[] courses - the array of courses
	 * Returns: String - the name of the course with the highest average
	 * Precondition: the array has at least one course in it
	 * NOTE: if there are two are more courses with the same class average 
	 *       which is the highest value of all courses in the array,
	 *       the name of course that comes first in the array is returned
	 */
	public static String highestAverage(UvicCourse[] courses) {
	
		String courseName = courses[0].getName();
		double[] averages = new double[courses.length];
		double largest = 0.0;
		int largestIndex = 0;
		
		for(int i=0;i<courses.length;i++){
			averages[i] = courses[i].averageGrade();
		}
		for(int i=0;i<averages.length;i++){
			if (averages[i]>largest){
				largest = averages[i];
				largestIndex = i;
			}
		}
		courseName = courses[largestIndex].getName();
		
		return courseName; // so it compiles
	}
	
	/*
	 * Purpose: get the average grade of the student with given sid
	 *          across all courses the student is enrolled in
	 * Parameters: UvicCourse[] courses - an array of courses
	 *             String sid - the sid of the student for which 
	 *                          to calculate the average grade for
	 * Returns: double - the average grade of the student with given sid
	 *                   -1 if the student is not in any of the courses	 
	 *
	 * Note: the student is not necessarily enrolled in the courses
	 *       found in the given array
	 */
	public static double studentAverage(UvicCourse[] courses, String sid) {
		// TODO: implement this	
		int total = 0;
		int count = 0;
		double average = 0.0;

		
		Student s = new Student(sid, 0);
		Student[] classList = new Student[0];
		for (int i=0;i<courses.length;i++){
			
			classList = courses[i].getClassList();
			for(int x=0;x<classList.length;x++){
				if(classList[x].getSid() == sid){
				

					total+=courses[i].getGrade(sid);

					count+=1;

				} else {

				}
			}
		}
		
		if ((total == 0) || (count == 0)){
			return average;
		} else{
		
			average = total/count;
		
			}
		return average; // so it compiles
		
	}
	
}