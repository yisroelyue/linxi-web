-- linxidb.music definition

CREATE TABLE `music` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `fileName` varchar(255) NOT NULL DEFAULT '',
                         `filePath` varchar(255) NOT NULL DEFAULT '',
                         `lyricPath` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '',
                         `icPath` varchar(255) DEFAULT '',
                         `artist` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '未知',
                         `album` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '未知',
                         `genre` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '未知',
                         `duration` varchar(50) DEFAULT '0',
                         `releaseDate` date DEFAULT '1970-01-01',
                         `fileSize` bigint DEFAULT '0',
                         `createdAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                         `updatedAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;