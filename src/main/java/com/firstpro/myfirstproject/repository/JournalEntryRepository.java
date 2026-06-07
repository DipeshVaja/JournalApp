package com.firstpro.myfirstproject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.firstpro.myfirstproject.entity.JournalEntry;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, String> {
}