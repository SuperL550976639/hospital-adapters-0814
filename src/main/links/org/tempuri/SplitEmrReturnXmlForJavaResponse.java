/**
 * SplitEmrReturnXmlForJavaResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

@SuppressWarnings("serial")
public class SplitEmrReturnXmlForJavaResponse  implements java.io.Serializable {
    private java.lang.String splitEmrReturnXmlForJavaResult;

    public SplitEmrReturnXmlForJavaResponse() {
    }

    public SplitEmrReturnXmlForJavaResponse(
           java.lang.String splitEmrReturnXmlForJavaResult) {
           this.splitEmrReturnXmlForJavaResult = splitEmrReturnXmlForJavaResult;
    }


    /**
     * Gets the splitEmrReturnXmlForJavaResult value for this SplitEmrReturnXmlForJavaResponse.
     * 
     * @return splitEmrReturnXmlForJavaResult
     */
    public java.lang.String getSplitEmrReturnXmlForJavaResult() {
        return splitEmrReturnXmlForJavaResult;
    }


    /**
     * Sets the splitEmrReturnXmlForJavaResult value for this SplitEmrReturnXmlForJavaResponse.
     * 
     * @param splitEmrReturnXmlForJavaResult
     */
    public void setSplitEmrReturnXmlForJavaResult(java.lang.String splitEmrReturnXmlForJavaResult) {
        this.splitEmrReturnXmlForJavaResult = splitEmrReturnXmlForJavaResult;
    }

    private java.lang.Object __equalsCalc = null;
    @SuppressWarnings("unused")
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SplitEmrReturnXmlForJavaResponse)) return false;
        SplitEmrReturnXmlForJavaResponse other = (SplitEmrReturnXmlForJavaResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.splitEmrReturnXmlForJavaResult==null && other.getSplitEmrReturnXmlForJavaResult()==null) || 
             (this.splitEmrReturnXmlForJavaResult!=null &&
              this.splitEmrReturnXmlForJavaResult.equals(other.getSplitEmrReturnXmlForJavaResult())));
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
        if (getSplitEmrReturnXmlForJavaResult() != null) {
            _hashCode += getSplitEmrReturnXmlForJavaResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SplitEmrReturnXmlForJavaResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SplitEmrReturnXmlForJavaResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("splitEmrReturnXmlForJavaResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SplitEmrReturnXmlForJavaResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
