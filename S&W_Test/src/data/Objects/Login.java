package data.Objects;

public class Login{

	private String DD_ID;
	private String testCase;
	private String username;
	private String password;
	private Boolean rememberMe;
	private String expectedResult;
	private String actualResult;
	
	public Login(String DD_ID) {
		this.DD_ID = DD_ID;
	}
	
	public String getDD_ID() {
		return DD_ID;
	}
	public String getTestCase() {
		return testCase;
	}
	public void setTestCase(String testCase) {
		this.testCase = testCase;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getRememberMe() {
		return rememberMe;
	}
	public void setRememberMe(String rememberMe) {
		if(rememberMe.equals("YES")) {
			this.rememberMe = true;
		}else {
			this.rememberMe = false;
		}
	}
	public String getExpectedResult() {
		return expectedResult;
	}
	public void setExpectedResult(String expectedResult) {
		this.expectedResult = expectedResult;
	}
	public String getActualResult() {
		return actualResult;
	}
	public void setActualResult(String actualResult) {
		this.actualResult = actualResult;
	}
	
	
	
}
