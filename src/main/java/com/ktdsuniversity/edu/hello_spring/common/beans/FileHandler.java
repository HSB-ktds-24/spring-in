package com.ktdsuniversity.edu.hello_spring.common.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.hello_spring.common.vo.StoreResultVO;

//스프링 빈으로 생성
@Component
public class FileHandler {

	@Value("${app.multipart.base-dir}")
	private String baseDirectory;
	
	@Value("${app.multipart.obfuscation.enable}")
	private boolean enableObfuscation;
	
	@Value("${app.multipart.obfuscation.hide-ext.enable}")
	private boolean enableHideExtention;
	
	public StoreResultVO storeFile(MultipartFile multipartFile) {
		//파일 업로드 처리
		
		
		//1. 클라이언트가 파일을 전송했는지 확인
		
		if(multipartFile != null && !multipartFile.isEmpty()) {
			
			String obfuscatedFileName = multipartFile.getOriginalFilename();
			if(this.enableObfuscation) {
				String ext = obfuscatedFileName.substring(obfuscatedFileName.lastIndexOf("."));
				obfuscatedFileName = UUID.randomUUID().toString();
				if (this.enableHideExtention) {
					obfuscatedFileName+=ext;
				}
			
			}
			// 성공시
			// 2. 파일을 특정 폴더에 저장
			// 3. 파일의 정보를 데이터 베이스에 저장
			File uploadFile = new File(this.baseDirectory, obfuscatedFileName);
			if(!uploadFile.getParentFile().exists()) {
				uploadFile.getParentFile().mkdirs();
			}
			
			try {
				multipartFile.transferTo(uploadFile);
			} catch (IllegalStateException | IOException e) {
				
				e.printStackTrace();
				throw new RuntimeException("업로드 실패");
			}
			
			return new StoreResultVO(multipartFile.getOriginalFilename(), obfuscatedFileName);
		}
		return null;
	}
	
	public ResponseEntity<Resource> downloadFile(String fileName, String originalFileName) {
		//1. 게시글 조회
		
		// 2. 다운로드할 파일의 이름을 알기 위해 게시글을 조회한다.
		File downloadFile = new File(this.baseDirectory, fileName);
		
		
		HttpHeaders header = new HttpHeaders();
		
		
		try {
			originalFileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+originalFileName);
		
		InputStreamResource resource = null;
		try{
		resource = new InputStreamResource( new FileInputStream(downloadFile));
		}catch(FileNotFoundException e) {
			throw new IllegalArgumentException("파일 없음");
		}
		
		return ResponseEntity.ok()
				// 응답 데이터에 http header 정보를 세팅
				.headers(header)
				// 다운로드 시킬 파일의 크기 전달
				.contentLength(downloadFile.length())
				//다울로드시킬 파일 지정 png -> "img/png" 타입 관계없이 강제 다운 -> "application/octet-stream"
				.contentType(MediaType.parseMediaType("application/octet-stream"))
				//파일을 응답데이터에 전달
				.body(resource);
	}
	
	
	public void deleteFile(String fileName) {
		
		if(fileName==null) {
			return;
		}
		
		File file =new File(this.baseDirectory,fileName);
		
		if(file.exists()&&file.isFile()) {
			file.delete();
		}
	}
}
