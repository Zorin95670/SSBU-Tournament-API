-- Create Database
CREATE DATABASE ssbu_tournament
	ENCODING = UTF8;

-- Connect to Database
\connect ssbu_tournament

-- Create Table
CREATE TABLE TournamentType (
	id   serial       PRIMARY KEY,
	name VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE Tournament (
	id      serial       PRIMARY KEY,
	name    VARCHAR(255) UNIQUE NOT NULL,
	blocked BOOLEAN      NOT NULL DEFAULT FALSE,
	type    INTEGER      NOT NULL REFERENCES TournamentType(id)
);

CREATE TABLE Competitor (
	id         serial       PRIMARY KEY,
	name       VARCHAR(100) NOT NULL,
	tournament INTEGER      NOT NULL REFERENCES Tournament(id),
	UNIQUE (name, tournament)
); 

CREATE TABLE Character (
	id         serial       PRIMARY KEY,
	name       VARCHAR(100) NOT NULL
);

CREATE TABLE Battle (
	id         serial  PRIMARY KEY,
	date       date,
	last       BOOLEAN NOT NULL DEFAULT FALSE,
	next       INTEGER REFERENCES Battle(id),
	tournament INTEGER NOT NULL REFERENCES Tournament(id)
);

CREATE TABLE Fighter (
	id         serial       PRIMARY KEY,
	competitor INTEGER      NOT NULL REFERENCES Competitor(id),
	character  INTEGER      REFERENCES Character(id),
	battle     INTEGER      REFERENCES Battle(id)
);

CREATE TABLE BattleStatistic (
	id     serial  PRIMARY KEY,
	winner INTEGER NOT NULL REFERENCES Fighter(id),
	battle INTEGER NOT NULL UNIQUE REFERENCES Battle(id)
);
