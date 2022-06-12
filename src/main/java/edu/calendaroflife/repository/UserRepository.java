package edu.calendaroflife.repository;

import edu.calendaroflife.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    public UserEntity findUserEntityById(Integer id);

    public UserEntity findUserEntityByEmail(String email);
}
