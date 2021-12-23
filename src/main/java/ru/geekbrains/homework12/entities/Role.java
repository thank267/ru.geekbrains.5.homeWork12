package ru.geekbrains.homework12.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.homework12.dto.RoleDto;

import javax.persistence.*;

@Entity
@Data
@Table(name = "roles")
@NoArgsConstructor
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	public Role(RoleDto roleDto) {
		id = roleDto.getId();
		name = roleDto.getName();
	}
}
