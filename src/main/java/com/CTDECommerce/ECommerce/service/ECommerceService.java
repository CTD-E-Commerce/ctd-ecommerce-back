package com.CTDECommerce.ECommerce.service;

import java.util.List;


public interface ECommerceService <T>{
    T salvar(T t);
    List<T> buscarTodos();
     T buscarPorId(Long id);
}
