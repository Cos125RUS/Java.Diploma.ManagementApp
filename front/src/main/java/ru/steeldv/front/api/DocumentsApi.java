package ru.steeldv.front.api;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "documents")
public interface DocumentsApi {
}
