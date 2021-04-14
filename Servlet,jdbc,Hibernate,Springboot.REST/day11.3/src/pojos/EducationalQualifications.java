package pojos;
import javax.persistence.*;

@Embeddable
public class EducationalQualifications {
	@Enumerated(EnumType.STRING)
	@Column(name="edu_type",length = 30)
	private EduType eduType;
	private int year;
	private int marks;
	public EducationalQualifications() {
		// TODO Auto-generated constructor stub
	}
	public EducationalQualifications(EduType eduType, int year, int marks) {
		super();
		this.eduType = eduType;
		this.year = year;
		this.marks = marks;
	}
	public EduType getEduType() {
		return eduType;
	}
	public void setEduType(EduType eduType) {
		this.eduType = eduType;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "EducationalQualifications [eduType=" + eduType + ", year=" + year + ", marks=" + marks + "]";
	}
	
}
