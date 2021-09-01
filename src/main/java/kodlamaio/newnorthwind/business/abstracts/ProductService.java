package kodlamaio.newnorthwind.business.abstracts;

import java.util.List;

import kodlamaio.newnorthwind.core.utilities.results.DataResult;
import kodlamaio.newnorthwind.core.utilities.results.Result;
import kodlamaio.newnorthwind.entities.concretes.Product;

public interface ProductService {
	
	DataResult<List<Product>> getAll();
	Result add(Product product);
	
	

}
