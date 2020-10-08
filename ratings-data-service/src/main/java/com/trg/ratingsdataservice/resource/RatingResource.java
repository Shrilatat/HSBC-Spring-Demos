package com.trg.ratingsdataservice.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trg.ratingsdataservice.model.Rating;
import com.trg.ratingsdataservice.model.UserRating;


@RestController
@RequestMapping("ratingdata")
public class RatingResource {

	
	@RequestMapping("/{movieId}")
	public Rating getRatingInfo(@PathVariable("movieId") String movieId){
		return new Rating(movieId, 5);
	}
	
	/*@RequestMapping("/user/{userId}")
	public List<Rating> getRatings(@PathVariable("userId") String userId){
		return Arrays.asList(new Rating("1",1), new Rating("2",2), new Rating("3",3));
	}*/
	
	@RequestMapping("/user/{userId}")
	public UserRating getRatings(@PathVariable("userId") String userId){
		UserRating userRating = new UserRating();
		userRating.setRatings(Arrays.asList(new Rating("1",1), new Rating("2",2), new Rating("3",3)));
		return userRating;
	}
}
