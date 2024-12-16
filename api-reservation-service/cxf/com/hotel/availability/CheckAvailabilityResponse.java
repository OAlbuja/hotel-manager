
package com.hotel.api;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="availableRooms" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "availableRooms"
})
@XmlRootElement(name = "CheckAvailabilityResponse")
public class CheckAvailabilityResponse {

    @XmlElement(required = true)
    protected String availableRooms;

    /**
     * Obtiene el valor de la propiedad availableRooms.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvailableRooms() {
        return availableRooms;
    }

    /**
     * Define el valor de la propiedad availableRooms.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvailableRooms(String value) {
        this.availableRooms = value;
    }

}
