package ru.geekbrains.homework12.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.homework12.dto.ProductDto;
import ru.geekbrains.homework12.entities.Product;
import ru.geekbrains.homework12.exceptions.ResourceNotFoundException;
import ru.geekbrains.homework12.services.ProductService;

import javax.validation.constraints.PositiveOrZero;

@RestController
@RequestMapping("/products/v1")
@AllArgsConstructor
@Slf4j
@Validated
public class ProductController {

	private final ProductService service;

	@GetMapping
	public Page<ProductDto> index(
			@RequestParam(defaultValue = "0") @PositiveOrZero() Integer min,
			@RequestParam(defaultValue = Integer.MAX_VALUE + "") @PositiveOrZero() Integer max,
			@RequestParam(defaultValue = "1") Integer page) {
		if (page<1) page=1;
		return service.findAll(min, max, page).map(ProductDto::new);
	}

	@GetMapping("/{id}")
	public ProductDto findById(@PathVariable("id") Long id) {
		return service.findById(id).map(ProductDto::new)
				.orElseThrow(() -> new ResourceNotFoundException("Product Not Found id: "+ id ));

	}

	@PostMapping( consumes = "application/json", produces = "application/json")
	public ProductDto save(@RequestBody ProductDto productDto) {
		productDto.setId(null);
		return new ProductDto(service.save(new Product(productDto)));
	}

	@PutMapping(value="/{id}", consumes = "application/json", produces = "application/json")
	public ProductDto update(@RequestBody ProductDto productDto) {
		return new ProductDto(service.save(new Product(productDto)));

	}

	@DeleteMapping("/{id}")
	public ProductDto delete(@PathVariable("id") long id) {
		return service.deleteById(id).map(ProductDto::new)
				.orElseThrow(() -> new ResourceNotFoundException("Unable delete Product by id: "+ id ));

	}
}
