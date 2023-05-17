package de.htwberlin.webtech.webtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReminderService {

    @Autowired
    ReminderRepository repo;

    public Reminder save(Reminder reminder) {
        return repo.save(reminder);
    }

    public Reminder get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<Reminder> getAll() {
        Iterable<Reminder> iterator = repo.findAll();
        List<Reminder> reminders = new ArrayList<Reminder>();
        for (Reminder reminder : iterator)  reminders.add(reminder);
        return reminders;
    }
}
