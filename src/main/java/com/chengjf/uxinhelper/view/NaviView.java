package com.chengjf.uxinhelper.view;


import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.*;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.themes.ValoTheme;

@SpringUI(path = "/")
@SpringViewDisplay
public class NaviView extends UI {

    @Override
    protected void init(VaadinRequest request) {

        Panel panel = new Panel();
        panel.setSizeFull();

        Navigator navigator = new Navigator(this, panel);
        navigator.addView("md5", MD5View.class);
        navigator.addView("json", JsonView.class);
        navigator.addView("", DefaultView.class);
        navigator.navigateTo("");

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

        MenuBar.MenuItem booking = menuBar.addItem("Test", null);

        booking.addItem("test", (MenuBar.Command) selectedItem -> getNavigator().navigateTo(""));

        booking.addItem("test", (MenuBar.Command) selectedItem -> getNavigator().navigateTo(""));

        return menuBar;
    }

    private Button createNavigationButton(String caption,
                                          final String viewName) {
        Button button = new Button(caption);
        button.addStyleName(ValoTheme.BUTTON_SMALL);
        button.addClickListener(
                event -> getUI().getNavigator().navigateTo(viewName));
        return button;
    }


}
