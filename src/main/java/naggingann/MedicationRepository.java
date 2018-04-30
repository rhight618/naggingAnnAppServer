package naggingann;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface MedicationRepository extends CrudRepository<Medication, Long> {
	
    @Query(value = "SELECT * FROM medication m where m.name = :name", nativeQuery=true)
    public Optional<Medication> findByName(@Param("name") String name);
    
    @Transactional
    @Modifying
    @Query(value = "delete from medication where id = :Id", nativeQuery=true)
    void delete(@Param("Id") Long Id);
     

}
