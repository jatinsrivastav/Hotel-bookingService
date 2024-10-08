package Hotel.BookingService.Controller;

import Hotel.BookingService.Entity.Booking;
import Hotel.BookingService.Service.BookingService;
import Hotel.BookingService.dto.BookingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookingService")
public class BookingController {


    @Autowired
    private BookingService bookingService;

    @PostMapping("/booking")
    public ResponseEntity<Booking> createbooking(@RequestBody BookingDTO bookingDTO) {
        return new ResponseEntity<>(bookingService.createBooking(bookingDTO), HttpStatus.OK);
    }

    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<Optional<Booking>> getBookingbyId(@PathVariable Integer bookingId) {
        return new ResponseEntity<>(bookingService.getbookingbyid(bookingId), HttpStatus.OK);
    }

    @GetMapping("/booking")
    public ResponseEntity<List<Booking>> getAllbooking() {
     return new ResponseEntity<>(bookingService.getAllBooking(), HttpStatus.OK);

    }

    @PutMapping("/booking/{bookingId}")
    public ResponseEntity<Booking> upadateBooking(@RequestBody BookingDTO bookingDTO) {
        return new ResponseEntity<>(bookingService.updateBooking(bookingDTO), HttpStatus.OK);
    }


    @DeleteMapping("/booking/{bookingId}")
    public ResponseEntity<Void> deleteBookingid(@PathVariable Integer bookingId) {
        bookingService.deletebyId(bookingId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

   // GET /bookings/user/{userId}   -- need to implement from User I think.
   // GET /bookings/hotel/{hotelId}  -- need to implement from the Hotel Service.

}
