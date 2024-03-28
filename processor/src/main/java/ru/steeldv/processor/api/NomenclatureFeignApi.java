package ru.steeldv.processor.api;

import org.springframework.cloud.openfeign.FeignClient;
import ru.steeldv.library.api.NomenclatureApi;

@FeignClient(name = "nomenclature")
public interface NomenclatureFeignApi extends NomenclatureApi {
}
