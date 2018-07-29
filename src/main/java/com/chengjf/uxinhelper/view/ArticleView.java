package com.chengjf.uxinhelper.view;

import com.chengjf.uxinhelper.entity.Article;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.converter.StringToLongConverter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by jeff on 2018/7/28.
 */

@Route("article")
@PageTitle("article")
@Slf4j
public class ArticleView extends VerticalLayout {


    public ArticleView() {
        Binder<Article> binder = new Binder<>();
        Article article = new Article(9999L, "9999");

        TextField idTextFiled = new TextField("id");
        idTextFiled.setPattern("[0-9]*");
        idTextFiled.setRequired(true);

        TextField articleTextFiled = new TextField("article");
        articleTextFiled.setRequired(true);


        binder.forField(idTextFiled).withConverter(new StringToLongConverter("Must enter a number"))
                .bind(Article::getArticleId, Article::setArticleId);

        binder.forField(articleTextFiled).bind(Article::getArticle, Article::setArticle);

        Button button = new Button("click");

        binder.readBean(article);
        button.addClickListener((e) -> {
            try {
                binder.writeBean(article);
                Notification.show(article.toString());

            } catch (ValidationException e1) {
                e1.printStackTrace();
            }
        });

        add(idTextFiled, articleTextFiled, button);
    }
}
