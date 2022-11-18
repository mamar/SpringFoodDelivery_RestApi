package com.employee.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.model.Restaurant;
@Repository
public interface RestaurantRepository  extends JpaRepository<Restaurant, Long>{


}
