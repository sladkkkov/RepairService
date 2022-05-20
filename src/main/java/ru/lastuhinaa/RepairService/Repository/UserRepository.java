package ru.lastuhinaa.RepairService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lastuhinaa.RepairService.Model.Person;

@Repository
public interface UserRepository extends JpaRepository<Person, Long> {
    Person getByUsername(String username);

    Person getByActivationCode(String activationCode);

}
