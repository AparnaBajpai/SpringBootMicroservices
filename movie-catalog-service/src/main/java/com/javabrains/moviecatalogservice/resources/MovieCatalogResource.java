package com.javabrains.moviecatalogservice.resources;

import com.javabrains.moviecatalogservice.models.CatalogItem;
import com.javabrains.moviecatalogservice.models.Movie;
import com.javabrains.moviecatalogservice.models.Ratings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId)
    {


        List<Ratings> ratings = Arrays.asList(
                new Ratings("1234",1),
                new Ratings("5678",3)
        );

       return  ratings.stream().map(rating -> {
           Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getName(), "Desc", rating.getRating());

       })
               .collect(Collectors.toList());

    }
}
