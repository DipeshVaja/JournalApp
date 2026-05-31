package Conroller;


import Entity.JournalEntry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class JourneyEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping("all")
    public List<JournalEntry> getAll()
    {
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public Boolean createMapping(@RequestBody JournalEntry myEntry)
    {
        journalEntries.put(myEntry.getId(),myEntry);
        return true;

    }
}
