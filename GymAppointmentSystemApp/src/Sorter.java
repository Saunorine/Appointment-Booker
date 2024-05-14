import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
//import java.util.Collections;
//import java.util.List;

public class Sorter 
{

	public static void main(String[] args) {
	
	//3 Course constructors
	Course course1 = new Course("Yoga", "Stretching", "05/13/24", "3:30pm");
	Course course2 = new Course("Zumba", "Dancing", "05/13/24", "4:30pm");
	Course course3 = new Course("Personal Training", "one on one training", "05/13/24", "5:30pm");
	
	//added those classes in an arrayList
	ArrayList<Course> courses = new ArrayList<Course>();
	courses.add(course1);
	courses.add(course2);
	courses.add(course3);
	
	Comparator<Course> com = new Comparator<Course>() {

		@Override
		public int compare(Course course1, Course course2) {
			
			return course1.getCourseName().compareTo(course2.getCourseName());
		}
		
		
	};
	
	
	Collections.sort(courses, com);
	
	for (Course course : courses) {
		System.out.println(course);
	}
	
}
}

