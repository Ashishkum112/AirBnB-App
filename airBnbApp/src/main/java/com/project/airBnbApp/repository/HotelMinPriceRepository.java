package com.project.airBnbApp.repository;

import com.project.airBnbApp.entity.HotelMinPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelMinPriceRepository extends JpaRepository<HotelMinPrice,Long> {
}
