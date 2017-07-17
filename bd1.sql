-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.7.14 - MySQL Community Server (GPL)
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Copiando estrutura para tabela defin712_eventosuff.administrador
DROP TABLE IF EXISTS `administrador`;
CREATE TABLE IF NOT EXISTS `administrador` (
  `UsuarioId` int(4) NOT NULL,
  `CPF` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Copiando dados para a tabela defin712_eventosuff.administrador: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
INSERT INTO `administrador` (`UsuarioId`, `CPF`) VALUES
	(1, '11698346718');
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;

-- Copiando estrutura para tabela defin712_eventosuff.aluno
DROP TABLE IF EXISTS `aluno`;
CREATE TABLE IF NOT EXISTS `aluno` (
  `UsuarioId` int(4) NOT NULL,
  `Matricula` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Copiando dados para a tabela defin712_eventosuff.aluno: ~8 rows (aproximadamente)
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` (`UsuarioId`, `Matricula`) VALUES
	(4, '123456789'),
	(7, ''),
	(8, ''),
	(9, ''),
	(10, ''),
	(11, ''),
	(12, ''),
	(13, '');
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;

-- Copiando estrutura para tabela defin712_eventosuff.ambiente
DROP TABLE IF EXISTS `ambiente`;
CREATE TABLE IF NOT EXISTS `ambiente` (
  `AmbienteId` int(4) NOT NULL AUTO_INCREMENT,
  `Descricao` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `Endereco` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `OcupacaoMaxima` int(4) NOT NULL,
  PRIMARY KEY (`AmbienteId`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Copiando dados para a tabela defin712_eventosuff.ambiente: 11 rows
/*!40000 ALTER TABLE `ambiente` DISABLE KEYS */;
INSERT INTO `ambiente` (`AmbienteId`, `Descricao`, `Endereco`, `OcupacaoMaxima`) VALUES
	(1, 'Sala 301 - Instituto de Computacão - Campus P. Vermelha', 'Av. Gal. Milton Tavares de Souza, sn - CEP 24210-346 - Niterói - RJ', 50),
	(2, 'Sala 302 - Instituto de Computacão - Campus P. Vermelha', 'Av. Gal. Milton Tavares de Souza, sn - CEP 24210-346 - Niterói - RJ', 50),
	(3, 'Sala 303 - Instituto de Computacão - Campus P. Vermelha', 'Av. Gal. Milton Tavares de Souza, sn - CEP 24210-346 - Niterói - RJ', 50),
	(4, 'Sala 304 - Instituto de Computacão - Campus P. Vermelha', 'Av. Gal. Milton Tavares de Souza, sn - CEP 24210-346 - Niterói - RJ', 50),
	(5, 'Auditorio 1 - Instituto de Computacão - Campus P. Vermelha', 'Av. Gal. Milton Tavares de Souza, sn - CEP 24210-346 - Niterói - RJ', 150),
	(6, 'Auditorio 2 - Instituto de Computacão - Campus P. Vermelha', 'Av. Gal. Milton Tavares de Souza, sn - CEP 24210-346 - Niterói - RJ', 150),
	(7, 'Sala 10 - Prédio da Administração - Valonguinho', 'Alameda Professor Barros Terra, s/n - Centro, Niterói - RJ, 24020-150', 40),
	(8, 'Sala 11 - Prédio da Administração - Valonguinho', 'Alameda Professor Barros Terra, s/n - Centro, Niterói - RJ, 24020-150', 30),
	(9, 'Sala 12 - Prédio da Administração - Valonguinho', 'Alameda Professor Barros Terra, s/n - Centro, Niterói - RJ, 24020-150', 40),
	(10, 'Auditorio 1 - Prédio da Administração - Valonguinho', 'Alameda Professor Barros Terra, s/n - Centro, Niterói - RJ, 24020-150', 80),
	(11, 'Auditorio 2 - Prédio da Administração - Valonguinho', 'Alameda Professor Barros Terra, s/n - Centro, Niterói - RJ, 24020-150', 90);
/*!40000 ALTER TABLE `ambiente` ENABLE KEYS */;

-- Copiando estrutura para tabela defin712_eventosuff.employee
DROP TABLE IF EXISTS `employee`;
CREATE TABLE IF NOT EXISTS `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `joining_date` date NOT NULL,
  `salary` double NOT NULL,
  `ssn` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ssn` (`ssn`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Copiando dados para a tabela defin712_eventosuff.employee: 2 rows
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`id`, `name`, `joining_date`, `salary`, `ssn`) VALUES
	(1, 'Renan', '2017-10-10', 100, 'XX'),
	(2, 'Wilker', '2017-09-10', 1000, 'dd');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;

-- Copiando estrutura para tabela defin712_eventosuff.evento
DROP TABLE IF EXISTS `evento`;
CREATE TABLE IF NOT EXISTS `evento` (
  `EventoId` int(4) NOT NULL AUTO_INCREMENT,
  `EventoCategoriaId` int(4) DEFAULT '0',
  `AmbienteId` int(4) DEFAULT '0',
  `UsuarioId` int(4) DEFAULT '0',
  `Ocupacao` int(4) DEFAULT '0',
  `Descricao` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `DescricaoLonga` varchar(1500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Pessoa` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DataInicio` date DEFAULT NULL,
  `HoraInicio` time DEFAULT NULL,
  `Duracao` int(4) DEFAULT '0',
  `Estatus` int(4) DEFAULT '0' COMMENT '/* 0 pendente 1 cancelado 2 Autorizado */',
  PRIMARY KEY (`EventoId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Copiando dados para a tabela defin712_eventosuff.evento: ~15 rows (aproximadamente)
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` (`EventoId`, `EventoCategoriaId`, `AmbienteId`, `UsuarioId`, `Ocupacao`, `Descricao`, `DescricaoLonga`, `Pessoa`, `DataInicio`, `HoraInicio`, `Duracao`, `Estatus`) VALUES
	(1, 1, 1, 2, 10, 'Saúde da Mulher na atenção básica', 'Descricao Longa', 'Luiz Fernando', '2017-07-20', '17:00:00', 60, 2),
	(2, 2, 4, 2, 32, 'Pesquisas intelectuais e circularidade cultural', 'Descricao Longa', 'Luiz Fernando', '2017-07-18', '11:00:00', 90, 2),
	(3, 4, 5, 3, 10, 'A Lei 10.639 e o combate a intolerância religiosa', 'Descricao Longa', 'Luiz Fernando', '2017-07-23', '13:01:00', 120, 2),
	(4, 7, 2, 2, 2, 'Festival de curta a escola de engenharia', 'Descricao Longa', 'Luiz Fernando', '2017-07-18', '18:00:00', 90, 2),
	(5, 8, 1, 4, 10, 'Olimpíada brasileira de cartografia', 'Descricao Longa', 'Luiz Fernando', '2017-07-19', '10:00:00', 120, 2),
	(6, 5, 3, 4, 10, 'Bioseguraça: Ações de controle a saúde', 'Descricao Longa', 'Luiz Fernando', '2017-08-06', '14:30:00', 60, 2),
	(7, 3, 11, 3, 10, 'Escola de Inverno em Teoria da Computação', 'Descricao Longa', 'Luiz Fernando', '2017-07-24', '13:00:00', 60, 2),
	(8, 3, 3, 3, 10, 'Reflexões sobre o estado em Redes elétricas', 'Descricao Longa', 'Luiz Fernando', '2017-07-20', '12:00:00', 45, 2),
	(9, 6, 3, 3, 10, 'Robôs, e mais populações sobre fundo evolucionário', 'Descricao Longa', 'Luiz Fernando', '2017-07-23', '19:00:00', 45, 2),
	(10, 7, 9, 3, 10, 'Espiritualidade, Saúde e Trabalho em Tecnológica', 'Descricao Longa', 'Luiz Fernando', '2017-07-24', '13:45:00', 90, 2),
	(11, 2, 9, 3, 10, 'Marcha pela ciência', 'Descricao Longa', 'Luiz Fernando', '2017-08-12', '09:00:00', 150, 2),
	(12, 8, 7, 3, 10, 'Many-Objective Optimization with Algorithms', 'Descricao Longa', 'Luiz Fernando', '2017-08-04', '16:30:00', 60, 1),
	(13, 1, 1, 3, 10, 'Evento 14', 'longo', 'eu', '2017-07-25', '15:00:00', 10, 2),
	(14, 3, 2, 2, 10, 'Evento 15', 'xx', 'Eu de novo', '2017-07-26', '14:00:00', 90, 0),
	(15, 6, 7, 5, 50, 'Evento 16', 'longa', 'Raphael', '2017-07-29', '19:00:00', 90, 1);
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;

-- Copiando estrutura para tabela defin712_eventosuff.eventocategoria
DROP TABLE IF EXISTS `eventocategoria`;
CREATE TABLE IF NOT EXISTS `eventocategoria` (
  `EventoCategoriaId` int(4) NOT NULL AUTO_INCREMENT,
  `Descricao` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `Acronimo` varchar(10) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`EventoCategoriaId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Copiando dados para a tabela defin712_eventosuff.eventocategoria: ~8 rows (aproximadamente)
/*!40000 ALTER TABLE `eventocategoria` DISABLE KEYS */;
INSERT INTO `eventocategoria` (`EventoCategoriaId`, `Descricao`, `Acronimo`) VALUES
	(1, 'Palestra', 'plet'),
	(2, 'WorkShop', 'wors'),
	(3, 'Curso', 'crso'),
	(4, 'Seminário', 'smin'),
	(5, 'Simpósio', 'simp'),
	(6, 'Lançamento', 'lamc'),
	(7, 'Feira', 'fera'),
	(8, 'Congresso', 'cong');
/*!40000 ALTER TABLE `eventocategoria` ENABLE KEYS */;

-- Copiando estrutura para tabela defin712_eventosuff.professor
DROP TABLE IF EXISTS `professor`;
CREATE TABLE IF NOT EXISTS `professor` (
  `UsuarioId` int(4) NOT NULL,
  `EmailContato` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Copiando dados para a tabela defin712_eventosuff.professor: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
INSERT INTO `professor` (`UsuarioId`, `EmailContato`) VALUES
	(2, 'leocruz@id.uff.br'),
	(3, 'viterbo@id.uff.br'),
	(5, 'guerra@id.uff.br'),
	(6, 'tcris@id.uff.br'),
	(14, 'danipaiva@gmail.com');
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;

-- Copiando estrutura para tabela defin712_eventosuff.recurso
DROP TABLE IF EXISTS `recurso`;
CREATE TABLE IF NOT EXISTS `recurso` (
  `RecursoId` int(4) NOT NULL AUTO_INCREMENT,
  `Descricao` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`RecursoId`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Copiando dados para a tabela defin712_eventosuff.recurso: 1 rows
/*!40000 ALTER TABLE `recurso` DISABLE KEYS */;
INSERT INTO `recurso` (`RecursoId`, `Descricao`) VALUES
	(1, 'Projetor');
/*!40000 ALTER TABLE `recurso` ENABLE KEYS */;

-- Copiando estrutura para tabela defin712_eventosuff.reserva
DROP TABLE IF EXISTS `reserva`;
CREATE TABLE IF NOT EXISTS `reserva` (
  `ReservaId` int(4) NOT NULL AUTO_INCREMENT,
  `UsuarioId` int(4) NOT NULL DEFAULT '0',
  `EventoId` int(4) NOT NULL DEFAULT '0',
  `DataReserva` date NOT NULL,
  `HoraReserva` time NOT NULL,
  `Estatus` int(4) NOT NULL DEFAULT '1' COMMENT '/*  0 = Cancela, 1 = Ativa   */',
  PRIMARY KEY (`ReservaId`)
) ENGINE=MyISAM AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Copiando dados para a tabela defin712_eventosuff.reserva: 27 rows
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` (`ReservaId`, `UsuarioId`, `EventoId`, `DataReserva`, `HoraReserva`, `Estatus`) VALUES
	(1, 1, 1, '2017-07-15', '00:49:22', 1),
	(2, 2, 1, '2017-07-15', '00:53:22', 1),
	(3, 3, 1, '2017-07-15', '01:34:35', 1),
	(4, 4, 1, '2017-07-15', '11:48:08', 0),
	(5, 1, 2, '2017-07-15', '11:50:04', 0),
	(6, 2, 2, '2017-07-15', '12:25:53', 1),
	(7, 3, 2, '2017-07-15', '13:28:57', 1),
	(8, 4, 2, '2017-07-15', '14:51:46', 1),
	(9, 1, 3, '2017-07-15', '14:59:18', 0),
	(10, 2, 3, '2017-07-15', '15:07:01', 0),
	(11, 3, 3, '2017-07-15', '15:07:31', 1),
	(12, 4, 3, '2017-07-15', '15:07:38', 1),
	(13, 1, 4, '2017-07-15', '16:23:41', 1),
	(14, 7, 5, '2017-07-16', '20:21:00', 1),
	(15, 5, 6, '2017-07-16', '20:22:11', 1),
	(16, 3, 4, '2017-07-16', '22:34:41', 0),
	(17, 4, 4, '2017-07-16', '22:35:13', 0),
	(18, 5, 4, '2017-07-16', '22:35:42', 0),
	(19, 6, 4, '2017-07-16', '22:36:13', 1),
	(20, 7, 4, '2017-07-16', '22:36:31', 1),
	(21, 8, 4, '2017-07-16', '22:36:46', 1),
	(22, 9, 4, '2017-07-16', '22:36:58', 1),
	(23, 10, 4, '2017-07-16', '22:37:15', 0),
	(24, 11, 4, '2017-07-16', '22:37:30', 1),
	(25, 12, 4, '2017-07-16', '22:37:43', 1),
	(26, 13, 4, '2017-07-16', '22:37:57', 1),
	(27, 14, 4, '2017-07-16', '22:38:19', 1);
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;

-- Copiando estrutura para tabela defin712_eventosuff.usuario
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `UsuarioId` int(4) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(60) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `Login` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Senha` varchar(12) COLLATE utf8_unicode_ci NOT NULL,
  `UsaAdmin` int(4) NOT NULL DEFAULT '0',
  `Estatus` int(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`UsuarioId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Copiando dados para a tabela defin712_eventosuff.usuario: ~14 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`UsuarioId`, `Nome`, `Login`, `Senha`, `UsaAdmin`, `Estatus`) VALUES
	(1, 'Viterbo', 'gerente@id.uff.br', '123456', 1, 1),
	(2, 'Leonardo Cruz', 'leocruz@id.uff.br', '123456', 1, 1),
	(3, 'Daniel Oliveira', 'daniel@id.uff.br', '123456', 1, 1),
	(4, 'Renan Vieira', 'renanvieira@id.uff.br', '123456', 0, 1),
	(5, 'Raphael Guerra', 'guerra@id.uff.br', '123456', 1, 1),
	(6, 'Teresa Cristina', 'tcris@id.uff.br', '123456', 1, 1),
	(7, 'Josimar Junior', 'josimar@id.uff.br', '123456', 0, 1),
	(8, 'Wilker Delfino', 'wilker@id.uff.br', '123456', 0, 1),
	(9, 'Victor Conte', 'conte@id.uff.br', '123456', 0, 1),
	(10, 'Marilia Pires', 'gabi@id.uff.br', '123456', 0, 1),
	(11, 'Raphaela Machado', 'rmachado@id.uff.br', '123456', 0, 1),
	(12, 'Juliana Paes', 'jpaes@id.uff.br', '123456', 0, 1),
	(13, 'Debora Secco', 'dsecco@id.uff.br', '123456', 0, 1),
	(14, 'Danielen Paiva', 'danipaiva@gmail.com', '123456', 0, 1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
