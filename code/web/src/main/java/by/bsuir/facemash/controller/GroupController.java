package by.bsuir.facemash.controller;

import by.bsuir.facemash.dto.GroupDto;
import by.bsuir.facemash.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for work with dto {@link GroupDto}.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
@RestController
@RequestMapping("/groups")
public class GroupController {

    private GroupService groupService;

    @Autowired
    public GroupController(final GroupService groupService) {
        this.groupService = groupService;
    }

    /**
     * Get method for select all objects {@link GroupDto}.
     *
     * @return list of the objects {@link GroupDto}
     */
    @GetMapping
    public List<GroupDto> findAll() {
        return groupService.findAll();
    }

    /**
     * Post method for create object {@link GroupDto}.
     *
     * @param groupDto value of the object {@link GroupDto}
     * @return value of the object {@link ResponseEntity}
     */
    @PostMapping
    public ResponseEntity<GroupDto> create(@RequestBody final GroupDto groupDto) {
        return new ResponseEntity<>(groupService.add(groupDto), HttpStatus.OK);
    }

}
