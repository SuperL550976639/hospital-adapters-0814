/**
 * GetInfo2Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

@SuppressWarnings("serial")
public class GetInfo2Response  implements java.io.Serializable {
    private org.tempuri.GetInfo2ResponseGetInfo2Result getInfo2Result;

    public GetInfo2Response() {
    }

    public GetInfo2Response(
           org.tempuri.GetInfo2ResponseGetInfo2Result getInfo2Result) {
           this.getInfo2Result = getInfo2Result;
    }


    /**
     * Gets the getInfo2Result value for this GetInfo2Response.
     * 
     * @return getInfo2Result
     */
    public org.tempuri.GetInfo2ResponseGetInfo2Result getGetInfo2Result() {
        return getInfo2Result;
    }


    /**
     * Sets the getInfo2Result value for this GetInfo2Response.
     * 
     * @param getInfo2Result
     */
    public void setGetInfo2Result(org.tempuri.GetInfo2ResponseGetInfo2Result getInfo2Result) {
        this.getInfo2Result = getInfo2Result;
    }

    private java.lang.Object __equalsCalc = null;
    @SuppressWarnings("unused")
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetInfo2Response)) return false;
        GetInfo2Response other = (GetInfo2Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getInfo2Result==null && other.getGetInfo2Result()==null) || 
             (this.getInfo2Result!=null &&
              this.getInfo2Result.equals(other.getGetInfo2Result())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getGetInfo2Result() != null) {
            _hashCode += getGetInfo2Result().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetInfo2Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetInfo2Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getInfo2Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetInfo2Result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetInfo2Response>GetInfo2Result"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    @SuppressWarnings("rawtypes")
	public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    @SuppressWarnings("rawtypes")
	public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
