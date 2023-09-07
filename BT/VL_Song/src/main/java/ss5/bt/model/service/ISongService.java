package ss5.bt.model.service;



import ss5.bt.model.entity.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    Song findById(Long id);
    Song save(Song song);
    void delete(Long id);
}
