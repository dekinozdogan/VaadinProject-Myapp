package com.example.application.views.personal;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomUtils;
import org.apache.tomcat.util.descriptor.web.FilterMap;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;

import ch.qos.logback.core.filter.Filter;

public class Hasta {
	private Integer hastaNo;
	private String hastaAdı;
	private String hastaSoyadı;
	private Vector<Integer> hastaTcKimlikNumarası;
	private Double hastaboy;
	private Double hastakilo;

	public Double gethastaboy() {
		return hastaboy;
	}

	public void sethastaboy(Double hastaboy) {
		this.hastaboy = hastaboy;
	}

	public Double gethastakilo() {
		return hastakilo;
	}

	public void sethastakilo(Double hastakilo) {
		this.hastakilo = hastakilo;
	}

	public Integer gethastaNo() {
		return hastaNo;
	}

	public void sethastaNo(Integer hastaNo) {
		this.hastaNo = hastaNo;
	}

	public String getHastaAdı() {
		return hastaAdı;
	}

	public void sethastaAdı(String hastaAdı) {
		this.hastaAdı = hastaAdı;
	}

	public String gethastaSoyadı() {
		return hastaSoyadı;
	}

	public void sethastaSoyadı(String hastaSoyadı) {
		this.hastaSoyadı = hastaSoyadı;
	}

	public void setHastaTcKimlikNumarası(Vector<Integer> hastaTcKimlikNumarası) {
		this.hastaTcKimlikNumarası = hastaTcKimlikNumarası;
	}

	public static List<Hasta> getHastalist() {
		List<Hasta> Hastalist = new ArrayList<>();
		List<String> nameList = Arrays.asList("Lale", "Mehmet", "Salih", "Meltem", "Esra", "Zeynep", "Tamer", "Onur",
				"Asya", "Hülya", "Resul", "Şermin", "Polat", "Rengin", "Ömer");
		List<String> surnameList = Arrays.asList("Yılmaz", "Gürkan", "Çevik", "Çelik", "Doğan", "Eryılmaz", "Kaya",
				"Açık", "Yıldız", "Kayabeyi", "Soy", "Ömürlü", "Çakar", "Gürbüz", "Uğurlu");

		for (String ad : nameList) {
			for (String soyad : surnameList) {
				Integer hastaNo = RandomUtils.nextInt(0, 100);
				Double hastaboy = Math.round(RandomUtils.nextDouble(1.45, 2.00)*100.0)/100.0;
				Double hastakilo = Math.round(RandomUtils.nextDouble(45, 150)*100.0)/100.0;
				Vector<Integer> hastaTcKimlikNumarası = getHastaTcKimlikNumarası();
				Hasta hasta = new Hasta();

				hasta.sethastaAdı(ad);
				hasta.sethastaSoyadı(soyad);
				hasta.sethastaNo(hastaNo);
				hasta.setHastaTcKimlikNumarası(hastaTcKimlikNumarası);
				hasta.sethastaboy(hastaboy);
				hasta.sethastakilo(hastakilo);

				Hastalist.add(hasta);
			}

		}

		return Hastalist;

	}

	public static Set<Hasta> getHastaSet() {
		return getHastalist().stream().collect(Collectors.toSet());
	}
    public static List<Hasta> getHastalist1() {
		
    	return getHastalist1().stream().collect(Collectors.toList());
    	}
	public static void converListToSet(List<Hasta> list) {
		Set<Hasta> set = list.stream().collect(Collectors.toSet());

		set.forEach(hasta -> System.out.println(hasta));
	}

	public static Map<String,List<Hasta>> hastamap () {
		Map<String,List<Hasta>> map = Hasta.getHastalist().stream().collect(Collectors.groupingBy(Hasta:: getHastaAdı));
	
		return map;
		}
	
	public static Vector<Integer> getHastaTcKimlikNumarası() {

		Vector<Integer> hastaTcKimlikNumarası = new Vector<Integer>();
		Random randomGenerator = new Random();

		hastaTcKimlikNumarası.add(new Integer(1 + randomGenerator.nextInt(9)));

		for (int i = 1; i < 9; i++)
			hastaTcKimlikNumarası.add(randomGenerator.nextInt(10));

		int t1 = 0;
		for (int i = 0; i < 9; i += 2)
			t1 += hastaTcKimlikNumarası.elementAt(i);

		int t2 = 0;
		for (int i = 1; i < 8; i += 2)
			t2 += hastaTcKimlikNumarası.elementAt(i);

		int x = (t1 * 7 - t2) % 10;

		hastaTcKimlikNumarası.add(new Integer(x));

		x = 0;
		for (int i = 0; i < 10; i++)
			x += hastaTcKimlikNumarası.elementAt(i);

		x = x % 10;
		hastaTcKimlikNumarası.add(new Integer(x));

		String res = "";
		for (int i = 0; i < 11; i++)
			res = res + Integer.toString(hastaTcKimlikNumarası.elementAt(i));

		return hastaTcKimlikNumarası;
	}

	
	
}
