package com.cynetcore.bayoss.util;

import java.io.File;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class SellerFileUploader {
	
	
	//C드라이브 사용시 업로더
	public static String fileUpload(String fileName,String dirPath,byte[] fileData) {
		String uuid = UUID.randomUUID().toString();
		String uploadFileName = uuid + "_" + fileName;
		File uploadFile = new File(dirPath+ "/" + uploadFileName);
		try {
			FileCopyUtils.copy(fileData, uploadFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return uploadFileName;
	}
	
	//파일 업로더 삭제
	public static Boolean deleteFile(String filename) {
		File f = new File(filename);
		if(f.exists()) {
			f.delete();
			return true;
		}
		return false;
	}
	
	
    

}
