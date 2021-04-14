package pojos;
//id (inherited from BaseEntity super cls) , title,start date end  date , fees , capacity +List<Student>

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "courses_tbl")
public class Course extends BaseEntity {
	@Column(length = 30)
	private String title;
	@Temporal(TemporalType.DATE) // not required for LocalDate
	@Column(name = "start_date")
	private Date startDate;
	@Temporal(TemporalType.DATE) // not required for LocalDate
	@Column(name = "end_date")
	private Date endDate;
	private double fees;
	private int capacity;
	// one to many association
	// value of the mappedBy : name of the property as it appears in the owning
	// side.
	@OneToMany(mappedBy = "selectedCourse", cascade = CascadeType.ALL,
			orphanRemoval = true/* ,fetch=FetchType.EAGER */)
	private List<Student> students = new ArrayList<>();

	// def constr
	public Course() {
		System.out.println("in course ctor");
	}

	public Course(String title, Date startDate, Date endDate, double fees, int capacity) {
		super();
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fees = fees;
		this.capacity = capacity;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	// tip : to avoid recursion : NEVER add any asso based property in toString
	@Override
	public String toString() {
		return "Course [title=" + title + ", startDate=" + startDate + ", endDate=" + endDate + ", fees=" + fees
				+ ", capacity=" + capacity + "]";
	}
	// add helper methods, in case of bi dir asso , for establishing a link between
	// parent-->child n child -->parent  : NOT mandatory BUT recommended
	public void addStudent(Student s)
	{
		students.add(s);//parent ---> child
		s.setSelectedCourse(this);//child ---> parent
	}
	public void removeStudent(Student s)
	{
		students.remove(s);//parent - --- X    --> child
		s.setSelectedCourse(null);//child --X  ----> parent
	}
	
	

}
