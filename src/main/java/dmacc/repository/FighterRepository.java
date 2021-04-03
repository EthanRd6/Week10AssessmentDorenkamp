package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Fighter;

/**
 * @author Ethan Dorenkamp - edorenkamp
 * CIS175 - Spring 2021
 * Apr 2, 2021
 */

@Repository
public interface FighterRepository extends JpaRepository<Fighter, Long>{

}
