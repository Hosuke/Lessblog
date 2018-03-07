package com.hosuke.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AvatarService {

    UploadedAvatarInfo upload(MultipartFile file) throws IOException, Exception; //UnsupportedFormatException;
}
