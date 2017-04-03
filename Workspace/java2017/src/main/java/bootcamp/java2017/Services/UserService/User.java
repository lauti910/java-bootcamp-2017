package bootcamp.java2017.Services.UserService;

public class User {
	
	private String username;
	private String password;
	private String email;
	private String fullName;
	private Integer cardNumber;
	
	
	public User(String username, String password){
		this.username = username;
		this.password = password;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	public String getPassword() {
		return this.password;
	}

	public String getEmail() {
		return this.email;
	}

	public String getUsername() {
		return this.username;
	}

	public String getName() {
		return this.fullName;
	}
	public void setName(String fullName){
		this.fullName = fullName;
	}
	
	public void setCardNumber(Integer cardNumber){
		this.cardNumber = cardNumber;
	}

	public Integer getCardNumber() {
		return this.cardNumber;
	}

}
