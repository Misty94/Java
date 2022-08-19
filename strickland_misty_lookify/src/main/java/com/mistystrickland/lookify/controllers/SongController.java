package com.mistystrickland.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mistystrickland.lookify.models.Song;
import com.mistystrickland.lookify.services.SongService;

@Controller
public class SongController {

	@Autowired
	private SongService songService;
	
	@GetMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@GetMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "newSong.jsp";
	}
	
	@PostMapping("/songs/new")
	public String processCreate(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
			return "newSong.jsp";
		} else {
			songService.saveSong(song);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> songList = songService.allSongs();
		model.addAttribute("songList", songList);
		return "dashboard.jsp";
	}
	
	@GetMapping("/songs/{id}")
	public String showSong(@PathVariable("id") Long id, Model model) {
		Song oneSong = songService.oneSong(id);
		model.addAttribute("song", oneSong);
		return "show.jsp";
	}
	
	@DeleteMapping("/song/{id}/delete")
	public String deleteSong(@PathVariable("id") Long id, @Valid @ModelAttribute("song") Song song, 
			BindingResult result) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/search/topTen")
	public String topTen(Model model) {
		List<Song> topTen = songService.topTen();
		model.addAttribute("topTen", topTen);
		return "topTen.jsp";
	}
	
	@GetMapping("/search/{artist}")
	public String searchArtist(@PathVariable("artist") String artist, Model model) {
		List<Song> specificArtist = songService.searchByArtist(artist);
		model.addAttribute("artistSongs", specificArtist);
		return "search.jsp";
	}
	
	@PostMapping("/search")
	public String processSearch(@RequestParam("artist") String artist, Model model) {
		model.addAttribute("artist", artist);
		return "redirect:/search/"+artist;
	}
}
