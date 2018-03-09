package com.hosuke.service.impl;

import com.hosuke.dao.AboutDao;
import com.hosuke.model.About;
import com.hosuke.service.AboutService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Hosuke
 */
@Service("aboutService")
public class AboutServiceImpl implements AboutService {

    @Resource
    private AboutDao aboutDao;

    @Override
    public int count() {
        Integer count = 0;
        try {
            count = aboutDao.count();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public About getAbout(Integer id) {
        About about = new About();
        try {
            about = aboutDao.getAbout(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return about;
    }

    @Override
    public void upDate(About about) {
        try {
            aboutDao.upDate(about);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<About> list() {
        List<About> abouts = null;
        try {
            abouts = aboutDao.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return abouts;
    }

    @Override
    public void save(About about) {
        try {
            aboutDao.save(about);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            aboutDao.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
