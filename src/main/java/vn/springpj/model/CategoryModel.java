package vn.springpj.model;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryModel {
	@Id
	private Long categoryId;
	@NotEmpty(message="Ten khong duoc de trong")
	private String name;
	
	boolean isEdit = false;
}
