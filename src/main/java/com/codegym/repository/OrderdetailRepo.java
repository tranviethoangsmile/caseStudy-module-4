package com.codegym.repository;

import com.codegym.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderdetailRepo extends JpaRepository <OrderDetail, Long> {
   @Query("SELECT o FROM OrderDetail AS o WHERE o.table_id = :id")
    List <OrderDetail> findAllOrder ();
}
