package kodlamaio.newnorthwind.core.utilities.results;

public class DataResult<T> extends Result{
	
	private T data;

	public DataResult(T data, boolean success, String message) {
		super(success, message);  //ctordaki success ve message bilgisini super ile baseclasstan alıyoruz.		
		this.data = data;							
		// TODO Auto-generated constructor stub
		// T dememizin sebebi data'da döndüreceğiz.
		// Fakat data birçok farklı türde olabilir.(ürün, ürün listesi, kategori, employee vs vs.)
		// yani her veri tipi olabilir. Dolayısıyla birden fazla veritipiyle çalışabildiğimiz noktada
		// generic çalışırız. dolayısıyla T'yi ekledik. ve ctor'da geriye döndürdük.
	}	
	
	public DataResult(T data, boolean success) {  //message geçmek istemezsek bunu kullanırız.
		super(success);  
		this.data = data;							
		
	}	
	
	public T getData() {
		return this.data;
	}

	

	
	
	

}
