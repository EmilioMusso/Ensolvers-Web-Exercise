package com.exercise.todo.repo;

import java.util.Optional;

import com.exercise.todo.model.Item;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item, Long> {

    void deleteItemById(Long id);

    Item findItemById(Long id);

    
}
