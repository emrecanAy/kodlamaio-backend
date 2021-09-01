package kodlamaio.newnorthwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.newnorthwind.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{

	
	
}
