package com.javabrains.ratingdataservice.resourves;

import com.javabrains.ratingdataservice.models.Ratings;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsdata")
public class RatingDataResource {

    @RequestMapping("/movieId")
    public Ratings getRating(@PathVariable("movieId") String movieId)
    {
        return new Ratings(movieId,4);
    }
}
