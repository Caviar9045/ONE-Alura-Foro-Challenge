package com.alura.foro.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.alura.foro.modelo.Usuario;

import at.favre.lib.crypto.bcrypt.BCrypt;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void saveUserWithEncryptedPassword(Usuario user) {
        String rawPassword = user.getPassword();
        String encodedPassword = BCrypt.withDefaults().hashToString(10, rawPassword.toCharArray());
        user.setContrasena(encodedPassword);
        userRepository.save(user);
    }
    public String getEcryptedPassword(String rawPassword) {
    	String encodedPassword = BCrypt.withDefaults().hashToString(10, rawPassword.toCharArray());
        return encodedPassword;
    }
}
