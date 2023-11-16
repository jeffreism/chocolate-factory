package moreira.jeffrei.chocolatefactory.web.services;

import moreira.jeffrei.chocolatefactory.web.model.ChocolateDto;

import java.util.UUID;

public interface ChocolateService {
    ChocolateDto getChocolateById(UUID id);

    ChocolateDto saveNewChocolate(ChocolateDto dto);

    void updateChocolate(UUID id, ChocolateDto dto);

    void deleteChocolate(UUID id, ChocolateDto dto);
}
