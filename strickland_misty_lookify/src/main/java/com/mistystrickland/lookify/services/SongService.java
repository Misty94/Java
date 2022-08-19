package com.mistystrickland.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mistystrickland.lookify.models.Song;
import com.mistystrickland.lookify.repositories.SongRepository;

@Service
public class SongService {

	@Autowired
	private SongRepository songRepo;
	
	// Find All Songs
	public List<Song> allSongs(){
		return songRepo.findAll();
	}
	
	// Find One Song
	public Song oneSong(Long id) {
		Optional<Song> optionalSong = songRepo.findById(id);
		if (optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
	}
	
	// Create & Update a Song
	public Song saveSong(Song song) {
		return songRepo.save(song);
	}
	
	// Delete One Song
	public void deleteSong(Long id) {
		songRepo.deleteById(id);
	}
	
	// Find Top Ten
	public List<Song> topTen(){
		return songRepo.getTopTen();
	}
	
	// Find By Artist
	public List<Song> searchByArtist(String artist){
		return songRepo.findByArtistContaining(artist);
	}
	
	// Find By Title
	public List<Song> searchByTitle(String title){
		return songRepo.findByTitleContaining(title);
	}
}
