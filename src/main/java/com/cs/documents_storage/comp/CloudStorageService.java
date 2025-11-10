package com.cs.documents_storage.comp;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("cloud")
@Scope("singleton")
public class CloudStorageService implements StorageService {

	@Override
	public void store(String fileName) {
		if (fileName == null || fileName.trim().isEmpty()) {
			System.out.println("❌ Invalid file name! Cannot store in Cloud Storage.");
			return;
		}
		System.out.println("✅ Storing " + fileName + " in Cloud Storage");
	}
}
