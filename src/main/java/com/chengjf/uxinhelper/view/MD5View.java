package com.chengjf.uxinhelper.view;

import com.chengjf.uxinhelper.entity.MD5Data;
import com.chengjf.uxinhelper.utils.MD5Util;
import com.vaadin.data.Binder;
import com.vaadin.data.converter.StringToIntegerConverter;
import com.vaadin.data.validator.IntegerRangeValidator;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@SpringView(name = "/md5")
@SpringUI
public class MD5View extends VerticalLayout implements View {

    private Binder<MD5Data> binder = new Binder<>(MD5Data.class);

    public MD5View() {


        setWidthUndefined();

        TextField textField = new TextField("密码：");
        textField.setPlaceholder("password");
        textField.setMaxLength(10000);
        textField.setWidth("500px");
        Label pwdLabel = new Label();

        TextField numberField = new TextField("加密次数：");
        numberField.setValue("1");
        Label numberLabel = new Label();

        TextField result = new TextField("结果：");
        result.setEnabled(false);
        result.setMaxLength(10000);
        result.setReadOnly(true);
        result.setWidth("500px");

        binder.forField(textField).asRequired("不能为空").withStatusLabel(pwdLabel).bind(MD5Data::getPassword, MD5Data::setPassword);
        binder.forField(numberField).asRequired("不能为空")
                .withConverter(new StringToIntegerConverter("请输入数字"))
                .withValidator(new IntegerRangeValidator("请输入1-9的整数", 1, 9))
                .withStatusLabel(numberLabel)
                .bind(MD5Data::getCount, MD5Data::setCount);

        MD5Data md5Data = new MD5Data();

        Button button = new Button("加密", e -> {

            if (binder.writeBeanIfValid(md5Data)) {
                log.info("MD5 加密：{}", md5Data);
                String value = md5Data.getPassword();
                int count = md5Data.getCount();
                //            Notification.show("Hello Spring+Vaadin user!" + value);
                result.setValue(getResult(value, count));
            } else {
                Notification.show("数据校验失败，请检查！");
            }

        });


        addComponents(textField, pwdLabel, numberField, numberLabel, button, result);
    }

    private static String getResult(String pwd, int count) {
        String result = pwd;
        for (int i = 0; i < count; i++) {
            result = MD5Util.encode32(result);
        }
        return result;
    }


}
