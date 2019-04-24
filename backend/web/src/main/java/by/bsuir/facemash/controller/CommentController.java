package by.bsuir.facemash.controller;

import by.bsuir.facemash.dto.CommentDto;
import by.bsuir.facemash.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for service {@link CommentService}.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
@RestController
@RequestMapping("/comments")
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(final CommentService commentService) {
        this.commentService = commentService;
    }

    /**
     * Get method for select all objects {@link CommentDto}.
     *
     * @return list of the objects {@link CommentDto}
     */
    @GetMapping
    public List<CommentDto> findALl() {
        return commentService.findAll();
    }

    /**
     * Get method for find object {@link CommentDto} by id.
     *
     * @param id value of the object id
     * @return value of the object {@link ResponseEntity}
     */
    @GetMapping("/{id}")
    public ResponseEntity<CommentDto> findById(@PathVariable final Long id) {
        return new ResponseEntity<>(commentService.findById(id), HttpStatus.OK);
    }

    /**
     * Put method for update object {@link CommentDto}.
     *
     * @param id         value of the object id
     * @param commentDto value of the object {@link CommentDto}
     * @return value of the object {@link ResponseEntity}
     */
    @PutMapping("/{id}")
    public ResponseEntity<CommentDto> update(@PathVariable final Long id,
                                             @RequestBody final CommentDto commentDto) {
        commentDto.setId(id);
        return new ResponseEntity<>(commentService.update(commentDto), HttpStatus.OK);
    }

    /**
     * Delete method for remove object {@link CommentDto}.
     *
     * @param id value of the object id
     * @return value of the object {@link ResponseEntity}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable final Long id) {
        commentService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Post method for create object {@link CommentDto}.
     *
     * @param commentDto value of the object {@link CommentDto}
     * @return value of the object {@link ResponseEntity}
     */
    @PostMapping
    public ResponseEntity<CommentDto> create(@RequestBody final CommentDto commentDto) {
        return new ResponseEntity<>(commentService.add(commentDto), HttpStatus.OK);
    }

}
