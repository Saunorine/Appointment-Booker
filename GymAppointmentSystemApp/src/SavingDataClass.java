import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

public class SavingDataClass {

    // Save accounts to a text file
    public static void saveAccounts(ArrayList<Account> accounts, String accountsFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(accountsFile))) {
            for (Account account : accounts) {
                writer.write(account.getName() + "," + account.getPassword() + "," + account.isStaff() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load accounts from a text file
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

    // Save courses to a text file
    public static void saveCourses(ArrayList<Course> courses, String coursesFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(coursesFile))) {
            for (Course course : courses) {
                writer.write(course.getCourseName() + "," + course.getCourseInfo() + "," + course.getCourseDate() + "," + course.getCourseTime() + "," + course.getNumberOfMembers() + "," + course.getMaxOccupant() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load courses from a text file
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
    
    // Save enrollments to a text file
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

    // Load enrollments from a text file
    public static void loadEnrollments(String enrollmentsFile, ArrayList<Account> accounts, ArrayList<Course> courses) {
        HashMap<String, Account> accountMap = new HashMap<>();
        HashMap<String, Course> courseMap = new HashMap<>();

        for (Account account : accounts) {
            accountMap.put(account.getName(), account);
        }

        for (Course course : courses) {
            courseMap.put(course.getCourseName(), course);
        }

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}