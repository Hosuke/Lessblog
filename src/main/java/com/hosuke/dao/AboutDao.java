package com.hosuke.dao;

import com.hosuke.model.About;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Hosuke
 */
@Repository
public interface AboutDao {
    //获取About
    public About getAbout(Integer id) throws Exception;

    //更新About
    public void upDate(About about) throws Exception;

    //存储About
    public void save(About about) throws Exception;

    //删除About
    public void delete(Integer id) throws Exception;

    //计数About
    public int count() throws Exception;

    //About列表
    public List<About> list() throws Exception;
}
