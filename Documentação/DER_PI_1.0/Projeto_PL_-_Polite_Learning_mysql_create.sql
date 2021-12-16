CREATE TABLE `tb_post` (
	`id` int(4) NOT NULL AUTO_INCREMENT,
	`titulo` varchar(255) NOT NULL,
	`conteudo` varchar(255) NOT NULL,
	`data` DATE(255) NOT NULL,
	`imagem` varchar(255) NOT NULL,
	`fk_tema` int(4) NOT NULL,
	`fk_usuario` int(4) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `tb_tema` (
	`id` int(3) NOT NULL AUTO_INCREMENT,
	`educacao` varchar(255) NOT NULL,
	`atualidades` varchar(255) NOT NULL,
	`recreio` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `tb_usuario` (
	`id` int(3) NOT NULL AUTO_INCREMENT,
	`nome_completo` varchar(255) NOT NULL,
	`email` varchar(255) NOT NULL UNIQUE,
	`senha` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `tb_post` ADD CONSTRAINT `tb_post_fk0` FOREIGN KEY (`fk_tema`) REFERENCES `tb_tema`(`id`);

ALTER TABLE `tb_post` ADD CONSTRAINT `tb_post_fk1` FOREIGN KEY (`fk_usuario`) REFERENCES `tb_usuario`(`id`);




