package by.bsuir.facemash.service;

import by.bsuir.facemash.dto.CommentDto;
import by.bsuir.facemash.repository.impl.CommentRepositoryImpl;
import by.bsuir.facemash.service.api.ServiceApi;

/**
 * Service interface for repository {@link CommentRepositoryImpl}.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
public interface CommentService extends ServiceApi<CommentDto> {
}
