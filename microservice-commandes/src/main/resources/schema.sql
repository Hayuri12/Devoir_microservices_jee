CREATE TABLE commande
(
    id          INT PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    quantity    INT NOT NULL ,
    date        DATE NOT NULL,
    montant     INT          NOT NULL
);