package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class userEntryControllerv2 {

@Autowired
    private JournalEntryService JournalEntryService;

    @GetMapping
    public List<JournalEntry> getAll() {

        return JournalEntryService.getAll();
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry){
        myEntry.setDate(LocalDateTime.now());
        JournalEntryService.saveEntry(myEntry);
        return  myEntry;
    }

    @GetMapping("id/{myid}")
    public JournalEntry getjournalEntrybyid(@PathVariable ObjectId myid){
         return JournalEntryService.findByid(myid).orElse(null);
    }

    @DeleteMapping ("id/{myid}")
    public boolean deletejournalEntrybyid(@PathVariable ObjectId myid){
          JournalEntryService.deleteByid(myid);
          return true;


    }
    @PutMapping ("id/{id}")    public JournalEntry updateJournalByid(@PathVariable ObjectId id,@RequestBody JournalEntry newEntry) {
        JournalEntry old = JournalEntryService.findByid(id).orElse(null);
        if(old!= null){
            old.setTitle(newEntry.getTitle() != null &&  !newEntry.getTitle().equals("") ? newEntry.getTitle(): old.getTitle());
            old.setContent(newEntry.getContent()!= null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
        }

        JournalEntryService.saveEntry(old);
        return  old;    }
}
