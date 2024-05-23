import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Lead Author(s):Zhanhang Xiao
 * Fermin Garduno
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * Gaddis, T. (2015). Starting out with Java: From control structures through objects. Addison-Wesley. 
 * 
 * <<add more references here>>
 *  
 * Version/date: May 23, 2024
 * 
 * Responsibilities of class:
 * Contains methods responsible for saving and loading data from the txt files.
 * Extremely useful and important!
 */
public class SavingDataClass {
	/**
	 * saves accounts to accounts.txt
	 * @param accounts
	 * @param accountsFile
	 */
    public static void saveAccounts(ArrayList<Account> accounts, String accountsFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(accountsFile))) {
            for (Account account : accounts) {
                writer.write(account.getName() + "," + account.getPassword() + "," + account.isStaff() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
	 * loads account from accounts.txt
	 * @param accountsFile
	 */
    public static ArrayList<Account> loadAccounts(String accountsFile) {
        ArrayList<Account> accounts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(accountsFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    accounts.add(new Account(parts[0], parts[1], Boolean.parseBoolean(parts[2])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    /**
	 * saves courses to courses.txt
	 * @param courses
	 * @param coursesFile
	 */
    public static void saveCourses(ArrayList<Course> courses, String coursesFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(coursesFile))) {
            for (Course course : courses) {
                writer.write(course.getCourseName() + "," + course.getCourseInfo() + "," + course.getCourseDate() + "," + course.getCourseTime() + "," + course.getNumberOfMembers() + "," + course.getMaxOccupant() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
	 * loads courses from courses.txt
	 * @param coursesFile
	 */
    public static ArrayList<Course> loadCourses(String coursesFile) {
        ArrayList<Course> courses = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(coursesFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    Course course = new Course(parts[0], parts[1], LocalDate.parse(parts[2]), LocalTime.parse(parts[3]));
                    courses.add(course);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return courses;
    }
    
    /**
     * saves the enrollment relationship to enrollment.txt
     * @param accounts
     * @param enrollmentsFile
     */
    public static void saveEnrollments(ArrayList<Account> accounts, String enrollmentsFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(enrollmentsFile))) {
            for (Account account : accounts) {
                for (Course course : account.getCoursesEnrolledIn()) {
                    writer.write(account.getName() + "," + course.getCourseName() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads the enrollment relationship between accounts and courses from enrollment.txt
     * It creates a hashmap using the info from the txt file that it then uses
     * to add the enrollment into to the program
     * @param enrollmentsFile
     * @param accounts
     * @param courses
     */
    public static void loadEnrollments(String enrollmentsFile, ArrayList<Account> accounts, ArrayList<Course> courses) {
        HashMap<String, Account> accountMap = new HashMap<>();
        HashMap<String, Course> courseMap = new HashMap<>();

        for (Account account : accounts) {
            accountMap.put(account.getName(), account);
        }

        for (Course course : courses) {
            courseMap.put(course.getCourseName(), course);
        }

        /**
    	 * reader to read enrollment.txt and runs the loop to fillout the hashmaps until it's out of info
    	 */
        try (BufferedReader reader = new BufferedReader(new FileReader(enrollmentsFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("#")) {
                    continue; // Skip comment lines
                }
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    Account account = accountMap.get(parts[0]);
                    Course course = courseMap.get(parts[1]);
                    if (account != null && course != null) {
                        account.addCourse(course);
                    }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}