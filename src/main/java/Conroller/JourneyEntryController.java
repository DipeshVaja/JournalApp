package Conroller;

import Entity.JournalEntry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/entries")
public class JourneyEntryController {

    private final Map<Long, JournalEntry> journalEntries = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @GetMapping
    public List<JournalEntry> getAll() {
        return new ArrayList<>(journalEntries.values());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JournalEntry> getById(@PathVariable("id") Long id) {
        JournalEntry entry = journalEntries.get(id);
        if (entry == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(entry);
    }

    @PostMapping
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry) {
        // If client didn't provide id, generate one
        Long id = myEntry.getId();
        if (id == null) {
            id = idGenerator.getAndIncrement();
            myEntry.setId(id);
        } else {
            // ensure uniqueness
            if (journalEntries.containsKey(id)) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
        }
        journalEntries.put(id, myEntry);
        return ResponseEntity.status(HttpStatus.CREATED).body(myEntry);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JournalEntry> updateEntry(@PathVariable("id") Long id, @RequestBody JournalEntry updated) {
        JournalEntry existing = journalEntries.get(id);
        if (existing == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        // update fields
        if (updated.getTitle() != null) existing.setTitle(updated.getTitle());
        if (updated.getContent() != null) existing.setContent(updated.getContent());
        journalEntries.put(id, existing);
        return ResponseEntity.ok(existing);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable("id") Long id) {
        JournalEntry removed = journalEntries.remove(id);
        if (removed == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.noContent().build();
    }

}
