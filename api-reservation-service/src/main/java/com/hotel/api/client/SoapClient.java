package com.hotel.api.client;

import com.hotel.availability.CheckAvailabilityRequest;
import com.hotel.availability.CheckAvailabilityResponse;
import com.hotel.availability.AvailabilityService;
import com.hotel.availability.AvailabilityPort;
import org.springframework.stereotype.Component;

import jakarta.xml.ws.BindingProvider; // Asegúrate de importar esto
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;

@Component
public class SoapClient {

    private final AvailabilityPort availabilityPort;

    // Constructor inicializa el cliente SOAP
    public SoapClient() {
        AvailabilityService service = new AvailabilityService();
        this.availabilityPort = service.getAvailabilityPort();

        // Configurar la URL manualmente
        ((BindingProvider) availabilityPort)
            .getRequestContext()
            .put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8080/ws");
    }

    // Método para llamar al servicio SOAP
    public CheckAvailabilityResponse checkAvailability(String startDate, String endDate, String roomType) {
        CheckAvailabilityRequest request = new CheckAvailabilityRequest();
        request.setStartDate(convertStringToXMLGregorianCalendar(startDate));
        request.setEndDate(convertStringToXMLGregorianCalendar(endDate));
        request.setRoomType(roomType);

        return availabilityPort.checkAvailability(request);
    }
    
    private XMLGregorianCalendar convertStringToXMLGregorianCalendar(String date) {
        try {
            LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
            GregorianCalendar gregorianCalendar = GregorianCalendar.from(localDate.atStartOfDay(java.time.ZoneId.systemDefault()));
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException("Error converting String to XMLGregorianCalendar", e);
        }
    }
}
