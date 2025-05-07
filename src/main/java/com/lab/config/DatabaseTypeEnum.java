package com.lab.config;

public enum DatabaseTypeEnum {
	MASTER("master", "masterDB");
	
    private final String databaseType;
    private final String msg;
    
    DatabaseTypeEnum(String databaseType, String msg) {
        this.databaseType = databaseType;
        this.msg = msg;
    }
	public String getDatabaseType() {
		return databaseType;
	}
	public String getMsg() {
		return msg;
	}
}