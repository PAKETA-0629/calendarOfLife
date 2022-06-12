package edu.calendaroflife.repository;

import edu.calendaroflife.model.WeeksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeekRepository extends JpaRepository<WeeksEntity, Long> {
}
