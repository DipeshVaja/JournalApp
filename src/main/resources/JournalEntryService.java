package com.firstpro.myfirstproject.service;

import com.firstpro.myfirstproject.entity.JournalEntry;
import com.firstpro.myfirstproject.repository.JournalEntryRepository;
import org.springframework.stereotype.Service;
import org.springframework.*;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public JournalEntryRepository getJournalEntryRepository() {
        return journalEntryRepository;
    }
}