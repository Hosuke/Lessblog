package com.hosuke.mapper;

import com.hosuke.entity.Tag;

public interface TagMapper {

    Tag findByNameIgnoreCase(String name);
}
