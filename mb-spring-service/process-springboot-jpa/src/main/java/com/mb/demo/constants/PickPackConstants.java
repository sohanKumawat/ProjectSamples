package com.mb.demo.constants;

public class PickPackConstants {

	public enum ScannerLevel {
		STASCANNER, SASCANNER, FASCANNER, OWNERSCANNER, PACKERSCANNER, SEQUENCERSCANNER, ORDERSCANNER, OTHER
	}

	public enum ScannerCodeType {
		QRCODE, EANCODE, OTHER
	}

	public enum ScannerType {
		MANUAL, SYSTEM, OTHER
	}

	public enum ItemType {
		PRODUCT, ORDER, SHELF, AISLE, BAGES, CRATE, TRANSFERCRATE, DELIVERCRATE, OTHER
	}

	public enum OperationType {
		STAPICKER, SAPICKER, FAPICKER, OWNER, PACKER, SEQUENCER, OTHER
	}

	public enum DataType {
		Number, Integer, Float, Double, String, Object;
	}

	public enum TicketType {
		NA, Logging, Notification
	}

}
