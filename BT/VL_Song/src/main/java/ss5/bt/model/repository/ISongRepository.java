package ss5.bt.model.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ss5.bt.model.entity.Song;

import java.util.List;

@Repository
public interface ISongRepository extends CrudRepository<Song,Long> {

}
