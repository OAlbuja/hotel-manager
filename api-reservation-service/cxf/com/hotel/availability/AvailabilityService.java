package com.hotel.api;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceFeature;
import jakarta.xml.ws.Service;

/**
 * Servicio para consultar disponibilidad de habitaciones
 *
 * This class was generated by Apache CXF 4.0.2
 * 2024-12-16T02:50:44.765-05:00
 * Generated source version: 4.0.2
 *
 */
@WebServiceClient(name = "AvailabilityService",
                  wsdlLocation = "file:/C:/Users/asus/Documents/Proyectos%20software/Spring%20boot/eclipse-workspace/soap-availability-service/src/main/resources/availability.wsdl",
                  targetNamespace = "http://hotel.com/availability")
public class AvailabilityService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://hotel.com/availability", "AvailabilityService");
    public final static QName AvailabilityPort = new QName("http://hotel.com/availability", "AvailabilityPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/Users/asus/Documents/Proyectos%20software/Spring%20boot/eclipse-workspace/soap-availability-service/src/main/resources/availability.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(AvailabilityService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/C:/Users/asus/Documents/Proyectos%20software/Spring%20boot/eclipse-workspace/soap-availability-service/src/main/resources/availability.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public AvailabilityService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public AvailabilityService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AvailabilityService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public AvailabilityService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public AvailabilityService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public AvailabilityService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns AvailabilityPort
     */
    @WebEndpoint(name = "AvailabilityPort")
    public AvailabilityPort getAvailabilityPort() {
        return super.getPort(AvailabilityPort, AvailabilityPort.class);
    }

    /**
     *
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AvailabilityPort
     */
    @WebEndpoint(name = "AvailabilityPort")
    public AvailabilityPort getAvailabilityPort(WebServiceFeature... features) {
        return super.getPort(AvailabilityPort, AvailabilityPort.class, features);
    }

}
