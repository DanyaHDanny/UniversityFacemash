package by.bsuir.facemash.service.impl;

import by.bsuir.facemash.dto.GroupDto;
import by.bsuir.facemash.entity.Group;
import by.bsuir.facemash.exception.EntityNotFoundException;
import by.bsuir.facemash.repository.GroupRepository;
import by.bsuir.facemash.repository.impl.GroupRepositoryImpl;
import by.bsuir.facemash.service.GroupService;
import by.bsuir.facemash.specification.group.SelectAll;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for repository {@link GroupRepositoryImpl}.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
@Service
public class GroupServiceImpl implements GroupService {

    private static final String GROUP_NOT_FOUND = "NotFound.group";
    private static Logger logger = LoggerFactory.getLogger(GroupServiceImpl.class);
    private GroupRepository groupRepository;
    private ModelMapper mapper;

    @Autowired
    public GroupServiceImpl(final GroupRepository groupRepository, final ModelMapper mapper) {
        this.groupRepository = groupRepository;
        this.mapper = mapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public GroupDto add(final GroupDto groupDto) {
        logger.info("Method add(GroupDto) call.");
        Group group = mapper.map(groupDto, Group.class);
        group.setActive(true);
        group = groupRepository.create(group);
        logger.info("Entity " + group + " was created.");
        return mapper.map(group, GroupDto.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public GroupDto findById(final Long id) {
        logger.info("Method findById(GroupDto) call.");
        Group group = groupRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(GROUP_NOT_FOUND, id));
        logger.info("Entity " + group + " find by id.");
        return mapper.map(group, GroupDto.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<GroupDto> findAll() {
        logger.info("Method findAll() call.");
        return groupRepository.query(new SelectAll())
                .stream()
                .map(group -> mapper.map(group, GroupDto.class))
                .collect(Collectors.toList());
    }

}
