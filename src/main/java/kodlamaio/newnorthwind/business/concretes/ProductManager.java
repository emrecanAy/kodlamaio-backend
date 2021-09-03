package kodlamaio.newnorthwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.newnorthwind.business.abstracts.ProductService;
import kodlamaio.newnorthwind.core.utilities.results.DataResult;
import kodlamaio.newnorthwind.core.utilities.results.Result;
import kodlamaio.newnorthwind.core.utilities.results.SuccessDataResult;
import kodlamaio.newnorthwind.core.utilities.results.SuccessResult;
import kodlamaio.newnorthwind.dataAccess.abstracts.ProductDao;
import kodlamaio.newnorthwind.entities.concretes.Product;
import kodlamaio.newnorthwind.entities.dtos.ProductWithCategoryDto;

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
		//business codes
		
		this.productDao.save(product);
		return new SuccessResult("Ürün eklendi!");
	}


	@Override
	public DataResult<Product> getByProductName(String productName) {
		//business codes
		
		return new SuccessDataResult<Product>(this.productDao.getByProductName(productName) ,"Data başarıyla listelendi!");
	}


	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		//business codes
		
		return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategory_CategoryId(productName, categoryId),"Data başarıyla listelendi!");
	}


	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		//business codes
		
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId), "Data başarıyla listelendi!");
	}


	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		//business codes
		
		return new SuccessDataResult<List<Product>>(this.productDao.getByCategory_CategoryIdIn(categories), "Data başarıyla listelendi!");
	}


	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		//business codes
		
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName), "Data başarıyla listelendi!");
	}


	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		//business codes
		
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName), "Data başarıyla listelendi!");
	}


	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		//business codes
		
		return new SuccessDataResult<List<Product>>(this.productDao.getByNameAndCategory(productName, categoryId), "Data başarıyla listelendi!");
	}


	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {   //sayfalama metodu
		//business codes
		
		Pageable pageable = PageRequest.of(pageNo-1, pageSize); // sayfalamayı 0 dan başlattığı için ilk sayfada 11.üründen başlıyordu. o yüzden -1 dedik.
		
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent(), "Data başarıyla listelendi!") ;
	}


	@Override
	public DataResult<List<Product>> getAllSorted() { // sıralama metodu
		//business codes
		
		Sort sort = Sort.by(Sort.Direction.ASC, "productName"); //a-dan zye neye göre listeleyecek. "productName"'e göre. İstersek fiyata göre de yapabiliriz. "unitPrice" diyerek
		
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort), "Data başarıyla listelendi!");
	}


	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		// business codes
		return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productDao.getProductWithCategoryDetails(), "Data başarıyla listelendi!");
	}
	
	
	
	
	
	
	

	
	
}
