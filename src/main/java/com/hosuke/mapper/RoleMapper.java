package com.hosuke.mapper;


import com.hosuke.entity.Role;

public interface RoleMapper {

    Role findByName(String name);
}
