package com.hosuke.service;

import com.hosuke.model.Article;
import com.hosuke.model.dto.ArticleDto;
import com.hosuke.model.dto.ArticleLiteDto;
import com.hosuke.util.Pager;

import java.util.List;

/**
 * @Author Hosuke
 */
public interface ArticleService {
    //按照标题搜索文章
    public List<ArticleDto> searchArticles(Article article);

    //文章分页列表
    public List<ArticleDto> getPageArticles(Pager pager);

    // 获取文章 title,content,pubdate,category,clicks,content
    public ArticleDto getArticle(Integer id);

    //获取上一篇文章
    public ArticleLiteDto getPreArticle(Integer id);

    //获取下一篇文章
    public ArticleLiteDto getNextArticle(Integer id);

    //获取文章列表 article(title,pubdate)
    public List<ArticleLiteDto> getArticlesByCategory(int categoryId);

    //归档文章列表 article(title,pubdate)
    public List<ArticleLiteDto> getArchive();
    //获取文章简介
    //更新具体文章 about(content)
    //保存或添加具体文章 about(content)

    //更新文章
    public void updateArticle(Article article);

    //添加文章
    public void saveArticle(Article article);

    //删除文章
    public void deleteArticle(Integer id);

    //获取数值
    public int count();

    //更新点击数或者浏览量
    void updateClicks(Integer clicks, Integer id);
}
