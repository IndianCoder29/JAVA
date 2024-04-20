package slip5;

import java.util.*;

public class Question1 {
 public static void main(String[] args) {
 // Create a Hashtable to store mobile numbers and student names
 Hashtable<String, String> students = new Hashtable<String, String>();
 // Add students to the Hashtable
 students.put("1234567890", "John Doe");
 students.put("0987654321", "Jane Doe");
 students.put("1122334455", "Jim Smith");
 // Get an Enumeration of the keys (mobile numbers)
 Enumeration<String> mobileNumbers = students.keys();
 // Display the details of students using Enumeration
 while (mobileNumbers.hasMoreElements()) {
 String mobileNumber = mobileNumbers.nextElement();
 String studentName = students.get(mobileNumber);
 System.out.println("Mobile Number: " + mobileNumber + ", Student Name:" + studentName);
 }
 }
}