package com.springboot.springmvc.hotelmanagement.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.springmvc.hotelmanagement.entity.Room;


public interface RoomDAO extends JpaRepository <Room, Integer> {

	public List<Room> findByRoomStatus(String roomStatus);

	
}
