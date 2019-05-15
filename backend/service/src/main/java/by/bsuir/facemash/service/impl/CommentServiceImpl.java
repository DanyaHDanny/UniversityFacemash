package by.bsuir.facemash.service.impl;

import by.bsuir.facemash.dto.CommentDto;
import by.bsuir.facemash.entity.Comment;
import by.bsuir.facemash.exception.EntityNotFoundException;
import by.bsuir.facemash.repository.CommentRepository;
import by.bsuir.facemash.service.CommentService;
import by.bsuir.facemash.specification.comment.CommentSelectAll;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for repository {@link CommentRepository}.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private ModelMapper modelMapper;

    @Autowired
    public CommentServiceImpl(final CommentRepository commentRepository, final ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public CommentDto add(final CommentDto commentDto) {
        Comment comment = modelMapper.map(commentDto, Comment.class);
        return modelMapper.map(commentRepository.create(comment), CommentDto.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void remove(final Long id) {
        findById(id);
        commentRepository.delete(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public CommentDto update(final CommentDto commentDto) {
        Comment comment = modelMapper.map(commentDto, Comment.class);

        findById(commentDto.getId());
        return modelMapper.map(commentRepository.update(comment), CommentDto.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public CommentDto findById(final Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(comment, CommentDto.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<CommentDto> findAll() {
        return commentRepository.query(new CommentSelectAll())
                .stream()
                .map(comment -> modelMapper.map(comment, CommentDto.class))
                .collect(Collectors.toList());
    }

}
