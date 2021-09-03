package kodlamaio.newnorthwind.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductWithCategoryDto {
	
	private int id;
	
	private String productName;
	 							   // iki tabloya join atarak bu işi yapacağız.
	private String categoryName;

}
