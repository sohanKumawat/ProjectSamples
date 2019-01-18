package com.mb.demo.constants;

public class PickPackConstants {

	public static final String REDIS_KEY_PREFIX = "MBPICKEROPT";

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
		PRODUCT, ORDER, NODE, BAGES, CRATE, TRANSFERCRATE, DELIVERCRATE, OTHER
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

	public enum ActionType {
		SHOW, HIDE, CLOSE, DELETE, PICK, DROP, CREATE, UPDATE, ADD, REMOVE
	}

	public enum ActionStatus {
		CREATED, UPDATED, REMOVED, DELETED, PENDING, DELIVERED, PACKED, INUSE, AVAILABLE, ACTIVE, INACTIVE, CONFIRMED, DONE, OPENED
	}

	public enum StorageNode {
		AISLE, RACK, SHELF, BEAN, BASKET, BUCKET, PRODUCT, NONE
	}

	public enum StorageNodeLevel {
		ROOT, CHILD, LEAF
	}
}
