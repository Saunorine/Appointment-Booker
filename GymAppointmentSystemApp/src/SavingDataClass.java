import java.io.*;
import java.util.ArrayList;

public class SavingDataClass {

    public static void saveData(ArrayList<Account> accounts, ArrayList<Course> courses, String accountsFile, String coursesFile) {
        try (ObjectOutputStream oosAccounts = new ObjectOutputStream(new FileOutputStream(accountsFile));
             ObjectOutputStream oosCourses = new ObjectOutputStream(new FileOutputStream(coursesFile))) {
            oosAccounts.writeObject(accounts);
            oosCourses.writeObject(courses);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Account> loadAccounts(String accountsFile) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(accountsFile))) {
            return (ArrayList<Account>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static ArrayList<Course> loadCourses(String coursesFile) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(coursesFile))) {
            return (ArrayList<Course>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}