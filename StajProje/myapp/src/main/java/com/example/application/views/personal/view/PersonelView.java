package com.example.application.views.personal.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;

import com.example.application.views.personal.model.Gender;
import com.example.application.views.personal.model.Personel;
import com.example.application.views.personal.presenter.PersonelViewPresenter;
import com.vaadin.flow.component.Component;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.SelectionMode;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;

@Route(value = "personel", layout = MainView.class)
@PageTitle("Personel")

public class PersonelView extends Div {
	private Grid<Personel> personelGrid;
	private ListDataProvider<Personel> dataProvider;
    private TextField textfield;
   
    
   
	public PersonelView() {
		addClassName("Personel-view");
		GridAndFill();
		
		
		add(personelGrid);

	}
    private void turkishcharachters() {
    	List<Pair<String,String>> tchar = new ArrayList<>();
    	tchar.add(Pair.of("c","ç"));
    	tchar.add(Pair.of("ı","i"));
    	tchar.add(Pair.of("o","ö"));
    	tchar.add(Pair.of("s","ş"));
    	tchar.add(Pair.of("g","ğ"));
    	tchar.add(Pair.of("s","ş"));
    	
    	for (Pair<String, String> tc : tchar) {
    		for (Personel per : PersonelViewPresenter.getPersonelList()) {
    			if (per.getName().contains(tc.getLeft())) {
    				per.getName().replace(tc.getRight(),tc.getLeft());
    					
    				}
    			}
    		}
    		
    	}
    	
    	
    
	private void GridAndFill() {
		
		textfield = new TextField();
		textfield.setValue("Enter your name ");
		textfield.setValueChangeMode(ValueChangeMode.EAGER);
		textfield.addValueChangeListener(e -> setGridFilterWithText());
        
		add(textfield);

    
		personelGrid = new Grid<>();
		personelGrid.setItems(PersonelViewPresenter.getPersonelList());
		dataProvider = (ListDataProvider< Personel >) personelGrid.getDataProvider();
		personelGrid.addColumn(e -> e.getName()).setHeader("First Name");
		personelGrid.addColumn(e -> e.getSurName()).setHeader("Last Name");
		personelGrid.addColumn(e -> e.getAge()).setHeader("Age");

		personelGrid.addSelectionListener(e -> {
			Personel personel = e.getAllSelectedItems().stream().findFirst().orElse(null);
//				Personel sonPersonel = e.getAllSelectedItems().stream().collect(Collectors.toList()).get(e.getAllSelectedItems().stream().collect(Collectors.toList()).size()-1);

			if (personel != null) {
				Dialog dialog = new Dialog();
				dialog.setCloseOnOutsideClick(false);
			    dialog.getElement().setAttribute("theme", "padding: 0px");
				

				VerticalLayout rootLayout = new VerticalLayout(createDialogHeader(personel),
						createDialogContent(personel), createDialogFooter(dialog));
				rootLayout.setMargin(false);
				rootLayout.setPadding(false);
				rootLayout.setSpacing(false);

				dialog.add(rootLayout);

				dialog.open();
			}
		});

		personelGrid.addThemeVariants(GridVariant.LUMO_COLUMN_BORDERS, GridVariant.LUMO_ROW_STRIPES);

		personelGrid.getStyle().set("color", "blueviolet");
		personelGrid.getStyle().set("font-family", "cursive");
		personelGrid.getStyle().set("font-size", "larger");

		// PersonelGrid.setSelectionMode(SelectionMode.MULTI);

		personelGrid.addSelectionListener(e -> {
			Personel personel = e.getAllSelectedItems().stream().findFirst().orElse(null);
			Personel sonPersonel = e.getAllSelectedItems().stream().collect(Collectors.toList())
					.get(e.getAllSelectedItems().stream().collect(Collectors.toList()).size() - 1);
		});

		personelGrid.addComponentColumn(personel -> {
			HorizontalLayout horizontalLayout = new HorizontalLayout();
			VerticalLayout verticalLayout = new VerticalLayout();

			if (Gender.FEMALE.equals(personel.getGender())) {
				verticalLayout.add(getIcon(personel.getGender()));
				Label genderLabel = (new Label(Gender.FEMALE.toString()));
				genderLabel.getStyle().set("background", "pink");
				verticalLayout.add(genderLabel);

				return verticalLayout;

			} else if (Gender.MALE.equals(personel.getGender())) {
				horizontalLayout.add(getIcon(personel.getGender()));
				Label genderLabel = (new Label(Gender.MALE.toString()));
				genderLabel.getStyle().set("background", "lightblue");
				horizontalLayout.add(genderLabel);

				return horizontalLayout;
			}

			return new HorizontalLayout();

		}).setHeader("Gender");

	}

	public Icon getIcon(Gender gender) {
		if (Gender.FEMALE.equals(gender)) {
			Icon logo = new Icon(VaadinIcon.FEMALE);
			logo.setSize("100000px");
			logo.setColor("darkpink");

			return VaadinIcon.FEMALE.create();

		} else if (Gender.MALE.equals(gender)) {
			Icon logo = new Icon(VaadinIcon.MALE);
			logo.setSize("100000px");
			logo.setColor("darkpink");
			return VaadinIcon.MALE.create();

		}
		return VaadinIcon.MALE.create();
	}

	private Component createDialogHeader(Personel personel) {
		// TODO Auto-generated method stub
		HorizontalLayout hlay = new HorizontalLayout();
		Label comp = new Label(" "+ personel.getName() + " " + personel.getSurName());
		comp.getStyle().set("font-weight","bold");
		comp.getStyle().set("font-style","italic");
		comp.getStyle().set("color","darkgreen");
		comp.getStyle().set("font-size", "x-large");
		
		hlay.add(comp);
		
		return  hlay;
	}

	private Component createDialogContent(Personel personel) {
		// TODO Auto-generated method stub
		VerticalLayout vlay = new VerticalLayout();
		Label comp1 = new Label("Age: "+personel.getAge().toString());
	    Label comp2 = new Label("Gender: " + personel.getGender().toString());
	    vlay.getStyle().set("font-size","35");
	    comp1.getStyle().set("font-weight","bold");
	    comp2.getStyle().set("font-weight","bold");
	    comp1.getStyle().set("color","purple");
	    comp2.getStyle().set("color","orange");
		vlay.add(comp1);
		vlay.add(comp2);
		if (personel.getGender().toString().equals("FEMALE")) {
			Icon logo = new Icon(VaadinIcon.FEMALE);
			logo.setSize("30px");
			logo.setColor("darkpink");
			vlay.add(logo);
		}
		else if(personel.getGender().toString().equals("MALE")) {
			Icon logo = new Icon(VaadinIcon.MALE);
			logo.setSize("30px");
			logo.setColor("darkpink");
			vlay.add(logo);
		}
		return vlay;
	}

	private Component createDialogFooter(Dialog dialog) {
		Button button = new Button();
		button.setIcon(VaadinIcon.ANGLE_LEFT.create());
		button.setText("Exit");
		button.getStyle().set("color", "red");
		button.addClickListener(e -> dialog.close());

		return button;
	}
	
	private void setGridFilterWithText() {
		String filterText = textfield.getValue();

		 
		    	List<Pair<String,String>> tchar = new ArrayList<>();
		    	tchar.add(Pair.of("c","ç"));
		    	tchar.add(Pair.of("ı","i"));
		    	tchar.add(Pair.of("o","ö"));
		    	tchar.add(Pair.of("s","ş"));
		    	tchar.add(Pair.of("g","ğ"));
		    	tchar.add(Pair.of("s","ş"));
		    	
		    	for (Pair<String, String> tc : tchar) {
		    		for (Personel per : PersonelViewPresenter.getPersonelList()) {
		    			if (per.getName().contains(tc.getLeft())) {
		    				per.getName().replace(tc.getRight(),tc.getLeft());
		    					
		    				}
		    			}
		    		dataProvider.clearFilters();

		    		dataProvider.setFilter(ifd -> isGridFilterItemNames(ifd, filterText));

		    		personelGrid.getDataProvider().refreshAll();

		    		}
		    		}
		    		
		
		private Boolean isGridFilterItemNames(Personel personel, String filterText) {
	   
		return personel.getName().toLowerCase().replace("ı", "").replace("i", "").contains(filterText.toLowerCase().replace("ı", "").replace("i", "")) || personel.getName().toLowerCase().replace("c"," ").replace("ç", " ").contains(filterText.toLowerCase().replace("c"," ").replace("ç", " "))
		|| personel.getName().toLowerCase(Locale.forLanguageTag("TR")).contains(filterText.toLowerCase());
		
		
		}
		

}

	
	
	

