package com.mistystrickland.lookify.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mistystrickland.lookify.models.Song;

public interface SongRepository extends CrudRepository<Song, Long> {

	List<Song> findAll();
	
	// Find All By Order of Rating (descending)
	List<Song> findAllByOrderByRatingDesc();
	// Find By Searching Artist Name
	List<Song> findByArtistContaining(String artist);
	// Find By Searching Title Name
	List<Song> findByTitleContaining(String title);
	
	// Find Top Ten By Order of Rating (descending)
	@Query(value = "SELECT * FROM songs ORDER BY rating DESC LIMIT 10", nativeQuery=true)
	List<Song> getTopTen();
	
}
