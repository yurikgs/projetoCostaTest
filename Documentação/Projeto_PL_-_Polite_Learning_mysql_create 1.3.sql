CREATE TABLE `tb_post` (
	`id_post` bigint NOT NULL,
	`titulo` varchar(255) NOT NULL,
	`conteudo` varchar(255) NOT NULL,
	`data` DATE NOT NULL,
	`imagem` varchar(255) NOT NULL,
	`fk_tema` bigint NOT NULL,
	`fk_usuario` bigint NOT NULL,
	PRIMARY KEY (`id_post`)
);

CREATE TABLE `tb_tema` (
	`id_tema` bigint NOT NULL,
	`descricao` varchar(255) NOT NULL,
	`imagem` varchar(255) NOT NULL,
	`relacionados` varchar(255) NOT NULL,
	PRIMARY KEY (`id_tema`)
);

CREATE TABLE `tb_usuario` (
	`id_usuario` bigint NOT NULL,
	`nome_completo` varchar(255) NOT NULL,
	`email` varchar(255) NOT NULL UNIQUE,
	`senha` varchar(255) NOT NULL,
	PRIMARY KEY (`id_usuario`)
);

ALTER TABLE `tb_post` ADD CONSTRAINT `tb_post_fk0` FOREIGN KEY (`fk_tema`) REFERENCES `tb_tema`(`id_tema`);

ALTER TABLE `tb_post` ADD CONSTRAINT `tb_post_fk1` FOREIGN KEY (`fk_usuario`) REFERENCES `tb_usuario`(`id_usuario`);




