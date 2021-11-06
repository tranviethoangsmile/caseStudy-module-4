package com.codegym.service;

import com.codegym.entity.TableDinner;
import com.codegym.repository.TableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TableService implements ITableService{
    @Autowired
    TableRepo tableRepo;

    @Override
    public Iterable<TableDinner> findAll() {
        return tableRepo.findAll();
    }

    @Override
    public Optional<TableDinner> findById(Long id) {
        return tableRepo.findById(id);
    }

    @Override
    public TableDinner save(TableDinner tableDinner) {
        return tableRepo.save(tableDinner);
    }

    @Override
    public void remove(Long id) {

    }
}
