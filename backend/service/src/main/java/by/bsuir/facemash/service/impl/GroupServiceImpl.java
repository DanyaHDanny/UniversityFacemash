package by.bsuir.facemash.service.impl;

import by.bsuir.facemash.dto.GroupDto;
import by.bsuir.facemash.entity.Group;
import by.bsuir.facemash.exception.EntityAlreadyExistException;
import by.bsuir.facemash.exception.EntityNotFoundException;
import by.bsuir.facemash.repository.GroupRepository;
import by.bsuir.facemash.repository.SpecialityRepository;
import by.bsuir.facemash.service.GroupService;
import by.bsuir.facemash.specification.group.GroupSelectByName;
import by.bsuir.facemash.specification.speciality.SpecialitySelectByName;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Service class for dto {@link GroupDto}.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
@Service
public class GroupServiceImpl implements GroupService {

    private Logger logger = LoggerFactory.getLogger(GroupServiceImpl.class);
    private GroupRepository groupRepository;
    private SpecialityRepository specialityRepository;
    private ModelMapper mapper;

    @Autowired
    public GroupServiceImpl(final GroupRepository groupRepository,
                            final SpecialityRepository specialityRepository,
                            final ModelMapper mapper) {
        this.groupRepository = groupRepository;
        this.specialityRepository = specialityRepository;
        this.mapper = mapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public GroupDto add(final GroupDto groupDto) {
        logger.info("Method add(GroupDto) from GroupServiceImpl call.");
        Group group = mapper.map(groupDto, Group.class);

        if (!CollectionUtils.isEmpty(groupRepository.query(new GroupSelectByName(group.getName())))) {
            throw new EntityAlreadyExistException();
        } else if (CollectionUtils.isEmpty(specialityRepository.query(
                new SpecialitySelectByName(group.getSpeciality().getName())))) {
            throw new EntityNotFoundException();
        }

        group.setActive(true);
        group = groupRepository.create(group);
        logger.info("Entity " + group + " created.");
        return mapper.map(group, GroupDto.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public GroupDto update(final GroupDto groupDto) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(Long id) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GroupDto findById(Long id) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<GroupDto> findAll() {
        return null;
    }
}
