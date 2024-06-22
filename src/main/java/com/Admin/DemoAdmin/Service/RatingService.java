/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Admin.DemoAdmin.Service;

import com.Admin.DemoAdmin.DTOs.ProfileRatingDTO;
import java.util.List;
import java.util.OptionalDouble;
import org.springframework.stereotype.Service;

/**
 *
 * @author DAO
 */
@Service
public interface RatingService {
    List<Integer> findRatingValuesByRequesterId(Integer requesterId);
    OptionalDouble calculateAverageRating(Integer requesterId);
}
