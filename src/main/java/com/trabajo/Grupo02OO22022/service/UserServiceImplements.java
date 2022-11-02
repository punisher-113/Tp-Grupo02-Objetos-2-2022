package com.trabajo.Grupo02OO22022.service;

import java.util.List;

import com.trabajo.Grupo02OO22022.entity.User;
import com.trabajo.Grupo02OO22022.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier("userService")
@Service
public class UserServiceImplements implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> listarTodos() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public List<User> listarActivos() {
        return (List<User>) userRepository.findByEnabledTrue();
    }

    @Override
    public void guardar(User user) {
        userRepository.save(user);
    }

    @Override
    public User buscarPorID(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(long id) {
        userRepository.deleteById(id);
    }

}
