package com.cs.documents_storage.comp;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("file")
@Scope("singleton")
public class FileSystemStorageService implements StorageService {

	@Override
	public void store(String fileName) {
		if (fileName == null || fileName.trim().isEmpty()) {
			System.out.println("❌ Invalid file name! Cannot store in Local File System.");
			return;
		}
		if (fileName.endsWith(".exe")) {
			System.out.println("⚠️ Dangerous file type! Cannot store executable files.");
			return;
		}

		System.out.println("✅ Storing " + fileName + " in Local File System");
	}
}
