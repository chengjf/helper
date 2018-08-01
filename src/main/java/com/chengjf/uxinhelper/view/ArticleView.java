package com.chengjf.uxinhelper.view;

import com.chengjf.uxinhelper.entity.Article;
import com.vaadin.data.Binder;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by jeff on 2018/7/28.
 */

@Slf4j
public class ArticleView extends VerticalLayout {


    public ArticleView() {
//        Binder<Article> binder = new Binder<>();
//        Article article = new Article(9999L, "9999");
//
//        TextField idTextFiled = new TextField("id");
////        idTextFiled.setPattern("[0-9]*");
////        idTextFiled.setRequired(true);
//
//        TextField articleTextFiled = new TextField("article");
////        articleTextFiled.setRequired(true);
//
//
//        binder.forField(idTextFiled).asRequired("请输入数字").withConverter(new StringToLongConverter("Must enter a number"))
//                .bind(Article::getArticleId, Article::setArticleId);
//
//        binder.forField(articleTextFiled).asRequired("请输入内容").bind(Article::getArticle, Article::setArticle);
//
//        Button button = new Button("click");
//
//        binder.readBean(article);
//        button.addClickListener((e) -> {
//            try {
//                binder.writeBean(article);
//                Notification.show(article.toString());
//
//            } catch (ValidationException e1) {
//                e1.printStackTrace();
//            }
//        });
//
//        add(idTextFiled, articleTextFiled, button);
    }
}
