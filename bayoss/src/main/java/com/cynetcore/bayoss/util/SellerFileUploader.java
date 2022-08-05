package com.cynetcore.bayoss.util;

import java.io.File;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SellerFileUploader {
	private static Session jschSession = null;
    private static Channel channel = null;
    private static ChannelSftp channelSftp = null;
	
	public static String fileUpload(String fileName, String dirPath,MultipartFile file) throws Exception {
		String uuid = UUID.randomUUID().toString();
		String uploadFileName = uuid + "_" + fileName;
		boolean isSuccess = false;
		FileInputStream fis = null;
		try {
			connectSFTP();
			 // 대상폴더 이동
			channelSftp.cd(dirPath);

			File convFile = new File(file.getOriginalFilename());
			convFile.createNewFile();
            fis = new FileInputStream(convFile);
//수정하기
            // 파일 업로드
            channelSftp.put(fis, uploadFileName);
            isSuccess = true;
            System.out.println("uploadFileName : " + uploadFileName);
         //  System.out.println("file upload  : " +   file.getAbsolutePath() + ">>" + dirPath + "/" + uploadFileName);
           disconnectSFTP();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return uploadFileName;
	}
	
	public static void connectSFTP() throws Exception {
		String user = "harbormax";
		String pwd = "harbor777**";
        // JSch 객체를 생성
        JSch jsch = new JSch();

        // JSch 세션 객체를 생성 (사용자 이름, 접속할 호스트, 포트 전달)
        jschSession = jsch.getSession(user, "dev.harbormax.com", 22);

        // 패스워드 설정
        jschSession.setPassword(pwd);

        // 기타설정 적용
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        jschSession.setConfig(config);

        // 접속
        jschSession.connect();

        // sftp 채널 열기
        channel = jschSession.openChannel("sftp");

        // sftp 채널 연결
        channelSftp = (ChannelSftp) channel;
        channelSftp.connect();
    }
	
	
	 /**
     * SFTP 접속해제
     */
    public static void disconnectSFTP() {
        try {
            if (channelSftp != null && channelSftp.isConnected()) {
                channelSftp.disconnect();
            }
        } catch (Exception e) {
        } finally {
            channelSftp = null;
        }

        try {
            if (channel != null && channel.isConnected()) {
                channel.disconnect();
            }
        } catch (Exception e) {
        } finally {
            channel = null;
        }

        try {
            if (jschSession != null && jschSession.isConnected()) {
                jschSession.disconnect();
            }
        } catch (Exception e) {
        } finally {
            jschSession = null;
        }
    }

    /**
     * FileInputStream 객체 닫기
     *
     * @param fis
     */
    private void close(FileInputStream fis) {
        try {
            if (fis != null) {
                fis.close();
            }
        } catch (Exception e) {
        } finally {
            fis = null;
        }
    }

    /**
     * BufferedInputStream 객체 닫기
     *
     * @param bis
     */
    private void close(BufferedInputStream bis) {
        try {
            if (bis != null) {
                bis.close();
            }
        } catch (Exception e) {
        } finally {
            bis = null;
        }
    }

    /**
     * FileOutputStream 객체 닫기
     *
     * @param fos
     */
    private void close(FileOutputStream fos) {

        try {
            if (fos != null) {
                fos.flush();
            }
        } catch (Exception e) {
        }

        try {
            if (fos != null) {
                fos.close();
            }
        } catch (Exception e) {
        } finally {
            fos = null;
        }
    }

    /**
     * BufferedOutputStream 객체 닫기
     *
     * @param bos
     */
    private void close(BufferedOutputStream bos) {

        try {
            if (bos != null) {
                bos.flush();
            }
        } catch (Exception e) {
        }

        try {
            if (bos != null) {
                bos.close();
            }
        } catch (Exception e) {
        } finally {
            bos = null;
        }
    }
	
	/*private static void showServerReply(FTPClient ftpClient) {
		String[] replies = ftpClient.getReplyStrings();
		if(replies != null && replies.length > 0) {
			for(String aReply : replies) {
				System.out.println("SERVER : " + aReply);
			}
		}
	}*/
	
	
	public static Boolean deleteFile(String filename) {
		File f = new File(filename);
		if(f.exists()) {
			f.delete();
			return true;
		}
		return false;
	}

}
