package com.chengjf.uxinhelper.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by jeff on 2018/8/5.
 */

@SpringView
@SpringUI
@Slf4j
public class ErrorView extends VerticalLayout implements View {

    private Label label;

    public ErrorView() {
        label = new Label("Hello, this is the 'error view' loaded if no view is matched based on URL.");
        addComponent(label);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        log.info("Error:{}", event);
        label.setValue("Cannot navigate to " + event.getViewName());
    }
}
