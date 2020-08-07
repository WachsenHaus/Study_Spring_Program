package com.gura.spring04.member.dto;

public class MemberDto {
private int num;
private String addr;
private String name;
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
public String getAddr() {
	return addr;
}
public void setAddr(String addr) {
	this.addr = addr;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public MemberDto(int num, String addr, String name) {
	super();
	this.num = num;
	this.addr = addr;
	this.name = name;
}
public MemberDto() {
	super();
}

}
