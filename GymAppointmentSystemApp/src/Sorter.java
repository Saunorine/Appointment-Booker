import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
//import java.util.Collections;
//import java.util.List;

public class Sorter 
{

	public static void main(String[] args) {
		
	
	LocalDate date1 = LocalDate.parse("2024-05-13");
	LocalTime time1 = LocalTime.of(15,30);
	LocalTime time2 = LocalTime.of(16,30);
	LocalTime time3 = LocalTime.of(17,30);
		
	//3 Course constructors
	Course course1 = new Course("Yoga", "Stretching", date1, time1);
	Course course2 = new Course("Zumba", "Dancing", date1, time2);
	Course course3 = new Course("Personal Training", "one on one training", date1, time3);
	
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

