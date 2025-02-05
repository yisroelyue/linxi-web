-- linxidb.love_music definition

CREATE TABLE `love_music` (
                              `id` int NOT NULL AUTO_INCREMENT,
                              `musicId` int NOT NULL DEFAULT '0',
                              `createdAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                              `updatedAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;