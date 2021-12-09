package com.CTDECommerce.ECommerce.service;

import java.util.List;


public interface ECommerceService <T>{

    List<T> findAll();
     T findById(Long id);
}
