package com.allstate.repository;

import com.allstate.models.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by localadmin on 03/01/17.
 */
public interface RoomRepository extends MongoRepository<Room,String> {

}
