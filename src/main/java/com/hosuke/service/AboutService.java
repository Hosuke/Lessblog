package com.hosuke.service;

import com.hosuke.model.About;

import java.util.List;

/**
 * @Author Hosuke
 */
public interface AboutService {

    public About getAbout(Integer id);

    public void upDate(About about);

    public void save(About about);

    public void delete(Integer id);

    public int count();

    public List<About> list();
}
