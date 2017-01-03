package integration;

/**
 * Created by localadmin on 03/01/17.
 */
import com.allstate.Application;
import com.allstate.models.Room;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static java.util.Collections.emptyMap;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.springframework.http.HttpStatus.CREATED;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest

public class RoomsApiIntegrationTest {
    RestTemplate restTemplate = new TestRestTemplate();

    final String BASE_URL = "http://localhost:8080/rooms/";
    @Test
    public void postRespondsWithStatusCodeCreated() {
        Room room = new Room();
        room.setName("Ruby");
        room.setCapacity(12);
        room.setHavingVc(true);

        ResponseEntity<Room> response = restTemplate.postForEntity(
                BASE_URL, room, Room.class);

        assertThat(response.getStatusCode(), equalTo(CREATED));
    }

    @Test
    public void postRespondsWithCreatedRoom() {
        Room room = new Room();
        room.setName("Ruby");
        room.setCapacity(12);
        room.setHavingVc(true);

        ResponseEntity<Room> response = restTemplate.postForEntity(
                BASE_URL, room, Room.class);

        Room newRoom = response.getBody();
        assertThat(newRoom, notNullValue());
        assertThat(newRoom.getId(), notNullValue());
        assertThat(newRoom.getName(), equalTo("Ruby"));
        assertThat(newRoom.getCapacity(), equalTo(12));
        assertThat(newRoom.isHavingVc(), equalTo(true));
    }

}