package com.trg.moviecatalogservice.resource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.trg.moviecatalogservice.model.CatalogItem;
import com.trg.moviecatalogservice.model.Movie;
import com.trg.moviecatalogservice.model.Rating;
import com.trg.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("catalog")
public class MovieCatalogResource {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	/*@Autowired
	WebClient.Builder webClientBuilder;*/
	
	@RequestMapping("/{userid}")
	public List<CatalogItem> getCatalog(@PathVariable("userid") String userid){
		
		RestTemplate restTemplate = new RestTemplate();
		
		//List<Rating> ratings = Arrays.asList(new Rating("1",1), new Rating("2",2), new Rating("3",3));
		
		//return ratings.stream().map(rating -> new CatalogItem("Movie-A", "Movie-A Desc", 4)).collect(Collectors.toList());
		
		/*return ratings.stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
			return new CatalogItem(movie.getName(), "Hardcoded Desc", rating.getRating());
		}).collect(Collectors.toList());
		*/
		//UserRating userRating = restTemplate.getForObject("http://localhost:8083/ratingdata/user/1", UserRating.class);
		UserRating userRating = restTemplate.getForObject("http://rating-data-service/ratingdata/user/1", UserRating.class);
		return userRating.getRatings()
				.stream()
				.map(rating -> {
					Movie movie = restTemplate
					                 .getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class); //get me the resource from this URL and marshall it into this type of object
					
					/*Movie movie = webClientBuilder.build()
					                .get()  //HTTP GET type request
					                .uri("http://localhost:8082/movies/" + rating.getMovieId())
					                .retrieve()  //go and do the fetch
					                .bodyToMono(Movie.class)  //whatever body you get, convert to an instance of Movie type. Mono? is a type of promise
					                .block();*/
					                
					                
					//return new CatalogItem(movie.getName(), "Hardcoded desc", rating.getRating());
				})
				.collect(Collectors.toList());
		
		/*return Collections.singletonList(
				new CatalogItem("movie-A", "movie-A desc", 4)
				);*/
	}
}
