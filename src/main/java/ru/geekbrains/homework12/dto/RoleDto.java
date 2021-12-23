package ru.geekbrains.homework12.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.geekbrains.homework12.entities.Role;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class RoleDto {

	private Long id;

	private String name;

	public RoleDto(Role role) {
		id = role.getId();
		name = role.getName();
	}

}
