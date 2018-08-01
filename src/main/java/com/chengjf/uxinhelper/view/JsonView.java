package com.chengjf.uxinhelper.view;

import com.chengjf.uxinhelper.utils.JsonUtil;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

import java.io.IOException;


@SpringView(name = "json")
@SpringUI
public class JsonView extends VerticalLayout implements View {

    public JsonView() {

        Button beautyBtn = new Button("格式化");

        TextArea sourceTextArea = new TextArea("输入");
        //        sourceTextArea.setRequired(true);
        sourceTextArea.setWordWrap(true);
        sourceTextArea.setHeight("500px");
        TextArea resultTextArea = new TextArea("输出");
        resultTextArea.setWidth("100%");
        resultTextArea.setReadOnly(true);
        resultTextArea.setHeight("100%");
        resultTextArea.setWordWrap(false);
        resultTextArea.setResponsive(true);
        resultTextArea.setRows(Integer.MAX_VALUE);
        resultTextArea.setSizeFull();
        resultTextArea.setHeight("500px");

        HorizontalLayout horizontalLayout = new HorizontalLayout(sourceTextArea, resultTextArea);
        horizontalLayout.setWidth("100%");
        beautyBtn.addClickListener(e -> {
            String value = sourceTextArea.getValue();
            String result = getResult(value);
            resultTextArea.setValue(result);
//            resultTextArea.setSizeFull();
//            resultTextArea.setHeightUndefined();
//            resultTextArea.setResponsive(true);
        });

        //        add(beautyBtn, horizontalLayout);
        addComponents(beautyBtn, horizontalLayout);
    }


    public String getResult(String str) {
        try {
            return JsonUtil.beautifyJson(str);
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
