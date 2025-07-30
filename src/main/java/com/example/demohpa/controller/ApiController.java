package com.example.demohpa.controller;

import com.example.demohpa.util.Util;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
	
	@GetMapping("/greet")
	public String welcome(@RequestParam String name) {
		return "Bienvenido, " + name + "!";
	}
	
	@GetMapping("/rxjava/greet")
	public Single<String> greet(@RequestParam String name) {
		return Single.fromCallable(() -> "Bienvenido, " + name + "!");
	}
	
	@GetMapping("/rxjava/stress")
	public Single<String> stressTest(
			@RequestParam(defaultValue = "10000") int iterations,
			@RequestParam(defaultValue = "100") int memorySize) {
		return Single.fromCallable(() -> {
			var consumCPU = Util.consumCPU(iterations);
			Util.allocateMemory(memorySize);
			return String.format("CPU Time: %d ms, Memory Allocated: %d MB",
					consumCPU, memorySize);
		}).subscribeOn(Schedulers.io());
	}
	
	
}
