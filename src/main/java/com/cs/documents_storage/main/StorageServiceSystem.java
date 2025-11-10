package com.cs.documents_storage.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cs.documents_storage.comp.StorageManager;
import com.cs.documents_storage.config.AppConfig;

public class StorageServiceSystem {

	public static void main(String[] args) {
		try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);) {
			StorageManager manager1 = ctx.getBean(StorageManager.class);
			StorageManager manager2 = ctx.getBean(StorageManager.class);
			
			manager1.save("Resume");
			manager2.save("CV");
			
			System.out.println("Manager1 hashcode: "+manager1.hashCode());
			System.out.println("Manager2 hashcode: "+manager2.hashCode());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
