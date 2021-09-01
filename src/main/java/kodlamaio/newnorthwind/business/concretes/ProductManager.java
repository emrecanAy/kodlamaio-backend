package kodlamaio.newnorthwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.newnorthwind.business.abstracts.ProductService;
import kodlamaio.newnorthwind.core.utilities.results.DataResult;
import kodlamaio.newnorthwind.core.utilities.results.Result;
import kodlamaio.newnorthwind.core.utilities.results.SuccessDataResult;
import kodlamaio.newnorthwind.core.utilities.results.SuccessResult;
import kodlamaio.newnorthwind.dataAccess.abstracts.ProductDao;
import kodlamaio.newnorthwind.entities.concretes.Product;

@Service
public class ProductManager implements ProductService {
	
	private ProductDao productDao;
	
	@Autowired 
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}


	@Override
	public DataResult<List<Product>> getAll() {
		
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(), "Data listelendi!");
		//this.productDao.findAll(), SuccessDataResult'ın ctorundaki data'ya karşılık geliyor. data listelendi ise message' karşılık geliyor.
		//successdataresult oldugu için otomatik true alıyor.
		//eğer success ve error olarak ayrı ayrı yazmasaydık burada true, false girmemiz gerekecekti.
		//o da bazen yanlışlık yapıp true yerine false veya tam tersi yazmamıza sebep olabilirdi. 
				
				
	}


	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Ürün eklendi!");
	}
	
	

	
	
}
