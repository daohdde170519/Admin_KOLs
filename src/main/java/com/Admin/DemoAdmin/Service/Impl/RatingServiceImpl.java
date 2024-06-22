/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Service.Impl;

import com.Admin.DemoAdmin.DTOs.ProfileRatingDTO;
import com.Admin.DemoAdmin.Repository.RatingRepository;
import com.Admin.DemoAdmin.Service.RatingService;
import java.util.List;
import java.util.OptionalDouble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DAO
 */
@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public List<Integer> findRatingValuesByRequesterId(Integer requesterId) {
        return ratingRepository.findRatingValuesByRequesterId(requesterId);
    }
    @Override
    public OptionalDouble calculateAverageRating(Integer requesterId) {
        List<Integer> ratingValues = findRatingValuesByRequesterId(requesterId);

        if (ratingValues.isEmpty()) {
            return OptionalDouble.empty();
        } else {
            double average = ratingValues.stream().mapToInt(Integer::intValue).average().orElse(0.0);
            return OptionalDouble.of(average);
        }
    }
}
