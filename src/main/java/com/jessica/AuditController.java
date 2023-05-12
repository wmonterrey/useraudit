package com.jessica;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jessica.error.AuditNotFoundException;

@RestController
public class AuditController {

    @Autowired
    private AuditRepository repository;

    // Find
    @GetMapping("/audits")
    List<Audit> findAll() {
        return repository.findAll();
    }

    // Save
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/audits")
    Audit newAudit(@RequestBody Audit newAudit) {
        return repository.save(newAudit);
    }

    // Find
    @GetMapping("/audits/{id}")
    Audit findOne(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new AuditNotFoundException(id));
    }

    // Save or update
    @PutMapping("/audits/{id}")
    Audit saveOrUpdate(@RequestBody Audit newAudit, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {
                	x.setAffectedUser(newAudit.getAffectedUser());
                	x.setAuthor(newAudit.getAuthor());
                	x.setUsername(newAudit.getUsername());
                    x.setName(newAudit.getName());
                    x.setLastname(newAudit.getLastname());
                    x.setPassword(newAudit.getPassword());
                    x.setEmail(newAudit.getEmail());
                    x.setOperation(newAudit.getOperation());
                    x.setDate(newAudit.getDate());
                    return repository.save(x);
                })
                .orElseGet(() -> {
                    newAudit.setId(id);
                    return repository.save(newAudit);
                });
    }

    @DeleteMapping("/audits/{id}")
    void deleteAudit(@PathVariable Long id) {
        repository.deleteById(id);
    }

}