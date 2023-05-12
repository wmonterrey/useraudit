package com.jessica;
import org.springframework.data.jpa.repository.JpaRepository;

//Spring Data 
public interface AuditRepository extends JpaRepository<Audit, Long> {
}
