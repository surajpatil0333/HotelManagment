package com.springboot.springmvc.hotelmanagement.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name="room_master")

public class Room {

	
	 @Id
	 @Column(name="room_number")
	private int roomNumber;
	
	 @Column(name="room_type")
	private String roomType;
	
	 @Column(name="room_status")
	private String  roomStatus;
	
	public  Room()
	{
	}

	public Room(int roomNumber, String roomType, String roomStatus) {
		super();
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.roomStatus = roomStatus;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	@Override
	public String toString() {
		return "Room [roomNumber=" + roomNumber + ", roomType=" + roomType + ", roomStatus=" + roomStatus + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(roomNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		return roomNumber == other.roomNumber;
	}
	
	
}
