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
      if (students.get(i).getId().equalsIgnoreCase(studentId)){
         return students.get(i).getGrade(super.getCode());
      }
   }
     return 0.0; 
   }
   
   // Returns a String containing the course information as well as the semester and the number of students 
   // enrolled in the course
   // must override method in the superclass Course and use super class method getDescription()
   public String getDescription()
   {
	   return super.getDescription() + " " +semester + " Enrollment: " + students.size();
   }
    
   // Sort the students in the course by name using the Collections.sort() method with appropriate arguments
   // Make use of a private Comparator class below
   public void sortByName()
   {
      Collections.sort(students, new nameComparator());
   }
   
   // Fill in the class so that this class implement the Comparator interface
   // This class is used to compare two Student objects based on student name
   private class nameComparator implements Comparator<Student>
   {
      public int compare(Student a,Student b)
      {
         return a.getName().compareTo(b.getName());
      }
   }
   
   // Sort the students in the course by student id using the Collections.sort() method with appropriate arguments
   // Make use of a private Comparator class below
   public void sortById()
   {
 	  Collections.sort(students, new IdComparator());
   }
   
   // Fill in the class so that this class implement the Comparator interface
   // This class is used to compare two Student objects based on student id
   private class IdComparator implements Comparator<Student>
   {
   	public int compare(Student a, Student b){
         int aID = Integer.parseInt(a.getId());
         int bID = Integer.parseInt(b.getId());
         if (aID > bID) return 1;
         else if (aID < bID) return -1;
         else return 0;
      }
   }

   // return the list of students in this active course, used in registry
   public ArrayList<Student> getStudents(){
      return students;
   }
   // add a student, used in registry
   public void addStudent(Student newStudent) {
      students.add(newStudent);
   }
   // remove a student, used in registry
   public void removeStudent(Student currStudent){
      students.remove(currStudent);
   }
}
