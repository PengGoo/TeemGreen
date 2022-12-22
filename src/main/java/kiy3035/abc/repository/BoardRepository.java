package kiy3035.abc.repository;

import kiy3035.abc.domain.Board1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository <Board1, Long> {
}
