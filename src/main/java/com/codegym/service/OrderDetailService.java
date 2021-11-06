package com.codegym.service;

import com.codegym.entity.OrderDetail;
import com.codegym.repository.OrderdetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderDetailService implements IOrderDetailService{
    @Autowired
    OrderdetailRepo orderdetailRepo;
    @Override
    public Iterable<OrderDetail> findAll() {
        return orderdetailRepo.findAll();
    }

    @Override
    public Iterable<OrderDetail> findAllByTableId(Long id) {
      return orderdetailRepo.findAllOrder();
    }

    @Override
    public Optional<OrderDetail> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public OrderDetail save(OrderDetail orderDetail) {
        return orderdetailRepo.save(orderDetail);
    }

    @Override
    public void remove(Long id) {

    }
}
