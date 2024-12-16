package com.hotel.soap.endpoint;

import com.hotel.soap.model.Availability;
import com.hotel.soap.repository.AvailabilityRepository;
import com.hotel.availability.AvailabilityService;
import com.hotel.availability.CheckAvailabilityRequest;
import com.hotel.availability.CheckAvailabilityResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.time.LocalDate;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;

@Endpoint
public class AvailabilityEndpoint {

    private static final String NAMESPACE_URI = "http://hotel.com/availability";
    private final AvailabilityRepository repository;

    public AvailabilityEndpoint(AvailabilityRepository repository) {
        this.repository = repository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CheckAvailabilityRequest")
    @ResponsePayload
    public CheckAvailabilityResponse checkAvailability(@RequestPayload CheckAvailabilityRequest request) {
        // 1) Validar fechas:
        LocalDate startDate = convertToLocalDate(request.getStartDate());
        LocalDate endDate = convertToLocalDate(request.getEndDate());

        List<Availability> availableRooms;
        if ("ALL".equalsIgnoreCase(request.getRoomType())) {
            // 2) Llamar a un método REPO que no filtre por roomType
            availableRooms = repository.findByAvailableDateBetweenAndStatus(startDate, endDate, "Disponible");
        } else {
            // 3) Filtrar por roomType específico
            availableRooms = repository.findByRoomTypeAndAvailableDateBetweenAndStatus(
                    request.getRoomType(),
                    startDate,
                    endDate,
                    "Disponible");
        }

        CheckAvailabilityResponse response = new CheckAvailabilityResponse();
        response.setAvailableRooms(availableRooms.toString());
        return response;
    }

    public LocalDate convertToLocalDate(XMLGregorianCalendar xmlGregorianCalendar) {
        if (xmlGregorianCalendar == null) {
            throw new IllegalArgumentException("La fecha no puede ser null");
        }
        return xmlGregorianCalendar.toGregorianCalendar().toZonedDateTime().toLocalDate();
    }

}