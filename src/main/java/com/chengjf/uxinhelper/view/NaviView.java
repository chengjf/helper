package com.chengjf.uxinhelper.view;


import com.chengjf.uxinhelper.service.YoutubeService;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.*;
import com.vaadin.ui.MenuBar.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@SpringViewDisplay
public class NaviView extends UI {

    @Autowired
    private YoutubeService youtubeService;

    @Autowired
    private SpringViewProvider springViewProvider;

    @Autowired
    private SpringViewProvider springErrorViewProvider;

    @Override
    protected void init(VaadinRequest request) {

        Panel panel = new Panel();
        panel.setSizeFull();

        springErrorViewProvider.setAccessDeniedViewClass(ErrorView.class);

        Navigator navigator = new Navigator(this, panel);
        navigator.addProvider(this.springViewProvider);
        navigator.setErrorProvider(springErrorViewProvider);
        navigator.setErrorView(ErrorView.class);
        setNavigator(navigator);

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setSizeFull();
        verticalLayout.addComponent(createMenu());
        verticalLayout.addComponent(panel);
        verticalLayout.setExpandRatio(panel, 1);
        setContent(verticalLayout);

    }

    private Component createMenu() {
        MenuBar menuBar = new MenuBar();

        MenuItem administration = menuBar.addItem("Tools", null);
        administration.addItem("md5", (MenuBar.Command) selectedItem -> getNavigator().navigateTo("md5"));
        administration.addItem("json", (MenuBar.Command) selectedItem -> getNavigator().navigateTo("json"));
        administration.addItem("youtube", (MenuBar.Command) selectedItem -> getNavigator().navigateTo("youtube"));

//        MenuBar.MenuItem booking = menuBar.addItem("Test", null);
//        booking.addItem("test", (MenuBar.Command) selectedItem -> getNavigator().navigateTo(""));
//        booking.addItem("test", (MenuBar.Command) selectedItem -> getNavigator().navigateTo(""));

        return menuBar;
    }


}
