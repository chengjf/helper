package com.chengjf.uxinhelper.view;

import com.chengjf.uxinhelper.utils.MD5Util;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@Route("md5")
@PageTitle("md5")
@Theme(value = Lumo.class, variant = Lumo.LIGHT)
public class MD5View extends VerticalLayout {

    public MD5View() {

        TextField textField = new TextField();
        textField.setLabel("密码:");
        textField.setPlaceholder("password");
        textField.setMinLength(5000);
        textField.setMaxLength(10000);

        TextField numberField = new TextField();
        numberField.setLabel("加密次数:");
        numberField.setPattern("[0-9]*");
        numberField.setPreventInvalidInput(true);

        TextField result = new TextField();
        result.setLabel("结果:");
        result.setEnabled(false);
        result.setMinLength(5000);
        result.setMaxLength(10000);
        result.setReadOnly(true);

        Button button = new Button("加密", e -> {
            String value = textField.getValue();
            int count = Integer.valueOf(numberField.getValue());
            //            Notification.show("Hello Spring+Vaadin user!" + value);
            result.setValue(getResult(value, count));

        });
        add(textField, numberField, button, result);
    }


    private static String getResult(String pwd, int count) {
        String result = pwd;
        for (int i = 0; i < count; i++) {
            result = MD5Util.encode32(result);
        }
        return result;
    }
}
