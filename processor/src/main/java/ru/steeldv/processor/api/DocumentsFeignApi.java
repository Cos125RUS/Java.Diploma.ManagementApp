package ru.steeldv.processor.api;

import org.springframework.cloud.openfeign.FeignClient;
import ru.steeldv.library.api.DocumentsApi;

@FeignClient(name = "documents")
public interface DocumentsFeignApi extends DocumentsApi {
}
