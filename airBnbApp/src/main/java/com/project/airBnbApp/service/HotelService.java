package com.project.airBnbApp.service;

import com.project.airBnbApp.dto.HotelDto;
import com.project.airBnbApp.dto.HotelInfoDto;
import com.project.airBnbApp.entity.Hotel;

import java.util.List;

public interface HotelService {

    HotelDto createNewHotel(HotelDto hotelDto);

    HotelDto getHotelByID(Long id);

    HotelDto updateHotelByID(Long id,HotelDto hotelDto);

    void deleteHotelByID(Long id);

    void activateHotel(Long hotelId);

    HotelInfoDto getHotelInfoById(Long id);

    List<HotelDto> getAllHotels();
}
