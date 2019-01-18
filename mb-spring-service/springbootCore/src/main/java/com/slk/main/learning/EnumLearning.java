package com.slk.main.learning;

public class EnumLearning {

	public static void main(String str[]) {

		int val = Sample.ONE.getVal();
		System.out.println(val);
		Sample.ONE.setVal(213);
		val = Sample.ONE.getVal();
		System.out.println(val);
		val = TicketStatus.Closed.getVal();
		System.out.println(val);

	}

}

enum TicketStatus {
	New(1), InProgress(2), Resolved(3), Closed(4), Other(5);
	private int val;

	TicketStatus(int value) {
		this.val = value;
	}

	public static TicketStatus status(int value) {
		for (TicketStatus status : TicketStatus.values()) {
			if (status.getVal() == value)
				return status;
		}
		return null;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}
}

enum Sample {
	ONE(1), TWO(2);
	private int val;

	Sample(int va) {
		val = va;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int va) {
		val = va;
	}

}
