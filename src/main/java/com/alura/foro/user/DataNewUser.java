package com.alura.foro.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DataNewUser(
		@NotBlank(message = "Nombre es obligatorio") String nombre,
		@NotBlank(message = "Email es obligatorio") @Email(message = "Formato de email es inválido") String email,
		@NotBlank(message = "Contrasena es obligatorio") String contrasena) {

}
