package com.chengjf.uxinhelper.view;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;

@Route("")
@PageTitle("Helper")
public class NaviView extends Div implements RouterLayout {

    public NaviView() {

        H2 title = new H2("Helper");

        ListBox<RouterLink> listBox = new ListBox<>();
        //        listBox.add(new RouterLink("Home", MainView.class));
        listBox.add(new RouterLink("MD5", MD5View.class));
        //        listBox.add(new RouterLink("article", ArticleView.class));
        listBox.add(new RouterLink("Json", JsonView.class));
        add(title, listBox);


    }

}
