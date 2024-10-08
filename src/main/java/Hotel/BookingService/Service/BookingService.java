package Hotel.BookingService.Service;

import Hotel.BookingService.Entity.Booking;
import Hotel.BookingService.Repository.BookingRepo;
import Hotel.BookingService.dto.BookingDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private ModelMapper modelMapper;



    public Booking createBooking(BookingDTO bookingDTO) {
       Booking booking = modelMapper.map(bookingDTO, Booking.class);
       return bookingRepo.save(booking);
    }

    public Optional<Booking> getbookingbyid(Integer bookingId) {
        return bookingRepo.findById(bookingId);
    }

    public Booking updateBooking(BookingDTO bookingDTO) {
        Booking booking= modelMapper.map(bookingDTO, Booking.class);
        Optional<Booking> checkbookingAvailibility = bookingRepo.findById(booking.getId());
        if (checkbookingAvailibility.isPresent()){
           return bookingRepo.save(booking);
        }
        return null;


    }

    public void deletebyId(Integer bookingId) {
           Booking booking= bookingRepo.findById(bookingId).orElseThrow(()-> new IllegalArgumentException("Illegal"));
           bookingRepo.deleteById(bookingId);
    }

    public List<Booking> getAllBooking() {
        return bookingRepo.findAll();
    }
}
