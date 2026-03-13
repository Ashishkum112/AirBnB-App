package com.project.airBnbApp.service;

import com.project.airBnbApp.dto.BookingDto;
import com.project.airBnbApp.dto.BookingRequest;
import com.project.airBnbApp.dto.GuestDto;
import com.stripe.model.Event;

import java.util.List;
import java.util.Map;

public interface BookingService {


    BookingDto initialiseBooking(BookingRequest bookingRequest);

    BookingDto addGuests(List<GuestDto> guestDtoList, Long bookingId);

    String initiatePayment(Long bookingId);

    void capturePayment(Event event);

    void cancelBooking(Long bookingId);

   String getBookingStatus(Long bookingId);
}
