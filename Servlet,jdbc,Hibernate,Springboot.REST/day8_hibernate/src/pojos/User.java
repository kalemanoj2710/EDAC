package pojos;

import java.time.LocalDate;
import javax.persistence.*;
//pojo property must be serializable

@Entity // mandatory
@Table(name = "users_tbl")
public class User {
	private Integer userId;
	private String name, email, password;
	private Role userRole;
	private String confirmPassword;
	private double regAmount;
	private LocalDate regDate;
	private byte[] image;

	public User() {
		System.out.println("in user constructor");
	}

	public User(Integer userId, String name, String email, String password, Role userRole, String confirmPassword,
			double regAmount, LocalDate regDate) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.userRole = userRole;
		this.confirmPassword = confirmPassword;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}

	@Id // mandatory for pk contraint
//	@GeneratedValue //automatic id generationby hibernate: native DB scheme
	@GeneratedValue(strategy = GenerationType.IDENTITY) // automatic id generationby hibernate: auto_increment (best
	@Column(name = "user_id") // suited for mysql db)
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(length = 20) // varchar(20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 20, unique = true) // unique constraint
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 20, nullable = false) // not null constrint
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Enumerated(EnumType.STRING) // varchar=>constant name
	@Column(length = 30, name = "user_role")
	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}

	@Transient // skipped from persistence(no column generationfor this property)
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Column(name = "reg_amount")
	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	@Column(name = "reg_date")
	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	@Lob // large object => mysql:col type longblob
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", userRole=" + userRole + ", confirmPassword=" + confirmPassword + ", regAmount=" + regAmount
				+ ", regDate=" + regDate + "]";
	}

}
