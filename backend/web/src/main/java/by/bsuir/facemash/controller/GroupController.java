package by.bsuir.facemash.controller;

import by.bsuir.facemash.dto.GroupDto;
import by.bsuir.facemash.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for service {@link GroupService}.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
@RestController
@RequestMapping("/groups")
public class GroupController {

    private GroupService groupService;

    public GroupController(final GroupService groupService) {
        this.groupService = groupService;
    }

    /**
     * Post method for create entity {@link GroupDto}.
     *
     * @param groupDto value of the object {@link GroupDto}
     * @return value of the object {@link ResponseEntity}
     */
    @PostMapping
    public ResponseEntity<GroupDto> create(@RequestBody final GroupDto groupDto) {
        return new ResponseEntity<>(groupService.add(groupDto), HttpStatus.OK);
    }

}
