package com.exercise.todo.service;

import java.util.List;

import com.exercise.todo.model.Item;
import com.exercise.todo.repo.ItemRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemRepo itemRepo;

    @Autowired
    public ItemService(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    public Item createItem(Item item) {
        return itemRepo.save(item);
    }

    public Item editItem(Item item) {
        return itemRepo.save(item);
    }

    public void deleteItem(Item item) {
        itemRepo.delete(item);
    }

    public void deleteItem(Long id) {
        itemRepo.deleteItemById(id);
    }

    public List<Item> findAllItems() {
        return itemRepo.findAll();
    }

    public Item findItemById(Long id) {
        return itemRepo.findItemById(id);
    }

    public Item updateItem(Item item) {
        return itemRepo.save(item);
    }

}
