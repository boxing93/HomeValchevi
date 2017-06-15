package HomeValchevi.Repositories;

import HomeValchevi.Entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Iliya on 11.6.2017 г..
 */
@Repository
public interface BookingRepository extends JpaRepository<BookingEntity,Integer> {

    BookingEntity saveAndFlush(BookingEntity booking);


}
