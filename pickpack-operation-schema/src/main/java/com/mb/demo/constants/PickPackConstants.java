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

	public enum ActionStatus {
		INUSE, AVAILABLE, ACTIVE, INACTIVE, SHOW, HIDE, CONFIRMED, CLOSE, DONE, OPEN, DELETE, NEW, ADD, SUBTRACT, REMOVE
	}

	public enum OrderActionStatus {
		CREATE, ADD, REMOVE, DELETE, PENDING, DELIVERED, PACKED
	}
	
	public enum StorageNode {
		AISLE, RACK, SHELF,BEAN, BASKET, BUCKET,PRODUCT,NONE
	}
	public enum StorageNodeLevel {
		ROOT,CHILD,LEAF
	}
}
