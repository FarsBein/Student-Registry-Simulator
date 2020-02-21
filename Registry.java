import java.util.ArrayList;
import java.util.Collections;

public class Registry
{
   private ArrayList<Student>      students = new ArrayList<Student>();
   private ArrayList<ActiveCourse> courses  = new ArrayList<ActiveCourse>();
   
   public Registry()
   {
	// Add some students
	   // in A2 we will read from a file
	   Student s1 = new Student("JohnOliver", "34562");
	   Student s2 = new Student("HarryWindsor", "38467");
	   Student s3 = new Student("SophieBrown", "98345");
	   Student s4 = new Student("FaisalQuereshi", "57643");
	   Student s5 = new Student("GenghisKhan", "25347");
	   Student s6 = new Student("SherryTu", "46532");
	   students.add(s1);
	   students.add(s2);
	   students.add(s3);
	   students.add(s4);
	   students.add(s5);
	   students.add(s6);
	   // sort the students alphabetically - see class Student
	   
	   ArrayList<Student> list = new ArrayList<Student>();
	   
	   // Add some active courses with students
	   String courseName = "Computer Science II";
	   String courseCode = "CPS209";
	   String descr = "Learn how to write complex programs!";
	   String format = "3Lec 2Lab";
	   list.add(s2); list.add(s3); list.add(s4);
	   courses.add(new ActiveCourse(courseName,courseCode,descr,format,"W2020",list));
	   // Add course to student list of courses
	   s2.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s3.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s4.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	  
	   // CPS511
	   list.clear();
	   courseName = "Computer Graphics";
	   courseCode = "CPS511";
	   descr = "Learn how to write cool graphics programs";
	   format = "3Lec";
	   list.add(s1); list.add(s5); list.add(s6);
	   courses.add(new ActiveCourse(courseName,courseCode,descr,format,"F2020",list));
	   s1.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s5.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s6.addCourse(courseName,courseCode,descr,format,"W2020", 0);
	   
	   // CPS643
	   list.clear();
	   courseName = "Virtual Reality";
	   courseCode = "CPS643";
	   descr = "Learn how to write extremely cool virtual reality programs";
	   format = "3Lec 2Lab";
	   list.add(s1); list.add(s2); list.add(s4); list.add(s6);
	   courses.add(new ActiveCourse(courseName,courseCode,descr,format,"W2020",list));
	   s1.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s2.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s4.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s6.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   
   }
   
   // Add new student to the registry (students arraylist above) 
   public boolean addNewStudent(String name, String id)
   {
	   // Create a new student object
	   Student newStudent = new Student(name, id);
	   // check to ensure student is not already in registry
	   	for (int i=0; i < students.size(); i++){
		   if (students.get(i).equals(newStudent)){
			   return false;
		   }
	   }
	   // if not, add them and return true, otherwise return false
	   students.add(newStudent);
	   // make use of equals method in class Student
	   return true;
   }
   // Remove student from registry 
   public boolean removeStudent(String studentId)
   {
	   // Find student in students arraylist
	   // If found, remove this student and return true
	   return false;
   }
   
   // Print all registered students
   public void printAllStudents()
   {
	   for (int i = 0; i < students.size(); i++)
	   {
		   System.out.println("ID: " + students.get(i).getId() + " Name: " + students.get(i).getName() );   
	   }
	   
   }
   
   // Given a studentId and a course code, add student to the active course
   public void addCourse(String studentId, String courseCode)
   {
	   // Find student object in registry (i.e. students arraylist)
	   // Check if student has already taken this course in the past Hint: look at their credit course list
	   // If not, then find the active course in courses array list using course code
	   // If active course found then check to see if student already enrolled in this course
	   // If not already enrolled
	   //   add student to the active course
	   //   add course to student list of credit courses with initial grade of 0
	   
	   
   }
   
   // Given a studentId and a course code, drop student from the active course
   public void dropCourse(String studentId, String courseCode)
   {
	   // Find the active course
	   // Find the student in the list of students for this course
	   // If student found:
	   //   remove the student from the active course
	   //   remove the credit course from the student's list of credit courses
	   
   }
   
   // Print all active courses
   public void printActiveCourses()
   {
	   for (int i = 0; i < courses.size(); i++)
	   {
		   ActiveCourse ac = courses.get(i);
		   System.out.println(ac.getDescription());
	   }
   }
   
   // Print the list of students in an active course
   public void printClassList(String courseCode)
   {
	  
   }
   
   // Given a course code, find course and sort class list by student name
   public void sortCourseByName(String courseCode)
   {
	   
   }
   
   // Given a course code, find course and sort class list by student name
   public void sortCourseById(String courseCode)
   {
	   
   }
   
   // Given a course code, find course and print student names and grades
   public void printGrades(String courseCode)
   {
	   
   }
   
   // Given a studentId, print all active courses of student
   public void printStudentCourses(String studentId)
   {
	   
   }
   
   // Given a studentId, print all completed courses and grades of student
   public void printStudentTranscript(String studentId)
   {
	   
   }
   
   // Given a course code, student id and numeric grade
   // set the final grade of the student
   public void setFinalGrade(String courseCode, String studentId, double grade)
   {
	   // find the active course
	   // If found, find the student in class list
	   // if found, set the grade in grades arraylist for this course
	   // then search student credit course list in student object and find course
	   // set the grade in credit course and set credit course inactive
	   
   }
  
}
