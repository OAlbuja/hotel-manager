package com.hotel.api.client;

import org.springframework.ws.client.core.WebServiceTemplate;
import javax.xml.bind.JAXBElement;

public class SoapClient {

    private WebServiceTemplate webServiceTemplate;

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