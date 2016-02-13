package Model;

public class User {
	
	private String surname;
	private String name;
	private String middleName;
	private String login;
	private String password;
	private String mobileTelephone;
	private String email;
	
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
	
	

}
