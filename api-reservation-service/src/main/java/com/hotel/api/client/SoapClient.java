package com.hotel.api.client;

import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import javax.xml.bind.JAXBElement;
import com.hotel.api.soap.CheckAvailabilityRequest;
import com.hotel.api.soap.CheckAvailabilityResponse;

@Component
public class SoapClient {

    private final WebServiceTemplate webServiceTemplate;

    public SoapClient(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    public CheckAvailabilityResponse checkAvailability(CheckAvailabilityRequest request) {
        JAXBElement<CheckAvailabilityResponse> response = 
            (JAXBElement<CheckAvailabilityResponse>) webServiceTemplate
            .marshalSendAndReceive(request);
        return response.getValue();
    }
}
