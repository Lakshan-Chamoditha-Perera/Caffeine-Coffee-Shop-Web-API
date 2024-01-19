package com.caffeine.center_2.service;

import java.util.List;

/**
 * Author: shan
 * Created: 1/20/24 12:01 AM
 */
public interface SuperService<T, V> {
    T save(T dto);

    Boolean update(T dto);

    Boolean delete(V id);

    T findById(V id);

    List<T> findAll();
}
