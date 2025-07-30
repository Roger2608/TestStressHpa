package com.example.demohpa.util;

import java.util.ArrayList;
import java.util.List;

public class Util {
	public static long consumCPU(int iterations) {
		// Consumo de CPU: Cálculo de números primos
		long cpuStart = System.currentTimeMillis();
		int count = 0;
		for (int i = 2; i < iterations; i++) {
			if (isPrime(i)) {
				count++;
			}
		}
		long cpuEnd = System.currentTimeMillis();
		return cpuEnd - cpuStart;
	}
	
	public static void allocateMemory(int memorySize) {
		// Consumo de memoria: Asignación de un array grande
		List<byte[]> memoryHog = new ArrayList<>();
		for (int i = 0; i < memorySize; i++) {
			memoryHog.add(new byte[1024 * 1024]); // 1 MB por iteración
		}
	}
	
	public static boolean isPrime(int number) {
		if (number < 2) return false;
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) return false;
		}
		return true;
	}
}
