package Model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//значения столбца будет сгенерировано с помощью базы данных
	@Column(name = "id")
	private Long id;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "middleName")
	private String middleName;
	
	@Column(name = "login")
	private String login /*= "admin"*/;
	
	@Column(name = "password")
	private String password/* = "root"*/;
	
	@Column(name = "mobileTelephone")
	private String mobileTelephone;
	
	@Column(name = "email")
	private String email;
	
	/*@OneToMany(mappedBy = "user")
	 * @JoinColumn(name="users")
	private Set<Result> results;*/ //не реализованно
	
	@Column(name = "date_reg")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUserReg;//тест не реализованно
	
	public User(){
		
	}
	
	public User(String surname,String name,String middleName,String login,String password,String mobileTelephone,String email){
		this.surname = surname;
		this.name = name;
		this.middleName = middleName;
		this.login = login;
		this.password = password;
		this.mobileTelephone = mobileTelephone;
		this.email = email;
	}
	

	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getMobileTelephone() {
		return mobileTelephone;
	}


	public void setMobileTelephone(String mobileTelephone) {
		this.mobileTelephone = mobileTelephone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateUserReg() {
		return dateUserReg;
	}

	public void setDateUserReg(Date dateUserReg) {
		this.dateUserReg = dateUserReg;
	}
	

}
