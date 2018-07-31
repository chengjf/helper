package com.chengjf.uxinhelper.view;

import com.chengjf.uxinhelper.utils.JsonUtil;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.io.IOException;


@Route("json")
@PageTitle("json")
public class JsonView extends VerticalLayout {

    public JsonView() {
        Button beautyBtn = new Button("格式化");

        TextArea sourceTextArea = new TextArea("输入");
        sourceTextArea.setRequired(true);
        TextArea resultTextArea = new TextArea("输出");
        resultTextArea.setWidth("100%");
        resultTextArea.setReadOnly(true);

        HorizontalLayout horizontalLayout = new HorizontalLayout(sourceTextArea, resultTextArea);
        horizontalLayout.setWidth("100%");
        beautyBtn.addClickListener(e -> {
            String value = sourceTextArea.getValue();
            String result = getResult(value);
            resultTextArea.setValue(result);
        });

        add(beautyBtn, horizontalLayout);
    }


    public String getResult(String str) {
        try {
            return JsonUtil.beautifyJson(str);
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
