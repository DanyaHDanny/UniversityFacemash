package by.bsuir.facemash.service.impl;

import by.bsuir.facemash.dto.EstimateDto;
import by.bsuir.facemash.repository.EstimateRepository;
import by.bsuir.facemash.service.EstimateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for repository {@link EstimateRepository}.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
@Service
public class EstimateServiceImpl implements EstimateService {

    private EstimateRepository estimateRepository;

    @Autowired
    public EstimateServiceImpl(final EstimateRepository estimateRepository) {
        this.estimateRepository = estimateRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EstimateDto add(final EstimateDto estimateDto) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public EstimateDto update(EstimateDto object) {
        return null;
    }

    @Override
    public EstimateDto findById(Long id) {
        return null;
    }

    @Override
    public List<EstimateDto> findAll() {
        return null;
    }
}
