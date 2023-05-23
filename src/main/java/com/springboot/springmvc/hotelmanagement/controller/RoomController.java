package com.springboot.springmvc.hotelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.springmvc.hotelmanagement.dao.RoomDAO;
import com.springboot.springmvc.hotelmanagement.entity.Room;

@Controller
public class RoomController {
	
	@Autowired
	RoomDAO dao;
	
	public RoomController()
	{
		
	}
	
	@GetMapping("/general/getAvailableRooms")
	public ModelAndView getAvailableRooms() {

		

		ModelAndView mv = new ModelAndView("roomList");
		List<Room> rooms= dao.findByRoomStatus("A");
		mv.addObject("rooms", rooms);
		mv.addObject("status", "A");
		return mv;



}
@GetMapping("/secure/getOccupiedRooms") 
public ModelAndView getOccupiedRooms() {

		
		ModelAndView mv = new ModelAndView("roomList");
		List<Room> rooms= dao.findByRoomStatus("O");
		mv.addObject("rooms", rooms);
		mv.addObject("status" ,"O");
		return mv;
}
@GetMapping("/secure/allocateRoom")
public String allocateRoom(Room room)
{
	Room room1=dao.findById(room.getRoomNumber()).orElse(new Room());
	room1.setRoomStatus("O");
	dao.save(room1);
	return "roomAllocated";
}
@GetMapping("/secure/deallocateRoom")
public String deallocateRoom(Room room)
{
	Room room1=dao.findById(room.getRoomNumber()).orElse(new Room());
	room1.setRoomStatus("A");
	dao.save(room1);
	return "roomDeallocated";
}
	  
}
	
