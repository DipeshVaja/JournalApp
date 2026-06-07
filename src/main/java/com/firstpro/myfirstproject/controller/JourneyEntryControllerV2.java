package com.firstpro.myfirstproject.controller;

import com.firstpro.myfirstproject.entity.JournalEntry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/Journal")
public class JourneyEntryController {



    @GetMapping
    public List<JournalEntry> getAll() {

    }

    @GetMapping("id/{id}")
    public ResponseEntity<JournalEntry> getById(@PathVariable("id") Long id) {

    }

    @PostMapping
    public Boolean createEntry(@RequestBody JournalEntry myEntry) {
        return true;
    }

    @PutMapping("id/{id}")
    public ResponseEntity<JournalEntry> updateEntry(@PathVariable Long id, @RequestBody JournalEntry updated) {

    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable("id") Long id) {
        JournalEntry removed = journalEntries.remove(id);
        if (removed == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.noContent().build();
    }

}
