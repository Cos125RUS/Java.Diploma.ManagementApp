package ru.steeldv.front.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "documents")
public interface DocumentsClientApi {
}
