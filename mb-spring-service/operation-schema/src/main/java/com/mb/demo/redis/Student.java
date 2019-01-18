package com.mb.demo.redis;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import com.mb.demo.redis.beans.Address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@RedisHash("Student")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student implements Serializable {

	private static final long serialVersionUID = -4902414523285044987L;

	public enum Gender {
		MALE, FEMALE
	}

	@Id
	private String id;
	@Indexed
	private String name;
	@Indexed
	private Gender gender;
	private int grade;
	private List<Address> address;

}
