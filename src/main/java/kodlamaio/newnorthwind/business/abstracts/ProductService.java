package kodlamaio.newnorthwind.business.abstracts;

import java.util.List;


import kodlamaio.newnorthwind.core.utilities.results.DataResult;
import kodlamaio.newnorthwind.core.utilities.results.Result;
import kodlamaio.newnorthwind.entities.concretes.Product;
import kodlamaio.newnorthwind.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
	
	DataResult<List<Product>> getAll();
	
	DataResult<List<Product>> getAll(int pageNo, int pageSize); //sayfalama yapıyoruz. sayfa sayısı ve bir sayfada kaç data var.
	
	DataResult<List<Product>> getAllSorted(); // sıralamalı yapıyoruz.
	
	Result add(Product product);
	
	DataResult<Product> getByProductName(String productName);
 	
	DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);

	DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);
	 
	DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);
	 
	DataResult<List<Product>> getByProductNameContains(String productName); 
	 
	DataResult<List<Product>> getByProductNameStartsWith(String productName);

	DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);
	
	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(); 
	
	
	
	
	

}
