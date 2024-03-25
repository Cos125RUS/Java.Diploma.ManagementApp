package ru.steeldv.processor.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "documents")
public interface DocumentsClientApi {
}
