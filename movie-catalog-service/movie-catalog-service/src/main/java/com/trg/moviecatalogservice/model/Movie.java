package com.trg.moviecatalogservice.model;

public class Movie {
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	String movieId;
	String name;
	
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Movie(String movieId, String name) {
		super();
		this.movieId = movieId;
		this.name = name;
	}

}
