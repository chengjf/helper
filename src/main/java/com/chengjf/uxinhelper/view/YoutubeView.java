package com.chengjf.uxinhelper.view;

import com.chengjf.uxinhelper.entity.ScrapeInfo;
import com.chengjf.uxinhelper.service.YoutubeService;
import com.chengjf.uxinhelper.utils.JsonUtil;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

@SpringView(name = "/youtube")
@SpringUI
@Slf4j
public class YoutubeView extends VerticalLayout implements View {

    @Autowired
    private YoutubeService youtubeService;

    public YoutubeView(YoutubeService youtubeService) {
        this.youtubeService = youtubeService;
        Button beautyBtn = new Button("extract");

        TextArea sourceTextArea = new TextArea("输入");
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
            log.info("input value:{}", value);
            String result = getResult(value);
            log.info("result value:{}", result);
            resultTextArea.setValue(result);
        });

        //        add(beautyBtn, horizontalLayout);
        addComponents(beautyBtn, horizontalLayout);
    }

    public String getResult(String str) {
        try {
            log.info("youtubeService:{} url:{}", youtubeService, str);
            ScrapeInfo scrapeInfo = youtubeService.parseWeb(str);
            log.info("parse result:{}", scrapeInfo);
            return JsonUtil.toJsonStr(scrapeInfo);
        } catch (IOException e) {
            log.error("parse io error:{}", str, e);
            return e.getMessage();
        } catch (Exception e) {
            log.error("parse error:{}", str, e);
            return e.getMessage();
        }
    }

}