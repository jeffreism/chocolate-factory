package moreira.jeffrei.chocolatefactory.web.services;

import lombok.extern.slf4j.Slf4j;
import moreira.jeffrei.chocolatefactory.web.model.ChocolateDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class ChocolateServiceImpl implements ChocolateService {
    @Override
    public ChocolateDto getChocolateById(UUID id) {
        // TODO : use actual id
        return ChocolateDto.builder().id(UUID.randomUUID())
                .name("Toblerone")
                .style("Recheado")
                .build();
    }

    @Override
    public ChocolateDto saveNewChocolate(ChocolateDto dto) {
        return ChocolateDto.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateChocolate(UUID id, ChocolateDto dto) {
        // todo impl - would add a real impl
    }

    @Override
    public void deleteChocolate(UUID id, ChocolateDto dto) {
      log.debug("Deleting a chocolate...");
    }
}
