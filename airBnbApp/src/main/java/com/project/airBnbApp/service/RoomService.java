package com.project.airBnbApp.service;

import com.project.airBnbApp.dto.RoomDto;

import java.util.List;

public interface RoomService {

    RoomDto createNewRoom(Long hotelID,RoomDto roomDto);

    RoomDto getRoomById(Long roomId);

    List<RoomDto> getAllRoomsInHotel(Long hotelId);

    void deleteRoomById(Long roomId);


}
