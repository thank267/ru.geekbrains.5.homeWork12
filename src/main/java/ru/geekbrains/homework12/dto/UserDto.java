package ru.geekbrains.homework12.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.geekbrains.homework12.entities.User;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class UserDto {

	private Long id;

	private String username;

	private String email;

	public UserDto(User user) {
		id = user.getId();
		username = user.getUsername();
		email = user.getEmail();
	}

}
