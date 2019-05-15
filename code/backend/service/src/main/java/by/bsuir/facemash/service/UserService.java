package by.bsuir.facemash.service;

import by.bsuir.facemash.dto.UserDto;
import by.bsuir.facemash.repository.impl.UserRepositoryImpl;
import by.bsuir.facemash.service.api.ServiceApi;

/**
 * Service interface for repository {@link UserRepositoryImpl}.
 *
 * @author Mikita_Ustsiushenka
 * @version 1.0
 */
public interface UserService extends ServiceApi<UserDto> {
}
