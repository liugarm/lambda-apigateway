


public class Request {
	
	private String httpMethod;
	
	private int id;
	
	private Consumption consumption;
	
	public String getHttpMethod() {
		return httpMethod;
	}
	
	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Consumption getConsumption() {
		return consumption;
	}
	
	public void setConsumption (Consumption consumption) {
		this.consumption = consumption;
	}
}
