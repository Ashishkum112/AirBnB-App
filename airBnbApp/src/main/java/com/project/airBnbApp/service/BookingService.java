package com.project.airBnbApp.service;

import com.project.airBnbApp.dto.BookingDto;
import com.project.airBnbApp.dto.BookingRequest;

public interface BookingService {


    BookingDto initialiseBooking(BookingRequest bookingRequest);
}
