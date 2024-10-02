package com.ktdsuniversity.edu.hello_spring.common.vo;

public class StoreResultVO {
	
	private String obfuscatedFileName;


	private String orginalFileName;
	
	public StoreResultVO(String orginalFileName, String obfuscatedFileName) {
		
		this.orginalFileName = orginalFileName;
		this.obfuscatedFileName = obfuscatedFileName;
	}

		public String getObfuscatedFileName() {
		return obfuscatedFileName;
	}

	public String getOrginalFileName() {
		return orginalFileName;
	}
	


}
