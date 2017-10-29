package com.pranav.demo;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.webservicex.www.GeoIP;
import net.webservicex.www.GeoIPServiceLocator;
import net.webservicex.www.GeoIPServiceSoapStub;

@Controller
public class Greeting {
	@RequestMapping(value = "/{ipaddress}")
	public  String greet(@PathVariable String ipaddress) throws ServiceException, RemoteException {
		GeoIPServiceLocator geoIPServiceLocator = new GeoIPServiceLocator();
		GeoIPServiceSoapStub geoIPServiceSoapStub = (GeoIPServiceSoapStub) geoIPServiceLocator.getGeoIPServiceSoap();
		GeoIP geoIP = geoIPServiceSoapStub.getGeoIP(ipaddress+".5");
		return geoIP.getCountryName()+":::::"+geoIP.getCountryCode();
		
	}
	
}
