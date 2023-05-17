package de.htwberlin.webtech.webtech;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReminderController {

    @Autowired
    ReminderService service;

    Logger logger = LoggerFactory.getLogger(ReminderController.class);

    @PostMapping("/reminders")
    public Reminder createReminder(@RequestBody Reminder reminder) {
        return service.save(reminder);
    }

    @GetMapping("/reminders/{id}")
    public Reminder getReminder(@PathVariable String id) {
        logger.info("GET request on route things with {}", id);
        Long reminderId = Long.parseLong(id);
        return service.get(reminderId);
    }

    @GetMapping("/reminders")
    public List<Reminder> getAllReminders() {
        return service.getAll();
    }

}
