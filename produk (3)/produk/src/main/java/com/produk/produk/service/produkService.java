package com.produk.produk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produk.produk.model.produk;
import com.produk.produk.repository.produkRepository;

@Service
public class produkService {
    @Autowired
    private produkRepository produkRepository;

    public List<produk> getAllProduk() {
        return produkRepository.findAll();
    }
    public produk getProdukById(Long id) {
        return produkRepository.findById(id).orElse(null);
    }
    public produk saveProduk(produk produk) {
        return produkRepository.save(produk);
    }
    public void deleteProduk(Long id) {
        produkRepository.deleteById(id);
    }
    public produk createProduk(produk produk) {
        return produkRepository.save(produk);
    }
}