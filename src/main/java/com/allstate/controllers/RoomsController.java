package com.allstate.controllers;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import com.allstate.models.Room;
import com.allstate.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by localadmin on 03/01/17.
 */
@RestController
public class RoomsController {
    @Autowired
    private RoomRepository roomRepository;

    @RequestMapping(value = "/rooms", method = POST)
    @ResponseStatus(CREATED)
    public Room createRoom(@RequestBody Room room) {
        roomRepository.save(room);
        return room;
    }
    @RequestMapping(value = "/rooms", method = GET)
    public List<Room> listRoom() {
       return roomRepository.findAll();

    }
    @RequestMapping(value = "/rooms/{id}", method = GET)
    public Room listRoomOne(@PathVariable("id") String id) {
        return roomRepository.findOne(id);

    }
}
