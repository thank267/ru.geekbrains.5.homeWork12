package ru.geekbrains.homework12.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.geekbrains.homework12.entities.User;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDtoSuperAdmin {

	private Long id;

	private String username;

	private String email;

	private String password;

	private List<RoleDto> roles;

	public UserDtoSuperAdmin(User user) {
		id = user.getId();
		username = user.getUsername();
		email = user.getEmail();
		password = user.getPassword();
		roles = user.getRoles().stream().map(RoleDto::new).collect(Collectors.toList());
	}

}
