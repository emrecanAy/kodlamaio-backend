package kodlamaio.newnorthwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.newnorthwind.entities.concretes.Product;
import kodlamaio.newnorthwind.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product, Integer>{
	
	 Product getByProductName(String productName); //bu isimlendirme kuralıyla get by'ı görünce otomatik where koşulu yapıyor.
	 	
	 Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

	 List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
	 
	 List<Product> getByCategory_CategoryIdIn(List<Integer> categories); // in(1,2,3) örneğin kategori id'si 1,2,3 olanları getir demek. Sayı listesi olacağı için list olarak tanımladık(array de olabilir farketmez) ve categories dedik.
	 
	 List<Product> getByProductNameContains(String productName); //product name içeriyorsa getir.
	 
	 List<Product> getByProductNameStartsWith(String productName);
	 
	 @Query("From Product where productName=:productName and category.categoryId=:categoryId")
	 List<Product> getByNameAndCategory(String productName, int categoryId);
	 //Select * from products where product_name=birsey and categoryId=birsey olarak sql yazabilirdik.
	 
	 @Query("Select new kodlamaio.newnorthwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) From Category c Inner Join c.products p")
	 List<ProductWithCategoryDto> getProductWithCategoryDetails(); 
	 
	 //select (p.productId, p.productName, c.categoryName) from Category c inner join Product p on c.categoryId = p.categoryId 
}
