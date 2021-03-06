package com.enc.batch;

public class VmMeticBean {
	public static final String INFO_TYPE_CPUU 	= "CPUU";
	public static final String INFO_TYPE_MEMT 	= "MEMT";
	public static final String INFO_TYPE_MEMF 	= "MEMF";
	public static final String INFO_TYPE_DISKR 	= "DISKR";
	public static final String INFO_TYPE_DISKW 	= "DISKW";
	public static final String INFO_TYPE_NETI 	= "NETI";
	public static final String INFO_TYPE_NETO 	= "NETO"; 
	public static final String[] INFO_TYPE 		= {
			INFO_TYPE_CPUU, INFO_TYPE_MEMT, INFO_TYPE_MEMF, INFO_TYPE_DISKR, INFO_TYPE_DISKW, INFO_TYPE_NETI, INFO_TYPE_NETO
	};
	
	private String infoType;
	private String timestamp;
	private String unit;
	private double minimum;
	private double maximum;
	private double average;
	private double sum;
	
	public VmMeticBean(String infoType) {
		this.infoType 	= infoType;
	}

	public VmMeticBean(String infoType, String timestamp, String unit, double minimum, double maximum, double average, double sum) {
		this.infoType 	= infoType;
		this.timestamp = timestamp;
		this.unit = unit;
		this.minimum = minimum;
		this.maximum = maximum;
		this.average = average;
		this.sum = sum;
	}

	public String getInfoType() {
		return infoType;
	}

	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getMinimum() {
		return minimum;
	}

	public void setMinimum(double minimum) {
		this.minimum = minimum;
	}

	public double getMaximum() {
		return maximum;
	}

	public void setMaximum(double maximum) {
		this.maximum = maximum;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}
	
	
}
