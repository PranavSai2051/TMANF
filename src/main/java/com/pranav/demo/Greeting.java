package com.pranav.demo;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.webservicex.www.GeoIP;
import net.webservicex.www.GeoIPServiceLocator;
import net.webservicex.www.GeoIPServiceSoapStub;

@Controller
public class Greeting {
	@RequestMapping("/greet")
	public @ResponseBody String greet() throws ServiceException, RemoteException {
		GeoIPServiceLocator geoIPServiceLocator = new GeoIPServiceLocator();
		GeoIPServiceSoapStub geoIPServiceSoapStub = (GeoIPServiceSoapStub) geoIPServiceLocator.getGeoIPServiceSoap();
		GeoIP geoIP = geoIPServiceSoapStub.getGeoIP("73.195.31.215");
		return geoIP.getCountryName();
		
	}
	
}
