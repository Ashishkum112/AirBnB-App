package com.project.airBnbApp.controller;

import com.project.airBnbApp.dto.BookingDto;
import com.project.airBnbApp.dto.HotelDto;
import com.project.airBnbApp.dto.HotelReportDto;
import com.project.airBnbApp.service.BookingService;
import com.project.airBnbApp.service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/admin/hotels")
@RequiredArgsConstructor
@Slf4j
public class HotelController {

    private final HotelService hotelService;
    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<HotelDto> createNewHotel(@RequestBody HotelDto hotelDto)
    {
        log.info("Attempting to create a new hotel with name: " +hotelDto.getName());
        HotelDto hotel = hotelService.createNewHotel(hotelDto);
        return new ResponseEntity<>(hotel, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<HotelDto> getHotelById(@PathVariable Long id){
        log.info("Attempting to get a hotel with Id: " +id);

        HotelDto hotelDto = hotelService.getHotelByID(id);
        return new ResponseEntity<>(hotelDto,HttpStatus.OK);
    }

    @PutMapping("/{hotelId}")
    public ResponseEntity<HotelDto> updateHotelById(@RequestBody HotelDto hotelDto,@PathVariable Long hotelId)
    {
        log.info("Attempting to update a hotel with Id: " +hotelId);
        HotelDto hotelDto1 = hotelService.updateHotelByID(hotelId,hotelDto);
        return new ResponseEntity<>(hotelDto1,HttpStatus.OK);
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<Void> deleteHotelById(@RequestBody HotelDto hotelDto,@PathVariable Long hotelId)
    {
        log.info("Attempting to delete a hotel with Id: " +hotelId);
        hotelService.deleteHotelByID(hotelId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{hotelId}/activate")
    public ResponseEntity<Void> activateHotelById(@PathVariable Long hotelId)
    {
        log.info("Attempting to activate a hotel with Id: " +hotelId);
        hotelService.activateHotel(hotelId);

        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public ResponseEntity<List<HotelDto>> getAllHotels(){
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    @GetMapping("/{hotelId}/bookings")
    public ResponseEntity<List<BookingDto>> getAllBookingsByHotelId(@PathVariable Long hotelId)
    {
        return ResponseEntity.ok(bookingService.getAllBookingsByHotelId(hotelId));
    }

    @GetMapping("/{hotelId}/reports")
    public ResponseEntity<HotelReportDto> getAllBookingsByHotelId(@PathVariable Long hotelId,
                                                                  @RequestParam(required = false) LocalDate startDate,
                                                                  @RequestParam(required = false) LocalDate endDate
                                                                        )
    {
        if (startDate == null) startDate = LocalDate.now().minusMonths(1);
        if (endDate == null) endDate = LocalDate.now();


        return ResponseEntity.ok(bookingService.getHotelReport(hotelId,startDate,endDate));
    }


}
