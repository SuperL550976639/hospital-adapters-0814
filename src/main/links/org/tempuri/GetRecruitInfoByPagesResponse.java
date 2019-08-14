/**
 * GetRecruitInfoByPagesResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

@SuppressWarnings("serial")
public class GetRecruitInfoByPagesResponse  implements java.io.Serializable {
    private java.lang.String getRecruitInfoByPagesResult;

    public GetRecruitInfoByPagesResponse() {
    }

    public GetRecruitInfoByPagesResponse(
           java.lang.String getRecruitInfoByPagesResult) {
           this.getRecruitInfoByPagesResult = getRecruitInfoByPagesResult;
    }


    /**
     * Gets the getRecruitInfoByPagesResult value for this GetRecruitInfoByPagesResponse.
     * 
     * @return getRecruitInfoByPagesResult
     */
    public java.lang.String getGetRecruitInfoByPagesResult() {
        return getRecruitInfoByPagesResult;
    }


    /**
     * Sets the getRecruitInfoByPagesResult value for this GetRecruitInfoByPagesResponse.
     * 
     * @param getRecruitInfoByPagesResult
     */
    public void setGetRecruitInfoByPagesResult(java.lang.String getRecruitInfoByPagesResult) {
        this.getRecruitInfoByPagesResult = getRecruitInfoByPagesResult;
    }

    private java.lang.Object __equalsCalc = null;
    @SuppressWarnings("unused")
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetRecruitInfoByPagesResponse)) return false;
        GetRecruitInfoByPagesResponse other = (GetRecruitInfoByPagesResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getRecruitInfoByPagesResult==null && other.getGetRecruitInfoByPagesResult()==null) || 
             (this.getRecruitInfoByPagesResult!=null &&
              this.getRecruitInfoByPagesResult.equals(other.getGetRecruitInfoByPagesResult())));
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
        if (getGetRecruitInfoByPagesResult() != null) {
            _hashCode += getGetRecruitInfoByPagesResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetRecruitInfoByPagesResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetRecruitInfoByPagesResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getRecruitInfoByPagesResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetRecruitInfoByPagesResult"));
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
