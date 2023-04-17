package com.example.projet_pfa.dao;

import java.util.List;

public interface Dao <T> {
    T save (T o);
    List<T> findAll();
    T findById(int id);

    void delete(T o);
}
