package com.chengjf.uxinhelper.view;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("")
@PageTitle("主页")
public class NaviView extends VerticalLayout {

    public NaviView() {


        ListBox<RouterLink> listBox = new ListBox<>();
        listBox.add(new RouterLink("Home", MainView.class));
        listBox.add(new RouterLink("MD5", MD5View.class));
        listBox.add(new RouterLink("article", ArticleView.class));
        add(listBox);

    }

}
