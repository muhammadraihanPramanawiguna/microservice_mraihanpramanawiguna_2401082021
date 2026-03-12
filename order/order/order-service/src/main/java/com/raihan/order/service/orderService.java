package com.raihan.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raihan.order.model.order;
import com.raihan.order.repository.orderRepository;

@Service
public class orderService {
    @Autowired
    private orderRepository orderRepository;

    public List<order> getAllOrder() {
        return orderRepository.findAll();
    }

    public order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public order createOrder(order o) {
        o.setTotal(o.getHarga() * o.getJumlah());
        return orderRepository.save(o);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}