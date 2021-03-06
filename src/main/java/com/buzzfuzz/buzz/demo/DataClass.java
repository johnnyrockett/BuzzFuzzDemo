package com.buzzfuzz.buzz.demo;

public class DataClass {
	
	@SuppressWarnings("unused")
	private int iVal;
	@SuppressWarnings("unused")
	private String sVal;
	private boolean bVal;
	@SuppressWarnings("unused")
	private float fVal;
	
	// private, unreachable constructor
	DataClass(int iVal, String sVal, boolean bVal, float fVal) {
		this.iVal = iVal;
		this.sVal = sVal;
		this.bVal = bVal;
		this.fVal = fVal;
	}
	
	// Factory method example
	public static DataClass makeDataClass(int iVal, String sVal, boolean bVal, float fVal) {
		return new DataClass(iVal, sVal, bVal, fVal);
	}
	
	public void alter() throws Exception {
        this.bVal = !this.bVal;
        if (fVal < 500 && iVal > 500)
            throw new Exception("Invalid fVal");
	}
}
