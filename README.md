# 📦 Document Storage System (Spring Core Annotation-Based Project)

## 🧭 Overview
This project demonstrates a **Spring Core annotation-based application** that simulates a **Document Storage System**.  
The system allows storing files in different storage types such as:
- ☁️ **Cloud Storage**
- 🗄️ **Database Storage**
- 💾 **File System Storage**

It showcases **Dependency Injection**, **@Qualifier**, and **Singleton Scope** concepts — using **annotations only** (no XML configuration).

---

## ⚙️ Project Details

**Project Name:** `DocumentsStorageSystem`  
**Framework:** Spring Core (Annotation-based Configuration)  
**Language:** Java  
**Build Tool:** Maven

---

## 🧩 Features Demonstrated


| Concept | Description |

|----------|--------------|

| **Dependency Injection** | Achieved using `@Autowired` |

| **Qualifier** | Used `@Qualifier` to choose a specific storage implementation |

| **Singleton Scope** | Ensures only one instance of each bean |

| **@ComponentScan** | Enables automatic detection of beans in the package |

| **AnnotationConfigApplicationContext** | Loads Spring context without XML |

---

## 🏗️ Project Structure

src/main/java/

└── com/cs/documents_storage/

├── comp/

│ ├── StorageService.java

│ ├── CloudStorageService.java

│ ├── DatabaseStorageService.java

│ ├── FileSystemStorageService.java

│ └── StorageManager.java

├── config/

│ └── AppConfig.java

└── main/

└── StorageServiceSystem.java

---

## 🔄 How It Works (Flow Explanation)

         ┌──────────────────────────────┐
         │     AppConfig.class          │
         │  (Configuration + Scan)      │
         └──────────────┬───────────────┘
                        │
                        ▼
       ┌────────────────────────────────────┐
       │ AnnotationConfigApplicationContext │
       │  → Scans com.cs.documents_storage  │
       │  → Creates Singleton Beans         │
       └────────────────┬───────────────────┘
                        │
                        ▼
           ┌────────────────────────────┐
           │    StorageManager Bean     │
           │  @Autowired + @Qualifier   │
           │  injects CloudStorageService│
           └────────────────────────────┘
                        │
                        ▼
         ┌────────────────────────────────────┐
         │ manager1.save("Resume")             │
         │  → calls CloudStorageService.store() │
         └────────────────────────────────────┘
                        │
                        ▼
         ┌────────────────────────────────────┐
         │ manager2.save("CV")                 │
         │  → uses same Singleton beans        │
         └────────────────────────────────────┘
                        │
                        ▼
         Output:
         - Same hashcodes for StorageManager
         - Same hashcodes for StorageService
         ✅ Confirms Singleton Scope


## 🧪 Expected Output


==== Saving File Operation ====

📂 Attempting to store file: Resume

Storage Manager Hashcode: 365181913

Using StorageService: CloudStorageService

Hashcode of injected storage service: 1034568234

✅ Storing Resume in Cloud Storage

------------------------------------

==== Saving File Operation ====

📂 Attempting to store file: CV

Storage Manager Hashcode: 365181913

Using StorageService: CloudStorageService

Hashcode of injected storage service: 1034568234

✅ Storing CV in Cloud Storage

------------------------------------
Manager1 hashcode: 365181913
Manager2 hashcode: 365181913

## ✅ This confirms:

StorageManager is a singleton

Injected StorageService is also a singleton

Dependency Injection and Qualifier are working correctly


## 🛠️ How to Run

Clone or create the Maven project.

Add the spring-context dependency in your pom.xml:

<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>6.1.2</version>
</dependency>

Compile and run StorageServiceSystem.java.

Observe the output in the console.

## 🚀 Future Enhancements (Optional)

Demonstrate Prototype scope to compare with Singleton.

Add @PostConstruct and @PreDestroy for lifecycle demonstration.

Make storage type configurable via application.properties.

Integrate Spring Boot for simplified configuration.
