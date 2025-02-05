-- linxidb.music_sheet definition

CREATE TABLE `music_sheet` (
                               `id` int NOT NULL AUTO_INCREMENT,
                               `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
                               `icUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '',
                               `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
                               `userId` int NOT NULL DEFAULT '0',
                               `musicIds` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '',
                               `createdAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                               `updatedAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;