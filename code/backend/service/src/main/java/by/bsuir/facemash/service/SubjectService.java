package by.bsuir.facemash.service;

import by.bsuir.facemash.dto.SubjectDto;
import by.bsuir.facemash.repository.impl.SubjectRepositoryImpl;
import by.bsuir.facemash.service.api.ServiceApi;

import java.util.List;

/**
 * Service interface for repository {@link SubjectRepositoryImpl}.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
public interface SubjectService extends ServiceApi<SubjectDto> {

    /**
     * This method get object {@link SubjectDto} by name.
     *
     * @param name value of the subject name
     * @return list of the objects {@link SubjectDto}
     */
    List<SubjectDto> findByName(String name);

}
