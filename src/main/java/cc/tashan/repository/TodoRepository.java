package cc.tashan.repository;

import cc.tashan.model.Todos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todos, Long> {
}
