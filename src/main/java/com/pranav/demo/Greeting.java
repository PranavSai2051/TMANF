package com.pranav.demo;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import net.webservicex.www.GeoIP;
import net.webservicex.www.GeoIPServiceLocator;
import net.webservicex.www.GeoIPServiceSoapStub;

@Controller
public class Greeting {
	
	@RequestMapping("/")  
	public String index(){  
		return"index";  
	}  
	@RequestMapping(value="/save", method=RequestMethod.POST)  
	public ModelAndView save(@ModelAttribute IpAdd ipadd) throws RemoteException, ServiceException{ 
		
		GeoIPServiceLocator geoIPServiceLocator = new GeoIPServiceLocator();
		GeoIPServiceSoapStub geoIPServiceSoapStub = (GeoIPServiceSoapStub) geoIPServiceLocator.getGeoIPServiceSoap();
		GeoIP geoIP = geoIPServiceSoapStub.getGeoIP(ipadd.getName());
		ipadd.setGetAddress(geoIP.getCountryName());
		ModelAndView modelAndView = new ModelAndView();  
		modelAndView.setViewName("user-data");      
		modelAndView.addObject("ipadd", ipadd);    
		return modelAndView;  
	}  
	
}
