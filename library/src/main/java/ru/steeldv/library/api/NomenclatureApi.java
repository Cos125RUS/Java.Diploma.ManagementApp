package ru.steeldv.library.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.library.model.dto.nomenclature.PositionList;

@FeignClient(name = "nomenclature")
public interface NomenclatureApi {
    //    region positionList
    @GetMapping("/findPositionList/{id}")
    public ResponseEntity<PositionList> findPositionList(@PathVariable Long id);
    @PostMapping("/addPositionList")
    public ResponseEntity<PositionList> addPositionList(@RequestBody PositionList positionList);
    @PutMapping("/update")
    public ResponseEntity<PositionList> updatePositionList(@RequestBody PositionList positionList);
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePositionList(@PathVariable Long id);
//    endregion positionList
}
