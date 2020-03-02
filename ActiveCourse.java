import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//  University Course
 
public class ActiveCourse extends Course {
   private ArrayList<Student> students;
   private String semester;

   // Add a constructor method with appropriate parameters
   // should call super class constructor to initialize inherited variables
   // make sure to *copy* students array list being passed in into new arraylist of
   // students
   // create Grade objects for each Student object and add to grades arraylist. Set
   // grade to 0
   // see class Registry to see how an Course object is created and used
   public ActiveCourse(String name, String code, String descr, String fmt, String semester,
         ArrayList<Student> students)
   {
      super(name,code, descr, fmt);
      this.semester = semester;
      this.students = new ArrayList<Student>(students); // change to a copy not reference
   }
   
   public String getSemester()
   {
	   return semester;
   }
   
   // Prints the students in this course  (name and student id)
   public void printClassList()
   {
	   for (int i = 0; i < students.size(); i++){
         System.out.println(students.get(i).toString());
      }
   }
   
   // Prints the grade of each student in this course (along with name and student id)
   // 
   public void printGrades()
   {
	   for (int i = 0; i < students.size(); i++){
         System.out.println(students.get(i).toString() + " " + students.get(i).getGrade(super.getCode())); // not sure about students.get(i).getGrade(super.getCode()) 
      }
   }
   
   // Returns the numeric grade in this course for this student
   // If student not found in course, return 0 
   public double getGrade(String studentId)
   {
	  // Search the student's list of credit courses to find the course code that matches this  course
	  // see class Student method getGrade() 
	  // return the grade stored in the credit course object
     for (int i = 0; i < students.size(); i++){
      if (students.get(i).getId().equals(studentId)){
         return students.get(i).getGrade(super.getCode());
      }
   }
     return 0; 
   }
   
   // Returns a String containing the course information as well as the semester and the number of students 
   // enrolled in the course
   // must override method in the superclass Course and use super class method getDescription()
   public String getDescription()
   {
	   return super.getDescription() + semester + " "+ students.size() +" Students";
   }
    
   
   
   
   // Sort the students in the course by name using the Collections.sort() method with appropriate arguments
   // Make use of a private Comparator class below
   public void sortByName()
   {

   }
   
   // Fill in the class so that this class implement the Comparator interface
   // This class is used to compare two Student objects based on student name
   private class NameComparator
   {
   	
   }
   
   // Sort the students in the course by student id using the Collections.sort() method with appropriate arguments
   // Make use of a private Comparator class below
   public void sortById()
   {
 	  
   }
   
   // Fill in the class so that this class implement the Comparator interface
   // This class is used to compare two Student objects based on student id
   private class IdComparator
   {
   	
   }
}
