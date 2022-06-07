package SingletonDesignPattern;

import java.io.IOException;
import java.util.Scanner;

public class JDBCSingletonDemo {

  public static void main(String[] args) throws IOException {
    JDBCSingleton jdbc= JDBCSingleton.getInstance();
    int choice = 0;
    Scanner sc = new Scanner(System.in);
    do {
      System.out.println("DATABASE OPERATIONS");
      System.out.println(" --------------------- ");
      System.out.println(" 1. Insertion ");
      System.out.println(" 2. View ");
      System.out.println(" 3. Delete ");
      System.out.println(" 4. Update ");
      System.out.println(" 5. Exit ");
      System.out.print("Please enter the choice what you want to perform in the database: ");
      choice =sc.nextInt();
      int count = 0;
      switch(choice) {
        case 1:{
          System.out.print("Enter the Employee ID you want to insert data into the database: ");
          int empId=sc.nextInt();
          System.out.print("Enter the Employee Name you want to insert data into the database: ");
          String empName=sc.next();
          System.out.print("Enter the Employee Age you want to insert data into the database: ");
          int empAge=sc.nextInt();
          System.out.print("Enter the Employee Department you want to insert data into the database: ");
          String empDept=sc.next();
          try {
            int i= jdbc.insert(empId, empName, empAge, empDept);
            if (i>0) {
              System.out.println((++count) + " Data has been inserted successfully");
            } else {
              System.out.println("Data has not been inserted ");
            }
          } catch (Exception e) {
            System.out.println(e);
          }
          System.out.println("Press Enter key to continue...");
          sc.nextLine();
          }
        break;
        case 2:{
          System.out.print("Enter the Employee Name : ");
          String empName=sc.next();
          try {
            jdbc.view(empName);
          } catch (Exception e) {
            System.out.println(e);
          }
          System.out.println("Press Enter key to continue...");
          sc.nextLine();
          }
        break;
        case 3:{
          System.out.print("Enter the Employee ID, you want to delete: ");
          int empId=sc.nextInt();
          try {
            int i= jdbc.delete(empId);
            if (i>0) {
              System.out.println((++count) + " Data has been deleted successfully");
            } else {
              System.out.println("Data has not been deleted");
            }
            } catch (Exception e) {
              System.out.println(e);
            }
          System.out.println("Press Enter key to continue...");
          sc.nextLine();
          }
        break;
        case 4:{
          System.out.print("Enter the Employee ID, you want to update: ");
          int empId=sc.nextInt();
          System.out.print("Enter the Employee Name ");
          String empNameChanged=sc.next();
          try {
            int i= jdbc.update(empId, empNameChanged);
            if (i>0) {
              System.out.println((++count) + " Data has been updated successfully");
            }
          } catch (Exception e) {
              System.out.println(e);
          }
          System.out.println("Press Enter key to continue...");
          sc.nextLine();
          }
        break;
        default: return;
        } 
   } while (choice!=5);

  }

}
