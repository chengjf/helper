package com.chengjf.uxinhelper.view;

import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("main")
public class MainView extends VerticalLayout {

    public MainView() {


        NativeButton link = new NativeButton("Navigate to MD5");
        link.addClickListener(e -> {
            link.getUI().ifPresent(ui -> ui.navigate(MD5View.class));
        });

        add(link);

    }
}