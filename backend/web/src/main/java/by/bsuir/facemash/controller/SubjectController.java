package by.bsuir.facemash.controller;

import by.bsuir.facemash.dto.SubjectDto;
import by.bsuir.facemash.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller for service {@link SubjectService}.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private SubjectService subjectService;

    @Autowired
    public SubjectController(final SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    /**
     * Get method for select all objects {@link SubjectDto}.
     *
     * @param name value of the subject name
     * @return list of the objects {@link SubjectDto}
     */
    @GetMapping
    public List<SubjectDto> findAll(@RequestParam final Optional<String> name) {
        List<SubjectDto> subjects;

        if (!name.isPresent()) {
            subjects = subjectService.findAll();
        } else {
            subjects = subjectService.findByName(name.get());
        }

        return subjects;
    }

    /**
     * Get method for select object {@link SubjectDto} by id.
     */
    @GetMapping("/{id}")
    public ResponseEntity<SubjectDto> findById(@PathVariable final Long id) {
        return new ResponseEntity<>(subjectService.findById(id), HttpStatus.OK);
    }

    /**
     * Delete method for remove object {@link SubjectDto}.
     *
     * @param id value of the object {@link SubjectDto} id
     * @return value of the object {@link ResponseEntity}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable final Long id) {
        subjectService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Put method for update object {@link SubjectDto}.
     *
     * @param id value of the obejct id
     * @return value of the object {@link ResponseEntity}
     */
    @PutMapping("/{id}")
    public ResponseEntity<SubjectDto> update(@PathVariable final Long id,
                                             @RequestBody final SubjectDto subjectDto) {
        subjectDto.setId(id);
        return new ResponseEntity<>(subjectService.update(subjectDto), HttpStatus.OK);
    }

    /**
     * Post method for create object {@link SubjectDto}.
     *
     * @param subjectDto value of the object {@link SubjectDto}
     * @return value of the object {@link ResponseEntity}
     */
    @PostMapping
    public ResponseEntity<SubjectDto> create(@RequestBody final SubjectDto subjectDto) {
        return new ResponseEntity<>(subjectService.add(subjectDto), HttpStatus.OK);
    }

}
