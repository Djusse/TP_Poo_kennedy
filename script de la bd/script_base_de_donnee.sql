create database BD_Appareils;
use BD_Appareils;

create table if not exists Utilisateur(
    id_utilisateur int auto_increment primary key,
    nom varchar(50) not null,
    prenom varchar(50) not null,
    tel varchar(15) not null,  
    mail varchar(50) not null,
    mot_de_passe varchar(50) not null
);

create table if not exists Appareils(
    numero_Serie varchar(30) primary key not null,
	categorie varchar(30) not null,
    type varchar(30) not null,
    nom varchar(30) not null,
    id_utilisateur int not null,
    foreign key(id_utilisateur) references Utilisateur(id_utilisateur)
);

-- Insérons plusieurs utilisateurs pour tester l'Application
INSERT INTO Utilisateur (nom, prenom, tel, mail,mot_de_passe) VALUES
("Ngassa", "Jean", "654321001", "jean.ngassa@example.com","12345"),
("Mballa", "Paul", "654321002", "paul.mballa@example.com","12345"),
("Ndo", "Martine", "654321003", "martine.ndo@example.com","12345"),
("Fouda", "Eliane", "654321004", "eliane.fouda@example.com","12345"),
("Tchoumi", "Alain", "654321005", "alain.tchoumi@example.com","12345"),
("Ekobo", "Boris", "654321006", "boris.ekobo@example.com","12345"),
("Mbarga", "Ines", "654321007", "ines.mbarga@example.com","12345"),
("Etoa", "Samuel", "654321008", "samuel.etoa@example.com","12345"),
("Ngomo", "Laura", "654321009", "laura.ngomo@example.com","12345"),
("Abega", "Christophe", "654321010", "christophe.abega@example.com","12345"),
("Zambo", "Nadine", "654321011", "nadine.zambo@example.com","12345"),
("Essomba", "Victor", "654321012", "victor.essomba@example.com","12345"),
("Owona", "Julie", "654321013", "julie.owona@example.com","12345"),
("Mvondo", "Patrick", "654321014", "patrick.mvondo@example.com","12345"),
("Ewane", "Rene", "654321015", "rene.ewane@example.com","12345"),
("Bikoi", "Fabienne", "654321016", "fabienne.bikoi@example.com","12345"),
("Etongue", "Charles", "654321017", "charles.etongue@example.com","12345"),
("Medou", "Esther", "654321018", "esther.medou@example.com","12345"),
("Kemayou", "Eric", "654321019", "eric.kemayou@example.com","12345"),
("Eboule", "Sandrine", "654321020", "sandrine.eboule@example.com","12345");

INSERT INTO Appareils (numero_Serie, categorie, type, nom, id_utilisateur) VALUES
("SN001", "Téléphonie", "Smartphone", "iPhone 13", 1),
("SN002", "Téléphonie", "Smartphone", "Galaxy S21", 2),
("SN003", "Informatique", "Laptop", "MacBook Pro", 3),
("SN004", "Téléphonie", "Montre connectée", "Montre Galaxy", 4),
("SN005", "Informatique", "NAS", "NAS Synology", 5),
("SN006", "Informatique", "Serveur", "Serveur Dell", 6),
("SN007", "Informatique", "Desktop", "Ordinateur HP", 7),
("SN008", "Périphérique", "Écran", "Écran LG", 8),
("SN009", "Périphérique", "Clavier", "Clavier Logitech", 9),
("SN010", "Périphérique", "Souris", "Souris Razer", 10),
("SN011", "Périphérique", "Imprimante", "Imprimante Canon", 11),
("SN012", "Périphérique", "Scanner", "Scanner Epson", 12),
("SN013", "Téléphonie", "Téléphone fixe", "Téléphone fixe Gigaset", 13),
("SN014", "Téléphonie", "Tablette", "Tablette Surface", 14),
("SN015", "Audio visuel", "Téléviseur", "Téléviseur Sony", 15),
("SN016", "Audio visuel", "Projecteur", "Projecteur Epson", 16),
("SN017", "Audio visuel", "Casque audio", "Casque Sony", 17),
("SN018", "Réseau", "Routeur", "Routeur Netgear", 18),
("SN019", "Réseau", "Switch", "Switch Cisco", 19),
("SN020", "Réseau", "Modem", "Modem TP-Link", 20);