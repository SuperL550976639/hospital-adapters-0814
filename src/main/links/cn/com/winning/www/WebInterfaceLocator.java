/**
 * WebInterfaceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.winning.www;

public class WebInterfaceLocator extends org.apache.axis.client.Service implements cn.com.winning.www.WebInterface {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WebInterfaceLocator() {
    }


    public WebInterfaceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WebInterfaceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WebInterfaceSoap
    private java.lang.String WebInterfaceSoap_address = "http://192.168.2.132:8099/WebInterface.asmx";

    public java.lang.String getWebInterfaceSoapAddress() {
        return WebInterfaceSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WebInterfaceSoapWSDDServiceName = "WebInterfaceSoap";

    public java.lang.String getWebInterfaceSoapWSDDServiceName() {
        return WebInterfaceSoapWSDDServiceName;
    }

    public void setWebInterfaceSoapWSDDServiceName(java.lang.String name) {
        WebInterfaceSoapWSDDServiceName = name;
    }

    public cn.com.winning.www.WebInterfaceSoap getWebInterfaceSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WebInterfaceSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWebInterfaceSoap(endpoint);
    }

    public cn.com.winning.www.WebInterfaceSoap getWebInterfaceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.com.winning.www.WebInterfaceSoapStub _stub = new cn.com.winning.www.WebInterfaceSoapStub(portAddress, this);
            _stub.setPortName(getWebInterfaceSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWebInterfaceSoapEndpointAddress(java.lang.String address) {
        WebInterfaceSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    @SuppressWarnings("rawtypes")
	public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (cn.com.winning.www.WebInterfaceSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.com.winning.www.WebInterfaceSoapStub _stub = new cn.com.winning.www.WebInterfaceSoapStub(new java.net.URL(WebInterfaceSoap_address), this);
                _stub.setPortName(getWebInterfaceSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    @SuppressWarnings("rawtypes")
	public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WebInterfaceSoap".equals(inputPortName)) {
            return getWebInterfaceSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.winning.com.cn/", "WebInterface");
    }

    @SuppressWarnings("rawtypes")
	private java.util.HashSet ports = null;

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.winning.com.cn/", "WebInterfaceSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WebInterfaceSoap".equals(portName)) {
            setWebInterfaceSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
