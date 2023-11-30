CREATE TABLE `livro` (
 `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `titulo` varchar(255) NOT NULL,
 `isbn` varchar(255) NOT NULL,
 `autor_id` bigint NOT NULL,
 FOREIGN KEY (`autor_id`) REFERENCES `autor` (`id`),
)