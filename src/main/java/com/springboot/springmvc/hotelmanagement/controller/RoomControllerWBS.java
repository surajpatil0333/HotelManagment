package com.springboot.springmvc.hotelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springmvc.hotelmanagement.dao.RoomDAO;
import com.springboot.springmvc.hotelmanagement.entity.Room;

//@Controller
@RestController
public class RoomControllerWBS {

	@Autowired
	RoomDAO dao;

	public RoomControllerWBS() {
		
	}
	
	/*@GetMapping("/rooms")
	//@ResponseBody
	public String getAllRooms() {

		List<Room> rooms=dao.findAll();
		return rooms.toString();
	
	}
	
	@GetMapping("/rooms/{roomNumber}")
	@ResponseBody
	public String getRooms(@PathVariable("roomNumber") int roomNo)
	{
		
		Room room=dao.findById(roomNo).orElse(new Room());
				return room.toString();
}*/
	
	@GetMapping("/rooms")
//	@ResponseBody
	public List<Room> getAllRooms() {

		List<Room> rooms=dao.findAll();
		return rooms;
	
	}
	
	@GetMapping(path="/rooms/{roomNumber}",produces= {"application/xml"})
	//@ResponseBody
	public Room getRooms(@PathVariable("roomNumber") int roomNo)
	{
		
		Room room=dao.findById(roomNo).orElse(new Room());
				return room;
}



	@PostMapping(path="/rooom", consumes= {"application/json"})
	public void addRooom(@RequestBody Room room)
	{
   dao.save(room);
	}

     @DeleteMapping("/room/{roomNo}")
public void deleteRoom(@PathVariable int roomNo)
{
	dao.deleteById(roomNo);
}

@PutMapping("/room")
public void addOrUpdateRoom(Room room)
{
      dao.save(room);
}

@GetMapping("/room/{roomStatus}")
public List<Room> getRoomByStatus(@PathVariable String roomStatus)
{

return dao.findByRoomStatus(roomStatus);

}
	
	

	
	
	
		
	
	
	


}