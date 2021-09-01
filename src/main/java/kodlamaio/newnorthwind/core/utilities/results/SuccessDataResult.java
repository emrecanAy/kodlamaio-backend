package kodlamaio.newnorthwind.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T>{

	public SuccessDataResult(T data, String message) {
		super(data, true, message);
	}
	
	public SuccessDataResult(T data) {
		super(data, true);
	}
	
	public SuccessDataResult(String message) {
		super(null, true, message);
	}
	
	public SuccessDataResult() {
		super(null, true); // son iki ctor'u keyfi olarak ekledik. neler yapabildiğimizi göstermek için.
						   // data istemeyip mesaj ve true bilgisi alabiliriz. istersek sadece true bilgisi alabiliriz vs.
						   // backendci olarak kullanıcılara bir sürü imkan veriyoruz. isteyen istediğini kullanabilir.
		
	}
	
	
	

}
