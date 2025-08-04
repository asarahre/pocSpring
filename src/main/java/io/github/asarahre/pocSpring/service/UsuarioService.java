package io.github.asarahre.pocSpring.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.github.asarahre.pocSpring.model.Usuario;
import io.github.asarahre.pocSpring.repository.UsuarioRepository;
import io.github.asarahre.pocSpring.security.JwtUtil;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario registrarUsuario(String username, String password) {
        String senhaCriptografada = this.passwordEncoder.encode(password);
        Usuario usuario = new Usuario(username, senhaCriptografada);
        return this.usuarioRepository.save(usuario);
    }

    public Map<String, String> login(String username, String passwordDescript) {

        Optional<Usuario> usuario = buscarPorUsername(username);

        if (usuario.isPresent() && passwordEncoder.matches(passwordDescript, usuario.get().getPassword())) {
            String token = JwtUtil.generateToken(usuario.get().getUsername());
            return Map.of("token", token);
        } else {
            return null;
        }

    }

    public Optional<Usuario> buscarPorUsername(String username) {
        return this.usuarioRepository.findByUsername(username);
    }
}
