-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le :  sam. 18 nov. 2017 à 17:16
-- Version du serveur :  10.1.28-MariaDB
-- Version de PHP :  7.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `DB_KtxPayementOnLine`
--

-- --------------------------------------------------------

--
-- Structure de la table `ABONNMENT`
--

CREATE TABLE `ABONNMENT` (
  `ID_ABONNEMENT` int(11) NOT NULL,
  `LIBELLE` varchar(50) NOT NULL,
  `TYPE` varchar(50) NOT NULL,
  `DATE_DEBUT` date NOT NULL,
  `DATE_FIN` date NOT NULL,
  `MONTANT` double NOT NULL,
  `ID_COMPTE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `CLIENT`
--

CREATE TABLE `CLIENT` (
  `ID_CLIENT` int(11) NOT NULL,
  `CIVILITE` varchar(25) NOT NULL,
  `NOM` varchar(50) NOT NULL,
  `PRENOM` varchar(50) NOT NULL,
  `DATE_NAISSANCE` date NOT NULL,
  `LIEU_NAISSANCE` varchar(50) NOT NULL,
  `SEXE` varchar(25) NOT NULL,
  `TYPE_CLIENT` varchar(25) NOT NULL,
  `TYPE_PIECE_IDENTITE` varchar(100) NOT NULL,
  `REF_PIECE_IDENTITE` varchar(100) NOT NULL,
  `ADRESSE` varchar(100) NOT NULL,
  `TELEPHONE` varchar(25) NOT NULL,
  `EMAIL` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `CLIENT`
--

INSERT INTO `CLIENT` (`ID_CLIENT`, `CIVILITE`, `NOM`, `PRENOM`, `DATE_NAISSANCE`, `LIEU_NAISSANCE`, `SEXE`, `TYPE_CLIENT`, `TYPE_PIECE_IDENTITE`, `REF_PIECE_IDENTITE`, `ADRESSE`, `TELEPHONE`, `EMAIL`) VALUES
(1, 'Monsieur', 'DIALLO', 'Azise', '1988-09-11', 'Bobo', 'Masculin', 'Etudiant', 'Passport', 'CE-120000', 'adrwer', '1256789', 'diallitoz@gmail.com'),
(3, 'Monsieur', 'KOUADIO', 'Olivier', '1991-09-11', 'YopCity', 'Masculin', 'Etudiant', 'Passport', 'A111 du 11 Sep 2015', 'ky tuc xa My dinh', '016698053416', 'kouadio.p21@ifi.edu.vn'),
(4, 'M', 'KFANDO', 'Rodrique', '1993-09-11', 'Ouaga', 'M', 'Etudiant', 'Passport', 'A111 du 11 Sep 2015', 'ky tuc xa My dinh', '01665853416', 'kafando.p21@ifi.edu.vn'),
(6, 'Mademoiselle', 'HONG', 'Minh', '1988-10-27', 'BaviCity', 'Feminin', 'Etudiant', 'Carte d\'etudiant', 'CE-120000', 'Ky tuc xa', '1234567890', 'minh@gamil.com'),
(7, 'Monsieur', 'QUANG', 'Toto', '1980-10-27', 'Hanoi', 'Masculin', 'Prestataire', 'Carte d\'identite nationale', 'CIN-120000', 'Hanoi jiienrioneorn', '1234567890', 'quang@gamil.com'),
(8, 'Monsieur', 'papa', 'papa', '1985-10-25', 'Ho Chi Min ', 'Masculin', 'Prestataire', 'Carte d\'identite nationale', 'wwwwwwwwwwwww', 'Hanoi jiienrioneorn', '1234567890', 'popo@gmail.com'),
(9, 'Monsieur', 'bboob', 'bobo', '1988-10-27', 'yop', 'Feminin', 'Etudiant', 'Passport', 'eeeeeeeeeeee', 'rrrrrrrrrrrt rrf', '1256789', 'bobo@gmail.com'),
(10, 'Madame', 'mama', 'mama', '2000-10-10', 'BaviCity', 'Feminin', 'Prestataire', 'Carte d\'identite nationale', 'aaaaaa', 'aaaaaaaaaaaa', '1256789', 'mama@gmail.com'),
(11, 'Monsieur', 'vavav', 'vava', '1988-10-27', 'BaviCity', 'Feminin', 'Prestataire', 'Passport', 'w', 'www', '123456789', 'vava@gmail.com'),
(12, 'Monsieur', 'HONG', 'Trang', '1988-10-27', 'BaviCity', 'Masculin', 'Prestataire', 'Passport', 'CIN-120000', 'Hanoi jiienrioneorn', '123456789', 'tata@gmail.com'),
(13, 'Mademoiselle', 'HONG', 'Hang', '1985-10-25', 'Hanoi', 'Feminin', 'Etudiant', 'Carte d\'etudiant', 'CE-120000', 'Ky tuc xa', '1234567890', 'hang@gmail.com'),
(14, 'Monsieur', 'koko', 'koko', '1988-10-27', 'yop', 'Masculin', 'Etudiant', 'Carte d\'identite nationale', 'CE-120000', 'Hanoi jiienrioneorn', '123456789', 'koko@gmail.com'),
(15, 'Monsieur', 'client1', 'client1', '1985-10-25', 'Hanoi', 'Masculin', 'Etudiant', 'Passport', 'CE-120000', 'Ky tuc xa', '123456789', 'client1@gamil.com'),
(16, 'Monsieur', 'sani', 'sani', '1985-10-25', 'Hanoi', 'Masculin', 'Etudiant', 'Passport', 'CE-120000', 'Ky tuc xa', '1234567890', 'sani@gmail.com'),
(17, 'M', 'DIALLO', 'Azise', '1988-09-11', 'Bobo', 'M', 'Etudiant', 'Passport', 'A111 du 11 Sep 2015', 'ky tuc xa My dinh', '01665853416', 'diallo.p21@ifi.edu.vn'),
(18, 'Monsieur', 'DIALLO', 'Azise Oumar', '1988-10-27', 'Bobo-Dioulasso', 'Masculin', 'Etudiant', 'Passport', 'CE-120000', 'Ky tuc xa', '1234567890', 'diallitoz@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `COMPTE`
--

CREATE TABLE `COMPTE` (
  `ID_COMPTE` int(11) NOT NULL,
  `TYPE` varchar(50) NOT NULL,
  `DATE_CREATION` date NOT NULL,
  `ID_CLIENT` int(11) NOT NULL,
  `ID_GESTIONNAIRE` int(11) NOT NULL,
  `SOLDE` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `COMPTE`
--

INSERT INTO `COMPTE` (`ID_COMPTE`, `TYPE`, `DATE_CREATION`, `ID_CLIENT`, `ID_GESTIONNAIRE`, `SOLDE`) VALUES
(39, 'Etudiant', '2017-10-26', 1, 3, 5753969133),
(44, 'etdudaint', '2017-10-26', 65, 55, 1311110),
(46, 'prestataire', '2017-10-26', 4, 34, 22223121234565),
(48, 'Etudiant', '2017-10-27', 2, 3, 560743),
(49, 'Prestataire', '2017-10-27', 3, 1, 3499812),
(50, 'Etudiant', '2017-10-26', 5, 2, 555555),
(51, 'Etudiant', '2017-11-05', 5, 20, 41100000),
(52, 'Prestataire', '2017-11-05', 5, 2, 1100000),
(53, 'Prestataire', '2017-11-05', 5, 2, 201100000),
(54, 'Prestataire', '2017-11-05', 5, 2, 20100000),
(55, 'Prestataire', '2017-11-05', 5, 2, 100000),
(56, 'Prestataire', '2017-11-05', 5, 2, 100000),
(57, 'Prestataire', '2017-11-05', 5, 2, 100000),
(58, 'Prestataire', '2017-11-05', 5, 2, 100000),
(59, 'Prestataire', '2017-11-05', 5, 2, 100000),
(60, 'Prestataire', '2017-11-07', 3, 2, 1100000),
(61, 'Etudiant', '2017-10-27', 30, 3, 2000000),
(62, 'Prestataire', '2017-11-07', 3, 2, 150000),
(63, 'Etudiant', '2017-10-27', 30, 3, 1950000),
(64, 'Prestataire', '2017-11-07', 3, 2, 100000),
(65, 'Etudiant', '2017-10-27', 30, 3, 150000),
(66, 'Prestataire', '2017-11-07', 3, 2, 150000),
(67, 'Etudiant', '2017-10-27', 30, 3, 100000),
(68, 'Prestataire', '2017-11-07', 3, 2, 50000),
(69, 'Etudiant', '2017-10-27', 30, 3, 100000),
(70, 'Prestataire', '2017-11-07', 3, 2, 50000),
(71, 'Etudiant', '2017-10-27', 30, 3, 100000),
(72, 'Prestataire', '2017-11-07', 3, 2, 95000),
(73, 'Etudiant', '2017-10-27', 30, 3, 55000),
(74, 'Prestataire', '2017-11-07', 3, 2, 50000),
(75, 'Etudiant', '2017-10-27', 30, 3, 100000),
(76, 'Prestataire', '2017-11-07', 3, 2, 95000),
(77, 'Etudiant', '2017-10-27', 30, 3, 105000),
(78, 'Prestataire', '2017-10-26', 12, 3, 3000000),
(79, 'Etudiant', '2017-11-09', 15, 5, 1000000),
(80, 'Etudiant', '2017-11-09', 13, 2, 50000),
(81, 'Prestataire', '2017-11-09', 14, 3, 3333334032),
(82, 'Etudiant', '2017-11-09', 15, 5, 1000000),
(83, 'Etudiant', '2017-11-09', 16, 3, 1000000),
(84, 'Prestataire', '2017-11-07', 3, 2, 95000),
(85, 'Etudiant', '2017-10-27', 30, 3, 105000),
(86, 'Prestataire', '2017-11-07', 3, 2, 95000),
(87, 'Etudiant', '2017-10-27', 30, 3, 105000),
(88, 'Prestataire', '2017-11-07', 3, 2, 50000),
(89, 'Prestataire', '2017-11-07', 3, 2, 50000),
(90, 'Prestataire', '2017-11-07', 3, 2, 95000),
(91, 'Etudiant', '2017-10-27', 30, 3, 105000),
(92, 'Prestataire', '2017-11-07', 3, 2, 95000),
(93, 'Etudiant', '2017-10-27', 30, 3, 105000),
(94, 'Prestataire', '2017-11-07', 3, 2, 95000),
(95, 'Etudiant', '2017-10-27', 30, 3, 105000),
(96, 'Prestataire', '2017-11-07', 3, 2, 50000),
(97, 'Prestataire', '2017-11-07', 3, 2, 1050000),
(98, 'Prestataire', '2017-11-07', 3, 2, 95000),
(99, 'Etudiant', '2017-10-27', 30, 3, 105000);

-- --------------------------------------------------------

--
-- Structure de la table `GESTIONNAIRE`
--

CREATE TABLE `GESTIONNAIRE` (
  `ID_GESTIONNAIRE` int(11) NOT NULL,
  `CIVILITE` varchar(25) NOT NULL,
  `NOM` varchar(50) NOT NULL,
  `PRENOM` varchar(50) NOT NULL,
  `SEXE` varchar(25) NOT NULL,
  `TELEPHONE` varchar(25) NOT NULL,
  `EMAIL` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `OPERATIONS`
--

CREATE TABLE `OPERATIONS` (
  `ID_OPERATIONS` int(11) NOT NULL,
  `DATE_OPERATION` varchar(200) NOT NULL,
  `MONTANT` double NOT NULL,
  `ID_COMPTE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `OPERATIONS`
--

INSERT INTO `OPERATIONS` (`ID_OPERATIONS`, `DATE_OPERATION`, `MONTANT`, `ID_COMPTE`) VALUES
(1, '2017-11-06', 20000000, 39),
(2, 'Mon Nov 06 13:46:37 ICT 2017', 55555, 50),
(3, 'Tue Nov 07 08:04:23 ICT 2017', 20000000, 39),
(4, 'Tue Nov 07 08:25:16 ICT 2017', 20000000, 54),
(5, 'Tue Nov 07 08:26:48 ICT 2017', 200000000, 53),
(6, 'Tue Nov 07 08:38:36 ICT 2017', 20000000, 46),
(7, 'Tue Nov 07 09:04:55 ICT 2017', 99999999, 46),
(8, 'Tue Nov 07 09:20:31 ICT 2017', 555555555, 46),
(9, 'Tue Nov 07 12:09:12 ICT 2017', 20000000, 51),
(10, 'Tue Nov 07 13:17:12 ICT 2017', 20000000, 51),
(11, 'Tue Nov 07 13:17:42 ICT 2017', 22222222222222, 46),
(12, 'Tue Nov 07 16:40:44 ICT 2017', 1000000, 60),
(13, 'Tue Nov 07 21:01:45 ICT 2017', 5555555555, 39),
(14, 'Wed Nov 08 13:09:00 ICT 2017', 500000, 78),
(15, 'Wed Nov 08 13:31:59 ICT 2017', 1000000, 48),
(16, 'Thu Nov 09 13:39:11 ICT 2017', 99, 81),
(17, 'Thu Nov 09 13:41:19 ICT 2017', 600, 81),
(18, 'Thu Nov 09 14:21:21 ICT 2017', 2000000, 78),
(19, 'Thu Nov 16 22:36:17 ICT 2017', 1000000, 97),
(20, 'Fri Nov 17 16:26:51 ICT 2017', 1000000, 48);

-- --------------------------------------------------------

--
-- Structure de la table `PAYEMENT`
--

CREATE TABLE `PAYEMENT` (
  `ID_PAYEMENT` int(11) NOT NULL,
  `DATE_PAYEMENT` varchar(50) NOT NULL,
  `ID_CPTE_PAYEUR` int(11) NOT NULL,
  `ID_CPTE_BENEF` int(11) NOT NULL,
  `MONTANT` double NOT NULL,
  `TYPE_PAYEMENT` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `PAYEMENT`
--

INSERT INTO `PAYEMENT` (`ID_PAYEMENT`, `DATE_PAYEMENT`, `ID_CPTE_PAYEUR`, `ID_CPTE_BENEF`, `MONTANT`, `TYPE_PAYEMENT`) VALUES
(1, 'Tue Nov 07 20:17:39 ICT 2017', 73, 72, 45000, 'Boutique'),
(2, 'Tue Nov 07 21:07:32 ICT 2017', 77, 76, 45000, 'Pressing'),
(3, 'Tue Nov 07 22:11:53 ICT 2017', 48, 49, 49, 'Boutique'),
(4, 'Tue Nov 07 22:15:29 ICT 2017', 48, 49, 49, 'Boutique'),
(5, 'Tue Nov 07 22:18:24 ICT 2017', 48, 49, 49, 'Cantine'),
(6, 'Tue Nov 07 22:33:23 ICT 2017', 48, 49, 555555, 'EauElectricite'),
(7, 'Tue Nov 07 23:05:45 ICT 2017', 48, 49, 55555, 'Loyer'),
(8, 'Tue Nov 07 23:09:48 ICT 2017', 48, 49, 44000, 'Internet'),
(9, 'Wed Nov 08 11:56:07 ICT 2017', 48, 49, 55555, 'Boutique'),
(10, 'Wed Nov 08 13:27:58 ICT 2017', 48, 49, 100000, 'Cantine'),
(11, 'Wed Nov 08 13:28:45 ICT 2017', 48, 49, 100000, 'Boutique'),
(12, 'Wed Nov 08 13:29:11 ICT 2017', 48, 49, 44000, 'Loyer'),
(13, 'Wed Nov 08 13:32:45 ICT 2017', 48, 49, 100000, 'Internet'),
(14, 'Wed Nov 08 13:45:32 ICT 2017', 48, 49, 100000, 'Loyer'),
(15, 'Thu Nov 09 14:01:24 ICT 2017', 48, 49, 100000, 'Boutique'),
(16, 'Thu Nov 09 14:06:17 ICT 2017', 48, 49, 40000, 'Cantine'),
(17, 'Thu Nov 09 14:24:47 ICT 2017', 48, 49, 200000, 'EauElectricite'),
(18, 'Wed Nov 15 23:41:13 ICT 2017', 85, 84, 45000, 'Pressing'),
(19, 'Thu Nov 16 21:52:51 ICT 2017', 87, 86, 45000, 'Pressing'),
(20, 'Thu Nov 16 22:14:58 ICT 2017', 91, 90, 45000, 'Pressing'),
(21, 'Thu Nov 16 22:15:57 ICT 2017', 93, 92, 45000, 'Pressing'),
(22, 'Thu Nov 16 22:35:59 ICT 2017', 95, 94, 45000, 'Pressing'),
(23, 'Thu Nov 16 22:36:17 ICT 2017', 99, 98, 45000, 'Pressing'),
(24, 'Fri Nov 17 16:33:40 ICT 2017', 48, 49, 1000000, 'Boutique');

-- --------------------------------------------------------

--
-- Structure de la table `PRESTATIONS`
--

CREATE TABLE `PRESTATIONS` (
  `ID_PRESTATION` int(11) NOT NULL,
  `TYPE_PRESTATION` varchar(25) NOT NULL,
  `DESCRIPTION` varchar(100) NOT NULL,
  `ID_PRESTATAIRE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `UTILISATEUR`
--

CREATE TABLE `UTILISATEUR` (
  `ID_UTILISATEUR` int(100) NOT NULL,
  `PROFIL` varchar(50) NOT NULL,
  `LOGIN` varchar(50) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL,
  `EMAIL` varchar(100) NOT NULL,
  `STATUS` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `UTILISATEUR`
--

INSERT INTO `UTILISATEUR` (`ID_UTILISATEUR`, `PROFIL`, `LOGIN`, `PASSWORD`, `EMAIL`, `STATUS`) VALUES
(1, 'Administrateur', 'admin', 'admin', 'admin@gmail.com', 1),
(2, 'Etudiant', 'toto', 'toto', 'toto@gmail.com', 1),
(3, 'Prestataire', 'tata', 'tata', 'tata@gmail.com', 1),
(4, 'Administrateur', 'admin2', 'admin2', 'admin2@gmail.com', 1),
(5, 'Etudiant', 'moto', 'moto', 'moto@gmail.com', 1),
(6, 'Prestataire', 'pata', 'patapata', 'pata@gmail.com', 0),
(7, 'ppp', 'tytytgg', 'hjhjhj', 'oiioko', 1),
(8, 'Administrateur', 'popo', 'popo', 'popo@gmail.com', 0),
(11, 'Gestionnaire', 'gest', 'gest', 'gest@gmail.com', 1),
(13, 'Etudiant', 'etu', 'etu', 'diallitoz@gmail.com', 1),
(14, 'Etudiant', 'zaza', 'zaza', 'zaza@gmail.com', 1),
(15, 'Administrateur', 'www', 'www', 'www', 0),
(16, 'Etudiant', 'qq', 'qq', 'qq', 0),
(17, 'Administrateur', 'eee', 'eee', 'ee', 0),
(18, 'Administrateur', 'rr', 'rr', 'rr', 0),
(19, 'Administrateur', 'dada', 'dada', 'dada@gamil.com', 1),
(20, 'Etudiant', 'etudiant1', 'etudiant1', 'etudiant@gmail.com', 1),
(21, 'Gestionnaire', 'gest1', 'gest1', 'gest1@gmail.com', 1),
(22, 'Gestionnaire', 'gest2', 'gest2', 'gest2@gmail.com', 1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `ABONNMENT`
--
ALTER TABLE `ABONNMENT`
  ADD PRIMARY KEY (`ID_ABONNEMENT`);

--
-- Index pour la table `CLIENT`
--
ALTER TABLE `CLIENT`
  ADD PRIMARY KEY (`ID_CLIENT`);

--
-- Index pour la table `COMPTE`
--
ALTER TABLE `COMPTE`
  ADD PRIMARY KEY (`ID_COMPTE`),
  ADD KEY `ID_CLIENT` (`ID_CLIENT`),
  ADD KEY `ID_GESTIONNAIRE` (`ID_GESTIONNAIRE`);

--
-- Index pour la table `GESTIONNAIRE`
--
ALTER TABLE `GESTIONNAIRE`
  ADD PRIMARY KEY (`ID_GESTIONNAIRE`);

--
-- Index pour la table `OPERATIONS`
--
ALTER TABLE `OPERATIONS`
  ADD PRIMARY KEY (`ID_OPERATIONS`);

--
-- Index pour la table `PAYEMENT`
--
ALTER TABLE `PAYEMENT`
  ADD PRIMARY KEY (`ID_PAYEMENT`);

--
-- Index pour la table `PRESTATIONS`
--
ALTER TABLE `PRESTATIONS`
  ADD PRIMARY KEY (`ID_PRESTATION`);

--
-- Index pour la table `UTILISATEUR`
--
ALTER TABLE `UTILISATEUR`
  ADD PRIMARY KEY (`ID_UTILISATEUR`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `ABONNMENT`
--
ALTER TABLE `ABONNMENT`
  MODIFY `ID_ABONNEMENT` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `CLIENT`
--
ALTER TABLE `CLIENT`
  MODIFY `ID_CLIENT` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT pour la table `COMPTE`
--
ALTER TABLE `COMPTE`
  MODIFY `ID_COMPTE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=100;

--
-- AUTO_INCREMENT pour la table `GESTIONNAIRE`
--
ALTER TABLE `GESTIONNAIRE`
  MODIFY `ID_GESTIONNAIRE` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `OPERATIONS`
--
ALTER TABLE `OPERATIONS`
  MODIFY `ID_OPERATIONS` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT pour la table `PAYEMENT`
--
ALTER TABLE `PAYEMENT`
  MODIFY `ID_PAYEMENT` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT pour la table `PRESTATIONS`
--
ALTER TABLE `PRESTATIONS`
  MODIFY `ID_PRESTATION` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `UTILISATEUR`
--
ALTER TABLE `UTILISATEUR`
  MODIFY `ID_UTILISATEUR` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
