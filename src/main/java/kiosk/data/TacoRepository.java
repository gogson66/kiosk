package kiosk.data;

import kiosk.Taco;
import org.springframework.data.repository.CrudRepository;;

public interface TacoRepository extends CrudRepository<Taco, Long> {
    
}
