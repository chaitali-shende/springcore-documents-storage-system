package com.cs.documents_storage.comp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class StorageManager {
	@Autowired
	@Qualifier("cloud")  //inject file / cloud / database
	private StorageService storageService;
	
	public void save(String file) {
		System.out.println("==== Saving File Operation ====");
		System.out.println("📂 Attempting to store file: " + file);
		System.out.println("Storage Manager Hashcode: "+this.hashCode());
		System.out.println("Using StorageService: " + storageService.getClass().getSimpleName());
		System.out.println("Hashcode of injected storage service: "+storageService.hashCode());
		
		if (file == null || file.trim().isEmpty()) {
			System.out.println("❌ Error: File name cannot be null or empty.");
			System.out.println();
			return;
		}

		storageService.store(file);
		System.out.println("------------------------------------");
	}
}
