package com.codegym.service;

import com.codegym.entity.Staff;
import com.codegym.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StaffService implements IStaffService {
    @Autowired
    StaffRepository staffRepository;

    @Override
    public Iterable<Staff> findAll() {
       return staffRepository.findAll();
    }

    @Override
    public Optional<Staff> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Staff save(Staff staff) {
       return staffRepository.save(staff);
    }


    @Override
    public void remove(Long id) {

    }


}
