/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Controller;

import com.Admin.DemoAdmin.Service.RatingService;
import java.util.OptionalDouble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DAO
 */
@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @GetMapping("/{requesterId}/average")
    public ResponseEntity<Double> getAverageRatingByRequesterId(@PathVariable("requesterId") Integer requesterId) {
        OptionalDouble averageRating = ratingService.calculateAverageRating(requesterId);

        if (averageRating.isPresent()) {
            return ResponseEntity.ok(averageRating.getAsDouble());
        } else {
            // Trường hợp không có rating hoặc requesterId không hợp lệ
            return ResponseEntity.notFound().build();
        }
    }
}
