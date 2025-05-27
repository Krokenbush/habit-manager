package com.example.habit_manager.DAO.Repository;

import com.example.habit_manager.DAO.Module.AuditTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditTableRepository extends CrudRepository<AuditTable, Long> {
}
