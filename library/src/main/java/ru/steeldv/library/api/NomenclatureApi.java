package ru.steeldv.library.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "nomenclature")
public interface NomenclatureApi {
}
