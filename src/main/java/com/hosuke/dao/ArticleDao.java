package com.hosuke.dao;

import com.hosuke.model.Article;
import com.hosuke.model.dto.ArticleDto;
import com.hosuke.model.dto.ArticleLiteDto;
import com.hosuke.utils.Pager;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Hosuke
 */
@Repository
public interface ArticleDao {
    //搜索文章根据文章标题
    public List<ArticleDto> search(Article a_title) throws Exception;

    //分页
    public List<ArticleDto> pagerAction(Pager pager) throws Exception;

    //获取文章Dto
    public ArticleDto getArticleDto(Integer id) throws Exception;

    //获取上一篇文章
    public ArticleLiteDto getPreArticleDto(Integer id) throws Exception;

    //获取下一篇文章
    public ArticleLiteDto getNextArticleDto(Integer id) throws Exception;

    //获取某分类下文章
    public List<ArticleLiteDto> getByCategory(int categoryId) throws Exception;

    //归档
    public List<ArticleLiteDto> archive() throws Exception;

    //更新点击
    public void updateArticleClicks(Integer clicks, Integer id) throws Exception;

    //更新文章
    public void update(Article article) throws Exception;

    //保存文章
    public void save(Article article) throws Exception;

    //删除文章
    public void delete(Integer id) throws Exception;

    //数量统计
    public int count() throws Exception;
}
