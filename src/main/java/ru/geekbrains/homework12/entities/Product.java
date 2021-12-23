package ru.geekbrains.homework12.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.homework12.dto.ProductDto;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title", length = 250, nullable = false, unique = false)
	private String title;

	@Column(name = "cost", nullable = false, unique = false)
	private int cost;

	public Product(ProductDto productDto) {
		id = productDto.getId();
		title = productDto.getTitle();
		cost = productDto.getCost();
	}

}
