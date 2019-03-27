package by.bsuir.facemash.service.impl;

import by.bsuir.facemash.dto.SubjectDto;
import by.bsuir.facemash.entity.Subject;
import by.bsuir.facemash.exception.EntityAlreadyExistException;
import by.bsuir.facemash.repository.SubjectRepository;
import by.bsuir.facemash.repository.impl.SubjectRepositoryImpl;
import by.bsuir.facemash.service.SubjectService;
import by.bsuir.facemash.specification.subject.SelectAll;
import by.bsuir.facemash.specification.subject.SelectByName;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for repository {@link SubjectRepositoryImpl}.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    private static final Logger logger = LoggerFactory.getLogger(SubjectServiceImpl.class);
    private SubjectRepository subjectRepository;
    private ModelMapper modelMapper;

    @Autowired
    public SubjectServiceImpl(final SubjectRepository subjectRepository, final ModelMapper modelMapper) {
        this.subjectRepository = subjectRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public SubjectDto add(final SubjectDto subjectDto) {
        logger.info("Method add(SubjectDto) from SubjectServiceImpl call.");
        Subject subject = modelMapper.map(subjectDto, Subject.class);

        if (CollectionUtils.isEmpty(findByName(subjectDto.getName()))) {
            subject = subjectRepository.create(subject);
        } else {
            throw new EntityAlreadyExistException();
        }

        logger.info("Entity " + subject + " created.");
        return modelMapper.map(subject, SubjectDto.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void remove(final Long id) {
        logger.info("Method remove(Long) from SubjectServiceImpl call.");
        findById(id);
        subjectRepository.delete(id);
        logger.info("Entity Subject remove from database.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public SubjectDto update(final SubjectDto subjectDto) {
        logger.info("Method update(SubjectDto) from SubjectServiceImpl call.");
        Subject subject = modelMapper.map(subjectDto, Subject.class);
        findById(subject.getId());
        subject = subjectRepository.update(subject);
        logger.info("Updated entity " + subject);
        return modelMapper.map(subject, SubjectDto.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public SubjectDto findById(final Long id) {
        logger.info("Method findById(Long) from SubjectServiceImpl call.");
        Subject subject = subjectRepository.findById(id).orElseThrow(EntityExistsException::new);
        return modelMapper.map(subject, SubjectDto.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<SubjectDto> findAll() {
        logger.info("Method findAll() from SubjectServiceImpl call.");
        return subjectRepository.query(new SelectAll())
                .stream()
                .map(subject -> modelMapper.map(subject, SubjectDto.class))
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<SubjectDto> findByName(final String name) {
        logger.info("Method findByName(String) from SubjectServiceImpl call.");
        return subjectRepository.query(new SelectByName(name))
                .stream()
                .map(subject -> modelMapper.map(subject, SubjectDto.class))
                .collect(Collectors.toList());
    }

}
