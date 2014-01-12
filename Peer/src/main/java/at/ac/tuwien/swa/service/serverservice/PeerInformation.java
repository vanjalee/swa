
package at.ac.tuwien.swa.service.serverservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for peerInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="peerInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="libraryPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="peerType" type="{http://ServerService.service.swa.tuwien.ac.at/}peerType" minOccurs="0"/>
 *         &lt;element name="port" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="serverWsdl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "peerInformation", propOrder = {
    "libraryPath",
    "password",
    "peerType",
    "port",
    "serverWsdl",
    "username"
})
public class PeerInformation {

    protected String libraryPath;
    protected String password;
    protected PeerType peerType;
    protected Integer port;
    protected String serverWsdl;
    protected String username;

    /**
     * Gets the value of the libraryPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibraryPath() {
        return libraryPath;
    }

    /**
     * Sets the value of the libraryPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibraryPath(String value) {
        this.libraryPath = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the peerType property.
     * 
     * @return
     *     possible object is
     *     {@link PeerType }
     *     
     */
    public PeerType getPeerType() {
        return peerType;
    }

    /**
     * Sets the value of the peerType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PeerType }
     *     
     */
    public void setPeerType(PeerType value) {
        this.peerType = value;
    }

    /**
     * Gets the value of the port property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPort() {
        return port;
    }

    /**
     * Sets the value of the port property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPort(Integer value) {
        this.port = value;
    }

    /**
     * Gets the value of the serverWsdl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServerWsdl() {
        return serverWsdl;
    }

    /**
     * Sets the value of the serverWsdl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServerWsdl(String value) {
        this.serverWsdl = value;
    }

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

}
