package com.nisum.cms.exception;

public enum ErrorCode {

	CMS0001("CMS0001","Cart Not Found");
	private String code;
    private String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
