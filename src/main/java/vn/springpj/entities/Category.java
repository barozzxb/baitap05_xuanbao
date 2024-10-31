package vn.springpj.entities;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Categories")
public class Category implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryId;
	
	@Column(name = "category_name", length = 200, columnDefinition = "nvarchar(200) not null")
	private String name;
	
//	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
//	private Set<Product> products;
}
