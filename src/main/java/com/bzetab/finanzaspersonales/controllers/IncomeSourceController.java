package com.bzetab.finanzaspersonales.controllers;

import com.bzetab.finanzaspersonales.models.entities.IncomeSource;
import com.bzetab.finanzaspersonales.services.IncomeSourceService;
import com.bzetab.finanzaspersonales.utils.exceptions.model.SuccessResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/income-source")
public class IncomeSourceController {

    private final IncomeSourceService incomeSourceService;

    public IncomeSourceController(IncomeSourceService incomeSourceService) {
        this.incomeSourceService = incomeSourceService;
    }

    @PostMapping("/create")
    public ResponseEntity<SuccessResponse> createIncomeSource(@Valid @RequestBody IncomeSource incomeSource) {
        return ResponseEntity.ok(SuccessResponse.builder()
                        .status(HttpStatus.CREATED.value())
                        .message("Income source created successfully")
                        .data(incomeSourceService.createIncomeSource(incomeSource))
                        .build());
    }

    @GetMapping
    public ResponseEntity<SuccessResponse> findIncomeSourceByName(@NotBlank(message = "Name is required") @RequestParam("name") String name ){
        return ResponseEntity.ok(
                SuccessResponse.builder()
                        .message("Income source found successfully")
                        .status(HttpStatus.OK.value())
                        .data(incomeSourceService.findByName(name))
                        .build());
    }

}
