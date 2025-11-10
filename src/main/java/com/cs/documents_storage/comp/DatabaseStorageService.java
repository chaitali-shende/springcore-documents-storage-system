package com.cs.documents_storage.comp;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("database")
@Scope("singleton")
public class DatabaseStorageService implements StorageService {

	@Override
	public void store(String fileName) {
		if (fileName == null || fileName.trim().isEmpty()) {
			System.out.println("❌ Invalid file name! Cannot store in Database.");
			return;
		}
		if (!fileName.matches("[A-Za-z0-9_-]+")) {
			System.out.println("❌ Invalid characters in file name! Only letters, numbers, '_' and '-' are allowed.");
			return;
		}

		System.out.println("✅ Storing " + fileName + " in Database");
	}
}
