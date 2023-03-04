package com.example.application.views.personal;

import org.apache.commons.lang3.RandomUtils;

public interface MedikalBilgiHesapla {
	
	public static double VkiHesapla(Double kilo,Double boy) {
	double vki = 0;
	double boykare = boy*boy;
	
	vki = kilo/boykare;
    vki = Math.round((kilo/boykare)*100.0)/100.0;
    return vki;
	
	}
	public static double VyaHesapla(Double kilo, Double boy) {
		double vya = 0;
		double boykilo = boy*kilo;
		 
		vya = Math.pow((boykilo/3600),2);
		vya = Math.round(Math.pow((boykilo/3600),2)*100.0)/100.0;
		return vya;
		
	}

}
