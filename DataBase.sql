
CREATE DATABASE IF NOT EXISTS BankDatabase;
CREATE TABLE IF NOT EXISTS BankDatabase.Information (NationalID TEXT,FullName TEXT,DadName TEXT,BankID TEXT,PhoneNumber TEXT,Email TEXT,HomeAddres TEXT,Password TEXT,LoanID TEXT,AccountType TEXT,Balance DOUBLE);
CREATE TABLE IF NOT EXISTS BankDatabase.Bankers(UserName TEXT,Password TEXT,FullName TEXT,PhoneNumber TEXT,Address TEXT)
