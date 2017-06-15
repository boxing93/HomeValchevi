package HomeValchevi.Repositories;

import HomeValchevi.Entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Iliya on 12.6.2017 г..
 */
@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Long>{

    ContactEntity saveAndFlush(ContactEntity contactEntity);

}
