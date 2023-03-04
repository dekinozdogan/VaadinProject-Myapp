package com.example.application.views.personal.presenter;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.tuple.Pair;

import com.example.application.views.personal.model.Gender;
import com.example.application.views.personal.model.Personel;

public class PersonelViewPresenter {
	
	public static List<Personel> getPersonelList(){
		
		
   List<Pair<String, Gender>> nameList = Arrays.asList(Pair.of("Seda", Gender.FEMALE),Pair.of("Ali", Gender.MALE),Pair.of("Orhan",Gender.MALE),Pair.of("Selin", Gender.FEMALE),Pair.of("Yasemin",Gender.FEMALE),Pair.of("Fatih",Gender.MALE),Pair.of("Veli",Gender.MALE),Pair.of("Ayça",Gender.FEMALE),Pair.of("Zeki",Gender.MALE),Pair.of("Lale",Gender.FEMALE));
   List<String> surnameList =Arrays.asList("Yılmaz","Gürkan","Çevik","Çelik","Doğan","Eryılmaz","Kaya","Açık","Yıldız","Kayabeyi","Soy","Ömürlü","Çakar","Gürbüz","Uğurlu");
   List<Personel> personelList = new ArrayList<>();
  
  
   
   
    for (Pair<String, Gender> NAME: nameList) {
    	
    	for (String SURNAME: surnameList ) {
    		 Integer yas = RandomUtils.nextInt(15,70);
    		 
    		System.out.println(NAME);
    	    System.out.println(SURNAME);
    	   
    	   Personel personel = new Personel();
    	   personel.setName(NAME.getLeft());
    	   personel.setGender(NAME.getRight());
     	   personel.setSurName(SURNAME);
     	   personel.setAge(yas);
     	   
     	  personelList.add(personel);
     	    
     	   }
     	  
    	}
    	 
	return personelList;	
	}
    }