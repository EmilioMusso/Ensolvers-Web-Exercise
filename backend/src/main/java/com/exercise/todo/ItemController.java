package com.exercise.todo;

import java.util.List;

import com.exercise.todo.model.Item;
import com.exercise.todo.service.ItemService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {   
        List<Item> items = itemService.findAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Item> getItemById (@PathVariable("id") Long id) {
        Item item = itemService.findItemById(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        Item newItem = itemService.createItem(item);
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Item> updateItem(@RequestBody Item item) {
        Item updateItem = itemService.updateItem(item);
        return new ResponseEntity<>(updateItem, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable("id") Long id) {
        itemService.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
