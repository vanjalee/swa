
package at.ac.tuwien.swa.service.serverservice;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for peerType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="peerType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SUPER"/>
 *     &lt;enumeration value="EDGE"/>
 *     &lt;enumeration value="RELAY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "peerType")
@XmlEnum
public enum PeerType {

    SUPER,
    EDGE,
    RELAY;

    public String value() {
        return name();
    }

    public static PeerType fromValue(String v) {
        return valueOf(v);
    }

}
