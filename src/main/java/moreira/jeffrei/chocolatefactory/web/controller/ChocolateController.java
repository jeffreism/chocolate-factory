package moreira.jeffrei.chocolatefactory.web.controller;

import moreira.jeffrei.chocolatefactory.web.model.ChocolateDto;
import moreira.jeffrei.chocolatefactory.web.services.ChocolateService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/chocolate")
@RestController
public class ChocolateController {

    private final ChocolateService chocolateService;

    public ChocolateController(ChocolateService chocolateService) {
        this.chocolateService = chocolateService;
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<ChocolateDto> getChocolate(@PathVariable UUID id) {
        return new ResponseEntity<>(chocolateService.getChocolateById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody ChocolateDto dto) {
        ChocolateDto savedDto = chocolateService.saveNewChocolate(dto);

        HttpHeaders headers = new HttpHeaders();
        // TODO add hostname to url
        headers.add("Location", "/api/v1/chocolate/" + savedDto.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity handleUpdate(@PathVariable UUID id, @RequestBody ChocolateDto dto) {
        chocolateService.updateChocolate(id, dto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteChocolate(@PathVariable UUID id, @RequestBody ChocolateDto dto) {
        chocolateService.deleteChocolate(id, dto);
    }
}
