package org.neweducation.domain.events.boundary;

import org.neweducation.api.events.EventDTO;
import org.neweducation.domain.events.control.EventService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/events")
@Produces(MediaType.APPLICATION_JSON)
public class EventController {

    @Inject
    EventService eventService;

    @Inject
    EventDTOMapper eventDTOMapper;

    @GET
    public List<EventDTO> getAll() {
        return eventService.getAll().stream()
                .map(eventDTOMapper::toDTO)
                .collect(Collectors.toUnmodifiableList());
    }
}
