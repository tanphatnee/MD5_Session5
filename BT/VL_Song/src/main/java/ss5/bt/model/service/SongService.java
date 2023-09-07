package ss5.bt.model.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import ss5.bt.model.entity.Song;
import ss5.bt.model.repository.ISongRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository songRepository;
    @Override
    public List<Song> findAll() {

        return (List<Song>) songRepository.findAll();
    }

    @Override
    public Song findById(Long id) {

        return songRepository.findById(id).get();
    }

    @Override
    public Song save(Song song) {

       return songRepository.save(song);
    }

    @Override
    public void delete(Long id) {

        songRepository.deleteById(id);
    }
}
