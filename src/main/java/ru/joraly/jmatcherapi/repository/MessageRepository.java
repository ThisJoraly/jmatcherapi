package ru.joraly.jmatcherapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.joraly.jmatcherapi.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
