package by.bsuir.facemash.service.impl;

import by.bsuir.facemash.dto.EstimateDto;
import by.bsuir.facemash.entity.Estimate;
import by.bsuir.facemash.exception.EntityNotFoundException;
import by.bsuir.facemash.repository.EstimateRepository;
import by.bsuir.facemash.service.EstimateService;
import by.bsuir.facemash.specification.estimate.EstimateSelectAll;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for repository {@link EstimateRepository}.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
@Service
public class EstimateServiceImpl implements EstimateService {

    private EstimateRepository estimateRepository;
    private ModelMapper modelMapper;

    @Autowired
    public EstimateServiceImpl(final EstimateRepository estimateRepository, final ModelMapper modelMapper) {
        this.estimateRepository = estimateRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EstimateDto add(final EstimateDto estimateDto) {
        Estimate estimate = modelMapper.map(estimateDto, Estimate.class);
        return modelMapper.map(estimateRepository.create(estimate), EstimateDto.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(final Long id) {
        findById(id);
        estimateRepository.delete(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EstimateDto update(final EstimateDto estimateDto) {
        Estimate estimate = modelMapper.map(estimateDto, Estimate.class);
        return modelMapper.map(estimateRepository.update(estimate), EstimateDto.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EstimateDto findById(final Long id) {
        Estimate estimate = estimateRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(estimate, EstimateDto.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<EstimateDto> findAll() {
        return estimateRepository.query(new EstimateSelectAll())
                .stream()
                .map(estimate -> modelMapper.map(estimate, EstimateDto.class))
                .collect(Collectors.toList());
    }

}
