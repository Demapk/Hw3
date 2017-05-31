package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.model.Operation;

import java.util.Date;
import java.util.List;

public interface OperationRepository extends JpaRepository<Operation, Long> {
    List<Operation> findAllByDateBefore(Date before);
}
