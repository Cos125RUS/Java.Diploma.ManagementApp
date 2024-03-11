package ru.steeldv.front.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.steeldv.front.service.impl.StorageServiceImpl;
import ru.steeldv.front.service.storage.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/storage")
public class StorageController {
    private final AvailabilityService availabilityService;
    private final PositionService positionService;
    private final StorageService storageService;
    private final StorageUnitService storageUnitService;
    private final UnitService unitService;


}
