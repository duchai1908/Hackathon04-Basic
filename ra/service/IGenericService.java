package Basic.HN_JV240408_BS_NguyenDucHai.ra.service;

import java.util.List;

public interface IGenericService<T, E> {
    List<T> getAll();

    void save(T t);

    T findById(E e);

    void delete(E e);
}
