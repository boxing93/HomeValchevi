package HomeValchevi.Repositories;

import HomeValchevi.Entity.SubscribeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Iliya on 12.6.2017 г..
 */

public interface SubscribeRepository extends JpaRepository<SubscribeEntity, Long> {

    SubscribeEntity saveAndFlush(SubscribeEntity subscribeEntity);
}
