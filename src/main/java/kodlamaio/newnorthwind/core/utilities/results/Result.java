package kodlamaio.newnorthwind.core.utilities.results;

public class Result {

	private boolean success;
	private String message;
	
	public Result(boolean success) {
		this.success = success;
	}
	
	public Result(boolean success, String message) {
		this(success);  //this.success; yazıyordu fakat do not repeat yourself kuralı gereği böyle yazdık. Yani bu class'ın tek parametreli ctor'unu çağırmış oluyor(bkz: bir üstteki ctor). o da bize success döndürüyor. 
		this.message = message;
	}
	
	public boolean isSuccess() {
		return this.success;
	}
	
	public String getMessage() {
		return this.message;
	}
}
