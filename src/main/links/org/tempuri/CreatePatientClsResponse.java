/**
 * CreatePatientClsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class CreatePatientClsResponse  implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2264934971606397453L;
	private int createPatientClsResult;

    public CreatePatientClsResponse() {
    }

    public CreatePatientClsResponse(
           int createPatientClsResult) {
           this.createPatientClsResult = createPatientClsResult;
    }


    /**
     * Gets the createPatientClsResult value for this CreatePatientClsResponse.
     * 
     * @return createPatientClsResult
     */
    public int getCreatePatientClsResult() {
        return createPatientClsResult;
    }


    /**
     * Sets the createPatientClsResult value for this CreatePatientClsResponse.
     * 
     * @param createPatientClsResult
     */
    public void setCreatePatientClsResult(int createPatientClsResult) {
        this.createPatientClsResult = createPatientClsResult;
    }

    private java.lang.Object __equalsCalc = null;
    @SuppressWarnings("unused")
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CreatePatientClsResponse)) return false;
        CreatePatientClsResponse other = (CreatePatientClsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.createPatientClsResult == other.getCreatePatientClsResult();
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
        _hashCode += getCreatePatientClsResult();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CreatePatientClsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">CreatePatientClsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("createPatientClsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "CreatePatientClsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
