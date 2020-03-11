public class CreditCourse extends Course
{
	private boolean active;
	private String semester;
	private Double grade;
	// add a constructor method with appropriate parameters
	// should call the super class constructor
	public CreditCourse(String name, String code, String descr, String fmt,String semester, Double grade)
	{
		// add code
		super(name,code,descr,fmt);
		this.semester = semester;
		this.grade = grade;
	}
	// returns current course grade
	public Double getGrade(){
		return grade;
	}

	public boolean getActive()
	{
		return active;
	}
	
	public void setActive()
	{
		active = true;
	}
	
	public void setInactive()
	{
		active = false;
	}

	// sets the final grade for this course
	public void setGrade(double grade){
		this.grade=grade;
	}

	public String displayGrade()
	{
		// Change line below and print out info about this course plus which semester and the grade achieved
		// make use of inherited method in super class
		return super.getDescription() + " " + semester + " "+ super.convertNumericGrade(grade);
	}
	
}