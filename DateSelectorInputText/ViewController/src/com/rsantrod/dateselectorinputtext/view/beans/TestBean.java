package com.rsantrod.dateselectorinputtext.view.beans;

import com.rsantrod.dateselectorinputtext.view.utils.JSFUtils;

import java.text.DateFormat;

import java.text.SimpleDateFormat;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.input.RichInputText;

public class TestBean {
    public TestBean() {
    }

    public void valueChangeDate(ValueChangeEvent valueChangeEvent) {
        RichInputText rit = (RichInputText)JSFUtils.findComponentInRoot("it1");
        //Formateamos la fecha
        java.util.Date dateVal = (java.util.Date)valueChangeEvent.getNewValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = dateFormat.format(dateVal);
        // Asignamos el valor
        rit.setValue(fecha);
    }
}
