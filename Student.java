import java.util.ArrayList;

// Make class Student implement the Comparable interface
// Two student objects should be compared by their name
public class Student
{
  private String name;
  private String id;
  public  ArrayList<CreditCourse> courses; // weird 
  
  
  public Student(String name, String id)
  {
	 this.name = name;
	 this.id   = id;
	 courses   = new ArrayList<CreditCourse>();
  }
  
  public String getId()
  {
	  return id;
  }
  
  public String getName()
  {
	  return name;
  }
  
  // given a courseCode it returns a student's grade from creditCourse
  public Double getGrade(String courseCode){
    for(int i=0; i< courses.size(); i++){
      if (courseCode.equalsIgnoreCase(courses.get(i).getCode()))
      {
        return courses.get(i).getGrade();
      }
    }
    return 0.0;
  }

  public void addCourse(String courseName, String courseCode, String descr, String format,String sem, double grade)
  {
    // create a CreditCourse object
    CreditCourse newObj = new CreditCourse(courseName,courseCode,descr,format,sem,grade);
    // set course active
    newObj.setActive();
    // add to courses array list
    courses.add(newObj);
  }

  // Prints a student transcript
  // Prints all completed (i.e. non active) courses for this student (course code, course name, 
  // semester, letter grade
  // see class CreditCourse for useful methods
  public void printTranscript()
  {
	  for (int i=0; i < courses.size();i++){
      if (courses.get(i).getActive() == false){
        System.out.println(courses.get(i).displayGrade());
      }
    }
  }
  
  // Prints all active courses this student is enrolled in
  // see variable active in class CreditCourse
  public void printActiveCourses()
  {
    for (int i=0; i < courses.size();i++){
      if (courses.get(i).getActive() == true){
        System.out.println(courses.get(i).displayGrade());
      }
    }
  }
  
  // Drop a course (given by courseCode)
  // Find the credit course in courses arrayList above and remove it
  // only remove it if it is an active course
  public void removeActiveCourse(String courseCode) 
  {
    for (int i=0; i < courses.size();i++){ // test i am not sure <--------------
      if (courses.get(i).getCode().equals(courseCode) && courses.get(i).getActive() == true){
        courses.remove(i);
      }
    }
  }
  
  public String toString()
  {
	  return "Student ID: " + id + " Name: " + name;
  }
  
  // override equals method inherited from superclass Object
  // if student names are equal *and* student ids are equal (of "this" student
  // and "other" student) then return true
  // otherwise return false
  // Hint: you will need to cast other parameter to a local Student reference variable
  public boolean equals(Object other)
  {
    if (name.equals(((Student) other).getName()) && id.equals(((Student) other).getId())) {
      return true;
    }
	  return false;
  }

  // checks if a course is in courses list (true = taken and false = not taken)
  public boolean CourseTakenCheck(String courseCode){
    for (int i=0;i < courses.size();i++){
      if ((courses.get(i).getCode()).equalsIgnoreCase(courseCode))
        return true;
    }
    return false;
  }
  // sets a final grade for a specified course using creditCourse.setGrade()
  // sets the course as inactive
  public void setFinalGrade(String courseCode, double grade){
    for (int i=0; i < courses.size();i++){
      if (courses.get(i).getCode().equalsIgnoreCase(courseCode)){
        courses.get(i).setGrade(grade);
        courses.get(i).setInactive();
      }
    }
  }
}
