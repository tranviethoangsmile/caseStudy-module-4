package com.codegym.service;

import com.codegym.entity.OrderDetail;

public interface IOrderDetailService extends IGeneralService <OrderDetail>{
    public Iterable<OrderDetail> findAllByTableId(Long id);
}
