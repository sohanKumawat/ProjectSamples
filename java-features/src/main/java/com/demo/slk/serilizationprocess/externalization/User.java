package com.demo.slk.serilizationprocess.externalization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

public class User implements Externalizable {
	private int code;
    private String name;
    private String password;
    private Date birthday;
    private int socialSecurityNumber;
 
    public User() {
    }
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(code);
        out.writeObject(name);
        out.writeObject("");
        out.writeObject(birthday);
    }
    public void readExternal(ObjectInput in) throws ClassNotFoundException, IOException {
        this.code = in.readInt();
        this.name = (String) in.readObject();
        this.password = (String) in.readObject();
        this.birthday = (Date) in.readObject();
    }
    public int getCode() {
        return this.code;
    }
 
    public void setCode(int code) {
        this.code = code;
    }
 
    public String getName() {
        return this.name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getPassword() {
        return this.password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
 
    public Date getBirthday() {
        return this.birthday;
    }
 
    public void setSocialSecurityNumber(int ssn) {
        this.socialSecurityNumber = ssn;
    }
 
    public int getSocialSecurityNumber() {
        return this.socialSecurityNumber;
    }
}
