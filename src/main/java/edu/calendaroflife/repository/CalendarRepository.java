package edu.calendaroflife.repository;

import edu.calendaroflife.model.CalendarsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarRepository extends JpaRepository<CalendarsEntity, Long> {
}
