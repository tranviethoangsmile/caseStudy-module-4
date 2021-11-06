package com.codegym.service;

import com.codegym.entity.Role;
import com.codegym.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RoleService implements IRoleService{
    @Autowired
    RoleRepository roleRepository;
    @Override
    public Iterable<Role> findAll() {
        return null;
    }

    @Override
    public Optional<Role> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Role save(Role role) {
       Role roleResp = roleRepository.save(role);
       return roleResp;
    }

    @Override
    public void remove(Long id) {

    }
}
