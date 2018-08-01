package com.chengjf.uxinhelper.view;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = "default")
public class DefaultView extends VerticalLayout implements View {

    public DefaultView() {

        Label label = new Label("Welcome to Helper!");
        addComponent(label);
        setComponentAlignment(label, Alignment.MIDDLE_CENTER);

    }
}