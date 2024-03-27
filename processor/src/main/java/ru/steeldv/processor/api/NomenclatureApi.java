package ru.steeldv.processor.api;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "nomenclature")
public interface NomenclatureApi {
}
