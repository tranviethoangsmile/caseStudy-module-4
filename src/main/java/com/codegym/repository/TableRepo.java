package com.codegym.repository;

import com.codegym.entity.TableDinner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepo extends JpaRepository<TableDinner, Long> {
}
