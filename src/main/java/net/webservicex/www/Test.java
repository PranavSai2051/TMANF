package net.webservicex.www;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

public class Test {
	
	public static void main(String[] args) throws ServiceException, RemoteException {
			GeoIPServiceLocator geoIPServiceLocator = new GeoIPServiceLocator();
			GeoIPServiceSoapStub geoIPServiceSoapStub = (GeoIPServiceSoapStub) geoIPServiceLocator.getGeoIPServiceSoap();
			GeoIP geoIP = geoIPServiceSoapStub.getGeoIP("73.195.31.215");
			System.out.println(geoIP.getCountryName());
		}
		
		
	}


