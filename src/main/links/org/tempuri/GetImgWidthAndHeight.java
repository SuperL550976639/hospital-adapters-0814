/**
 * GetImgWidthAndHeight.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

@SuppressWarnings("serial")
public class GetImgWidthAndHeight  implements java.io.Serializable {
    private java.lang.String UHID;

    private java.lang.String imgClsName;

    private java.lang.String imgName;

    public GetImgWidthAndHeight() {
    }

    public GetImgWidthAndHeight(
           java.lang.String UHID,
           java.lang.String imgClsName,
           java.lang.String imgName) {
           this.UHID = UHID;
           this.imgClsName = imgClsName;
           this.imgName = imgName;
    }


    /**
     * Gets the UHID value for this GetImgWidthAndHeight.
     * 
     * @return UHID
     */
    public java.lang.String getUHID() {
        return UHID;
    }


    /**
     * Sets the UHID value for this GetImgWidthAndHeight.
     * 
     * @param UHID
     */
    public void setUHID(java.lang.String UHID) {
        this.UHID = UHID;
    }


    /**
     * Gets the imgClsName value for this GetImgWidthAndHeight.
     * 
     * @return imgClsName
     */
    public java.lang.String getImgClsName() {
        return imgClsName;
    }


    /**
     * Sets the imgClsName value for this GetImgWidthAndHeight.
     * 
     * @param imgClsName
     */
    public void setImgClsName(java.lang.String imgClsName) {
        this.imgClsName = imgClsName;
    }


    /**
     * Gets the imgName value for this GetImgWidthAndHeight.
     * 
     * @return imgName
     */
    public java.lang.String getImgName() {
        return imgName;
    }


    /**
     * Sets the imgName value for this GetImgWidthAndHeight.
     * 
     * @param imgName
     */
    public void setImgName(java.lang.String imgName) {
        this.imgName = imgName;
    }

    private java.lang.Object __equalsCalc = null;
    @SuppressWarnings("unused")
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetImgWidthAndHeight)) return false;
        GetImgWidthAndHeight other = (GetImgWidthAndHeight) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.UHID==null && other.getUHID()==null) || 
             (this.UHID!=null &&
              this.UHID.equals(other.getUHID()))) &&
            ((this.imgClsName==null && other.getImgClsName()==null) || 
             (this.imgClsName!=null &&
              this.imgClsName.equals(other.getImgClsName()))) &&
            ((this.imgName==null && other.getImgName()==null) || 
             (this.imgName!=null &&
              this.imgName.equals(other.getImgName())));
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
        if (getUHID() != null) {
            _hashCode += getUHID().hashCode();
        }
        if (getImgClsName() != null) {
            _hashCode += getImgClsName().hashCode();
        }
        if (getImgName() != null) {
            _hashCode += getImgName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetImgWidthAndHeight.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetImgWidthAndHeight"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UHID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "UHID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("imgClsName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "imgClsName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("imgName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "imgName"));
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
