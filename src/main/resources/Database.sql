/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Nefonfo
 * Created: 6 may. 2021
 */

PRAGMA foreign_keys = ON;

CREATE TABLE [User] (
    [id] INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,
    [name] TEXT NOT NULL UNIQUE,
    [email] TEXT NOT NULL UNIQUE,
    [password] TEXT NOT NULL
);

CREATE TABLE [Homework] (
    [id] INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,
    [user_id] INTEGER REFERENCES [User](id) ON DELETE CASCADE,
    [name] TEXT NOT NULL,
    [content] TEXT,
    [expires] TEXT NOT NULL
);