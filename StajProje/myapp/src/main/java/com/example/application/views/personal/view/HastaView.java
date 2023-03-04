package com.example.application.views.personal.view;

import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.example.application.views.personal.Hasta;
import com.example.application.views.personal.MedikalBilgiHesapla;
import com.example.application.views.personal.MedikalBilgiHesaplaImpl;
import com.example.application.views.personal.model.Personel;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;

@Route(value = "hasta", layout = MainView.class)
@PageTitle("Hasta")
public class HastaView extends Div {

	public HastaView() {
		addClassName("Hasta-view");
		createLayout();
		createLayoutSet();
		createmapLayout();
		createLayoutList();
		//createDialogContent();

	}
	private void createmapLayout() {
		VerticalLayout rootLayout = new VerticalLayout();
		for (Entry<String, List<Hasta>> entry : Hasta.hastamap().entrySet()) {

			Label adlabel = new Label();
			adlabel.setText("Hasta Adı: " + entry.getKey());
			adlabel.getStyle().set("color", "red");
			adlabel.getStyle().set("font-weight", "bold");
			adlabel.getStyle().set("font-style","italic");
			rootLayout.add(adlabel);
			
			int i =1;
			for (Hasta hasta : entry.getValue()) {
				
				Label tcLabel_1 = new Label();
				String tcno="";
				for (Integer no : hasta.getHastaTcKimlikNumarası()) {
					tcno = tcno.concat(no.toString());
				}
			    
				tcLabel_1.add(" TC " + i +" : " + tcno);
				i++;
				tcLabel_1.getStyle().set("color", "coral");
				tcLabel_1.getStyle().set("font-weight", "bold");
				tcLabel_1.getStyle().set("font-style", "italic");
				
				
				rootLayout.add(tcLabel_1);
				
			}
		}
        add(rootLayout);
	}
	
	private void createLayout() {
		VerticalLayout hastaLayout = new VerticalLayout();
		for (Hasta hasta : Hasta.getHastalist()) {
			Label label = new Label();

			String tcNo = "";

			for (Integer no : hasta.getHastaTcKimlikNumarası()) {
				tcNo = tcNo.concat(no.toString());
				String tcno="";
				
			}
			label.getStyle().set("font-weight", "bold");
			label.getStyle().set("color", "purple");
			label.setText("Ad: " + hasta.getHastaAdı() + " Tc: " + tcNo + " Boy: " + hasta.gethastaboy() + " Kilo: "
					+ hasta.gethastakilo());

			hastaLayout.add(label);

		}
		add(hastaLayout);
	}

	public HorizontalLayout getAdLayout(Hasta hasta) {
		HorizontalLayout adLayout = new HorizontalLayout();
//		adLayout.setSpacing(false);
		Label adLabel = new Label();
		Label adLabel_1 = new Label();
		adLabel.setText(" Adı: ");
		adLabel.getStyle().set("color", "green");
		adLabel.getStyle().set("font-weight", "bold");
		adLabel_1.getStyle().set("color", "purple");
		adLabel_1.getStyle().set("font-weight", "bold");

		adLabel_1.setText(hasta.getHastaAdı());

		adLayout.add(adLabel);
		adLayout.add(adLabel_1);
		return adLayout;
	}

	public HorizontalLayout getSoyadLayout(Hasta hasta) {
		HorizontalLayout soyadLayout = new HorizontalLayout();
		Label soyadLabel = new Label();
		Label soyadLabel_1 = new Label();
		soyadLabel.setText(" Soyad: ");
		soyadLabel.getStyle().set("color", "green");
		soyadLabel.getStyle().set("font-weight", "bold");
		soyadLabel_1.getStyle().set("color", "purple");
		soyadLabel_1.getStyle().set("font-weight", "bold");
		soyadLabel_1.setText(hasta.gethastaSoyadı());

		soyadLayout.add(soyadLabel);
		soyadLayout.add(soyadLabel_1);

		return soyadLayout;
	}

	public HorizontalLayout getboyLayout(Hasta hasta) {
		HorizontalLayout boyLayout = new HorizontalLayout();
		Label boyLabel = new Label();
		Label boyLabel_1 = new Label();
		boyLabel.setText(" Boy: ");
		boyLabel_1.setText(hasta.gethastaboy().toString());
		boyLabel.getStyle().set("color", "green");
		boyLabel.getStyle().set("font-weight", "bold");
		boyLabel_1.getStyle().set("color", "purple");
		boyLabel_1.getStyle().set("font-weight", "bold");
		boyLayout.add(boyLabel, boyLabel_1);

		return boyLayout;
	}

	public HorizontalLayout getkiloLayout(Hasta hasta) {
		HorizontalLayout kiloLayout = new HorizontalLayout();
		Label kiloLabel = new Label();
		Label kiloLabel_1 = new Label();
		kiloLabel.setText(" Kilo: ");
		kiloLabel_1.setText(hasta.gethastakilo().toString());
		kiloLabel.getStyle().set("color", "green");
		kiloLabel.getStyle().set("font-weight", "bold");
		kiloLabel_1.getStyle().set("color", "purple");
		kiloLabel_1.getStyle().set("font-weight", "bold");
		kiloLayout.add(kiloLabel, kiloLabel_1);
		return kiloLayout;
	}

	public HorizontalLayout getVkiHesapla(Hasta hasta) {
		HorizontalLayout vkiLayout = new HorizontalLayout();
		Label vkiLabel = new Label();
		Label vkiLabel_1 = new Label();
		vkiLabel.setText(" Vki: ");
		Double vki = MedikalBilgiHesapla.VkiHesapla(hasta.gethastakilo(), hasta.gethastaboy());
		vkiLabel_1.setText(vki.toString());
		vkiLabel.getStyle().set("color", "green");
		vkiLabel.getStyle().set("font-weight", "bold");
		vkiLabel_1.getStyle().set("color", "purple");
		vkiLabel_1.getStyle().set("font-weight", "bold");
		// vkiLabel.getStyle().set(null, null)
		vkiLayout.add(vkiLabel, vkiLabel_1);
		return vkiLayout;
	}

	public HorizontalLayout getVyaHesapla(Hasta hasta) {
		HorizontalLayout vyaLayout = new HorizontalLayout();
		Label vyaLabel = new Label();
		Label vyaLabel_1 = new Label();
		vyaLabel.setText(" Vya: ");
		Double vya = MedikalBilgiHesapla.VyaHesapla(hasta.gethastakilo(), hasta.gethastaboy());
		vyaLabel_1.setText(vya.toString());
		vyaLabel.getStyle().set("color", "green");
		vyaLabel.getStyle().set("font-weight", "bold ");
		vyaLabel_1.getStyle().set("color", "purple");
		vyaLabel_1.getStyle().set("font-weight", "bold");
		vyaLayout.add(vyaLabel, vyaLabel_1);
		return vyaLayout;
	}

	public HorizontalLayout gettcLayout(Hasta hasta) {
		String tcNo = "";
		for (Integer no : hasta.getHastaTcKimlikNumarası()) {
			tcNo = tcNo.concat(no.toString());
		}
		HorizontalLayout tcLayout = new HorizontalLayout();
		Label tcLabel = new Label();
		Label tcLabel_1 = new Label();
		tcLabel.setText(" TC: ");

		tcLabel_1.setText(tcNo);
		tcLabel.getStyle().set("color", "green");
		tcLabel_1.getStyle().set("color", "purple");
		tcLabel.getStyle().set("font-weight", "bold");
		tcLabel_1.getStyle().set("font-weight", "bold");

		tcLayout.add(tcLabel, tcLabel_1);

		return tcLayout;

	}



	public void createLayoutSet() {

		VerticalLayout hastaLayout = new VerticalLayout();

		for (Hasta hasta : Hasta.getHastaSet()) {
			Label label = new Label();

			String tcNo = "";
			for (Integer no : hasta.getHastaTcKimlikNumarası()) {
				tcNo = tcNo.concat(no.toString());
			}
	
			
			HorizontalLayout hlay = new HorizontalLayout();
			hlay.add(getAdLayout(hasta));
			hlay.add(getSoyadLayout(hasta));
			hlay.add(gettcLayout(hasta));
			hlay.add(getkiloLayout(hasta));
			hlay.add(getboyLayout(hasta));
			hlay.add(getVkiHesapla(hasta));
			hlay.add(getVyaHesapla(hasta));
			hastaLayout.add(hlay);

			Hr hr = new Hr();

			hastaLayout.add(hr, hlay);
		}
 
		add(hastaLayout);

	}
          public void createLayoutList() {
        	  VerticalLayout hastalayout = new VerticalLayout();
        	  for (Hasta hasta : Hasta.getHastaSet()) {
      			Label label = new Label();

      			String tcNo = "";
      			for (Integer no : hasta.getHastaTcKimlikNumarası()) {
      				tcNo = tcNo.concat(no.toString());
      			}
      	
      			
      			HorizontalLayout hlay = new HorizontalLayout();
      			hlay.add(getAdLayout(hasta));
      			hlay.add(getSoyadLayout(hasta));
      			hlay.add(gettcLayout(hasta));
      			hlay.add(getkiloLayout(hasta));
      			hlay.add(getboyLayout(hasta));
      			hlay.add(getVkiHesapla(hasta));
      			hlay.add(getVyaHesapla(hasta));
      			hastalayout.add(hlay);

      			Hr hr = new Hr();

      			hastalayout.add(hr, hlay);
      		}
       
      		add(hastalayout);

        	  }
          private Component createDialogHeader(Hasta  hasta) {
      		// TODO Auto-generated method stub
      		HorizontalLayout hastaLay = new HorizontalLayout();
      		Label comp = new Label(" "+ getVkiHesapla(hasta) + " " + getVyaHesapla(hasta));
      		comp.getStyle().set("font-weight","bold");
      		comp.getStyle().set("font-style","italic");
      		comp.getStyle().set("color","darkgreen");
      		comp.getStyle().set("font-size", "x-large");
      		
      		hastaLay.add(comp);
      		
      		return  hastaLay;
      	}

}
