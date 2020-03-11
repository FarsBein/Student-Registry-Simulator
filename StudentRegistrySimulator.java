import java.util.ArrayList;
import java.util.Scanner;

public class StudentRegistrySimulator 
{
  public static void main(String[] args)
  {
	  Registry registry = new Registry();
	//   System.out.println(registry.addNewStudent("SophieBrown", "98345"));
	  Scanner scanner = new Scanner(System.in);
	  System.out.print(">");
	  
	  while (scanner.hasNextLine())
	  {
		  String inputLine = scanner.nextLine();
		  if (inputLine == null || inputLine.equals("")) continue;
		  
		  Scanner commandLine = new Scanner(inputLine);
		  String command = commandLine.next();
		  
		  if (command == null || command.equals("")) continue;
		  
		  else if (command.equalsIgnoreCase("L") || command.equalsIgnoreCase("LIST"))
		  {
			  registry.printAllStudents();
		  }
		  else if (command.equalsIgnoreCase("Q") || command.equalsIgnoreCase("QUIT"))
			  return;
		  
		  else if (command.equalsIgnoreCase("REG"))
		  {
			  // register a new student in registry
			  // get name and student id string 
			  // e.g. reg JohnBoy 74345
			  // Checks:
			  //  ensure name is all alphabetic characters
			  //  ensure id string is all numeric characters
			  String studentName = commandLine.next();
			  String studentId = commandLine.next();
			  if (isStringOnlyAlphabet(studentName)&&isNumeric(studentId)&&!registry.StudentInRegistry(studentId)){
				registry.addNewStudent(studentName, studentId);
			  }
		  }
		  else if (command.equalsIgnoreCase("DEL"))
		  {
			  // delete a student from registry
			  // get student id
			  // ensure numeric
			  // remove student from registry
			  String studentId = commandLine.next();
			  if (isNumeric(studentId)){
				registry.removeStudent(studentId);
			  }
		  }
		  
		  else if (command.equalsIgnoreCase("ADDC"))
		  {
			 // add a student to an active course
			 // get student id and course code strings
			 // add student to course (see class Registry)
			 String studentId = commandLine.next();
			 String courseCode = commandLine.next();
			 registry.addCourse(studentId, courseCode);
		  }
		  else if (command.equalsIgnoreCase("DROPC"))
		  {
			  // get student id and course code strings
			  // drop student from course (see class Registry)
			  String studentId = commandLine.next();
			  String courseCode = commandLine.next();
			  registry.dropCourse(studentId, courseCode);
		  }
		  else if (command.equalsIgnoreCase("PAC"))
		  {
			  // print all active courses
			  registry.printActiveCourses();
		  }		  
		  else if (command.equalsIgnoreCase("PCL"))
		  {
			  // get course code string
			  // print class list (i.e. students) for this course
			  String courseCode = commandLine.next(); 
			  registry.printClassList(courseCode);
		  }
		  else if (command.equalsIgnoreCase("PGR"))
		  {
			  // get course code string
			  // print name, id and grade of all students in active course
			  String courseCode = commandLine.next();
			  registry.printGrades(courseCode);
		  }
		  else if (command.equalsIgnoreCase("PSC"))
		  {
			  // get student id string
			  // print all credit courses of student
			  String studentId = commandLine.next();
			  registry.printStudentCourses(studentId);
		  }
		  else if (command.equalsIgnoreCase("PST"))
		  {
			  // get student id string
			  // print student transcript
			  String studentId = commandLine.next();
			  registry.printStudentTranscript(studentId);
		  }
		  else if (command.equalsIgnoreCase("SFG"))
		  {
			  // set final grade of student
			  // get course code, student id, numeric grade
			  // use registry to set final grade of this student (see class Registry)
			  String courseCode = commandLine.next();
			  String studentId = commandLine.next();
			  double grade;
			  if (commandLine.hasNextDouble()){
				  grade = commandLine.nextDouble();
			  } else {
				  grade = (double)commandLine.nextInt();
			  }
			  registry.setFinalGrade(courseCode, studentId, grade);
		  }
		  else if (command.equalsIgnoreCase("SCN"))
		  {
			  // get course code
			  // sort list of students in course by name (i.e. alphabetically)
			  // see class Registry
			  String courseCode = commandLine.next();
			  registry.sortCourseByName(courseCode);
		  }
		  else if (command.equalsIgnoreCase("SCI"))
		  {
			// get course code
			// sort list of students in course by student id
			// see class Registry
			String courseCode = commandLine.next();
			registry.sortCourseById(courseCode);
		  }
		  System.out.print("\n>");
	  }
  }
  
  private static boolean isStringOnlyAlphabet(String str) 
  { 
      // write method to check if string str contains only alphabetic characters 
	  for (int i=0; i < str.length();i++){
		if (Character.isDigit(str.charAt(i))){
			  System.out.println("Invalid characters in student name: "+str);
			  return false;
		}
	}
	  return true;
  } 
  
  public static boolean isNumeric(String str)
  {
      // write method to check if string str contains only numeric characters
	  for (int i=0; i < str.length();i++){
		if (!Character.isDigit(str.charAt(i))){
			  System.out.println("Invalid characters in student ID: "+str);
			  return false;
		}
	  } 
	  return true;
	}
}
