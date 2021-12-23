package ru.geekbrains.homework12.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.homework12.dto.UserDtoSuperAdmin;

import javax.persistence.*;
import java.util.Collection;
import java.util.stream.Collectors;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@ManyToMany
	@JoinTable(name = "users_roles",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Collection<Role> roles;

	public User(UserDtoSuperAdmin userDto) {
		id = userDto.getId();
		username = userDto.getUsername();
		password = userDto.getPassword();
		email = userDto.getEmail();
		roles = userDto.getRoles().stream().map(Role::new).collect(Collectors.toList());
	}
}
