package lk.caffeine.center_1.service;

import java.util.List;

/**
 * Author: shan
 * Created: 1/15/24 10:49 PM
 */
public interface SuperService<T,U> {
    boolean save(T dto);

    boolean update(T dto);

    boolean delete(U id);

    T search(U id);

    List<T> getAll();
}
