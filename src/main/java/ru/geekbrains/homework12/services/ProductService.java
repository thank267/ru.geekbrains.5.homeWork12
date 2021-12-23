package ru.geekbrains.homework12.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.geekbrains.homework12.entities.Product;
import ru.geekbrains.homework12.repositories.ProductRepository;
import ru.geekbrains.homework12.repositories.sprcifications.ProductSpecifications;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;

	public Page<Product> findAll(Integer min, Integer max, Integer page) {

		Specification<Product> spec = Specification.where(null);

		if (min != null) {
			spec = spec.and(ProductSpecifications.costGreaterThanOrEqualTo(min));
		}

		if (max != null) {
			spec = spec.and(ProductSpecifications.costLessThanOrEqualTo(max));
		}

		return productRepository.findAll(spec, PageRequest.of(page - 1, 5));

	}

	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}

	@Transactional
	public Optional<Product> deleteById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		product.ifPresent(p-> productRepository.deleteById(p.getId()));
		return product;

	}

	public Product save(Product product) {
		return productRepository.save(product);
	}

}
