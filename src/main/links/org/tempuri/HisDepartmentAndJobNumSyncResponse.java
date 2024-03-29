/**
 * HisDepartmentAndJobNumSyncResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

@SuppressWarnings("serial")
public class HisDepartmentAndJobNumSyncResponse  implements java.io.Serializable {
    private java.lang.String hisDepartmentAndJobNumSyncResult;

    public HisDepartmentAndJobNumSyncResponse() {
    }

    public HisDepartmentAndJobNumSyncResponse(
           java.lang.String hisDepartmentAndJobNumSyncResult) {
           this.hisDepartmentAndJobNumSyncResult = hisDepartmentAndJobNumSyncResult;
    }


    /**
     * Gets the hisDepartmentAndJobNumSyncResult value for this HisDepartmentAndJobNumSyncResponse.
     * 
     * @return hisDepartmentAndJobNumSyncResult
     */
    public java.lang.String getHisDepartmentAndJobNumSyncResult() {
        return hisDepartmentAndJobNumSyncResult;
    }


    /**
     * Sets the hisDepartmentAndJobNumSyncResult value for this HisDepartmentAndJobNumSyncResponse.
     * 
     * @param hisDepartmentAndJobNumSyncResult
     */
    public void setHisDepartmentAndJobNumSyncResult(java.lang.String hisDepartmentAndJobNumSyncResult) {
        this.hisDepartmentAndJobNumSyncResult = hisDepartmentAndJobNumSyncResult;
    }

    private java.lang.Object __equalsCalc = null;
    @SuppressWarnings("unused")
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof HisDepartmentAndJobNumSyncResponse)) return false;
        HisDepartmentAndJobNumSyncResponse other = (HisDepartmentAndJobNumSyncResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.hisDepartmentAndJobNumSyncResult==null && other.getHisDepartmentAndJobNumSyncResult()==null) || 
             (this.hisDepartmentAndJobNumSyncResult!=null &&
              this.hisDepartmentAndJobNumSyncResult.equals(other.getHisDepartmentAndJobNumSyncResult())));
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
        if (getHisDepartmentAndJobNumSyncResult() != null) {
            _hashCode += getHisDepartmentAndJobNumSyncResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(HisDepartmentAndJobNumSyncResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">HisDepartmentAndJobNumSyncResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hisDepartmentAndJobNumSyncResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "HisDepartmentAndJobNumSyncResult"));
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
