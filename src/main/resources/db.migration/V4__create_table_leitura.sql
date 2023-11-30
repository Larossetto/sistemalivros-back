CREATE TABLE `leitura` (
 `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `data` date NOT NULL,
 `livro_id` bigint NOT NULL,
 `usuario_id` bigint NOT NULL,
 FOREIGN KEY (`livro_id`) REFERENCES `livro` (`id`),
 FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
);