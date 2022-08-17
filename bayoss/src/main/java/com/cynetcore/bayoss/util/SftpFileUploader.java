package com.cynetcore.bayoss.util;

import java.io.File;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;
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

public class SftpFileUploader {
	private static Session session = null;
    private static Channel channel = null;
    private static ChannelSftp channelSftp = null;
    final static String sftpIp = "dev.harbormax.com";
    final static int sftpPort = 22;
	final static String sftpUsername = "harbormax";
	final static String sftpPassword = "harbor777**";
	
	//sftp 업로더
	//sftp서버 연결
	public static void Connect() throws Exception {
		
		JSch jsch = new JSch();
		try {
			//접속
			//세션객체 생성 ( user , host, port )     
            session = jsch.getSession(sftpUsername, sftpIp,sftpPort);

            //password 설정
            session.setPassword(sftpPassword);

            //세션관련 설정정보 설정
            java.util.Properties config = new java.util.Properties();

            //호스트 정보 검사하지 않는다.
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);

            //접속
            session.connect();
           
            //sftp 채널 접속
            channel = session.openChannel("sftp");
            channel.connect();
            channelSftp = (ChannelSftp) channel;
            //파일 업로드
          //  upload(dirPath,file,uploadFileName);
            
            //접속 종료
		} catch (JSchException e) {
			e.printStackTrace();
		} 
		
		//return uploadFileName;
	}
	
	 // sftp서버 단일 파일 업로드 
    public static String upload(String fileName, String dirPath,MultipartFile file) throws IOException{
        InputStream in = null;
        String uuid = UUID.randomUUID().toString();
		String uploadFileName = uuid + "_" + fileName;
        try{ //파일을 가져와서 inputStream에 넣고 저장경로를 찾아 put 
        	
            in = file.getInputStream();
            channelSftp.cd(dirPath);
            channelSftp.put(in,uploadFileName);
        }catch(SftpException se){
            se.printStackTrace();
        }catch(FileNotFoundException fe){
            fe.printStackTrace();
        }finally{
            try{
                in.close();
            } catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
        return uploadFileName;
    }

    //sftp서버 단일 파일 다운로드 
    @Transactional
    public static InputStream download(String dir, String fileName){
        InputStream in = null;
       // String path = "...";
        try{ //경로탐색후 inputStream에 데이터를 넣음
            channelSftp.cd(dir);
            in = channelSftp.get(fileName);

        }catch(SftpException se){
            se.printStackTrace();
        }

        return in;
    }

    //sftp서버, 파일서버와 세션 종료
    public static void disconnect(){
        channelSftp.quit();
        session.disconnect();
    }
	
    

}
