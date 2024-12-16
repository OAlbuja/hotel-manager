package com.hotel.api;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 4.0.2
 * 2024-12-16T02:50:44.732-05:00
 * Generated source version: 4.0.2
 *
 */
@WebService(targetNamespace = "http://hotel.com/availability", name = "AvailabilityPort")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface AvailabilityPort {

    @WebMethod(action = "checkAvailability")
    @WebResult(name = "CheckAvailabilityResponse", targetNamespace = "http://hotel.com/availability", partName = "parameters")
    public CheckAvailabilityResponse checkAvailability(

        @WebParam(partName = "parameters", name = "CheckAvailabilityRequest", targetNamespace = "http://hotel.com/availability")
        CheckAvailabilityRequest parameters
    );
}