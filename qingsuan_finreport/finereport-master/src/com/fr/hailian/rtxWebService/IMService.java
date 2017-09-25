package com.fr.hailian.rtxWebService;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.12
 * 2017-08-24T10:33:33.834+08:00
 * Generated source version: 3.1.12
 * 
 */
@WebServiceClient(name = "IMService", 
                  wsdlLocation = "http://10.0.6.41:8089/NWHServiceIM.asmx?wsdl",
                  targetNamespace = "http://www.nwh.cn/Rpc") 
public class IMService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.nwh.cn/Rpc", "IMService");
    public final static QName IMServiceSoap = new QName("http://www.nwh.cn/Rpc", "IMServiceSoap");
    public final static QName IMServiceSoap12 = new QName("http://www.nwh.cn/Rpc", "IMServiceSoap12");
    static {
        URL url = null;
        try {
            url = new URL("http://10.0.6.41:8089/NWHServiceIM.asmx?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(IMService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://10.0.6.41:8089/NWHServiceIM.asmx?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public IMService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public IMService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public IMService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public IMService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public IMService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public IMService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns IMServiceSoap
     */
    @WebEndpoint(name = "IMServiceSoap")
    public IMServiceSoap getIMServiceSoap() {
        return super.getPort(IMServiceSoap, IMServiceSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IMServiceSoap
     */
    @WebEndpoint(name = "IMServiceSoap")
    public IMServiceSoap getIMServiceSoap(WebServiceFeature... features) {
        return super.getPort(IMServiceSoap, IMServiceSoap.class, features);
    }


    /**
     *
     * @return
     *     returns IMServiceSoap
     */
    @WebEndpoint(name = "IMServiceSoap12")
    public IMServiceSoap getIMServiceSoap12() {
        return super.getPort(IMServiceSoap12, IMServiceSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IMServiceSoap
     */
    @WebEndpoint(name = "IMServiceSoap12")
    public IMServiceSoap getIMServiceSoap12(WebServiceFeature... features) {
        return super.getPort(IMServiceSoap12, IMServiceSoap.class, features);
    }

}