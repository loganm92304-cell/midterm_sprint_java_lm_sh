# Pharmacy Management System

Java OOP project for managing patients, doctors, medications, and prescriptions.


User Documentation
Medication Tracking System
Overview

The Medication Tracking System is a Java console application that allows a pharmacy or clinic to manage doctors, patients, medications, and prescriptions.

The application demonstrates Object-Oriented Programming concepts including:

Inheritance
Encapsulation
Composition
Collections (ArrayLists)
Basic reporting
Date handling using LocalDate

The application stores information in memory using Java collections and does not require a database.

Features

The system allows the user to:

Add Patients
Add Doctors
Add Medications
Generate a system report
Display expired medications
Restock all medications

The system also supports prescriptions internally.

How to Start the Application
Requirements
Java JDK 17 (or newer)
Any Java IDE (IntelliJ IDEA, Eclipse, VS Code)

Class Descriptions
Person

Parent class for all people.

Stores common information.

Attributes

id
name
age
phoneNumber

Methods

Getters
Setters
toString()
Patient

Extends Person.

Represents a patient in the pharmacy.

Stores

medications
prescriptions

Functions

addMedication()
addPrescription()
getMedications()
getPrescriptions()

Relationship

A Patient

has many Medications
has many Prescriptions
Doctor

Extends Person.

Represents a doctor.

Stores

specialization
list of patients

Functions

addPatient()
removePatient()
getPatients()

Relationship

A Doctor manages many Patients.

Medication

Represents medicine available in stock.

Stores

ID
Name
Dose
Quantity
Expiry Date

Functions

restock()
isExpired()

Expiry dates are randomly generated for demonstration purposes.

Prescription

Represents a prescription issued by a doctor.

Stores

Doctor
Patient
Medication
Issue Date
Expiry Date

Functions

display()

Each prescription connects one:

Doctor
Patient
Medication
MedicationTrackingSystem

Main controller class.

Stores lists of:

Patients
Doctors
Medications
Prescriptions

Functions

Add patients
Add doctors
Add medications
Search
Reports
Restocking
Prescription management
Main

Entry point of the application.

Responsibilities

Displays menu
Reads user input
Calls MedicationTrackingSystem methods


Class Diagram
                   Person
                  /      \
                 /        \
             Patient     Doctor
                 |           |
                 |           |
                 |        manages
                 |           |
                 |           |
          Prescription ------|
               |
               |
         Medication

MedicationTrackingSystem
|
|-- List<Patient>
|-- List<Doctor>
|-- List<Medication>
|-- List<Prescription>

Main
|
|-- Uses MedicationTrackingSystem


Relationships

Person
 ▲
 │
 ├──────── Patient
 │             │
 │             ├── has many Medications
 │             └── has many Prescriptions
 │
 └──────── Doctor
               │
               └── manages many Patients

Prescription
 ├── Doctor
 ├── Patient
 └── Medication

MedicationTrackingSystem
contains lists of all objects.


Example Workflow

Start Program

↓

Add Doctor

↓

Add Patient

↓

Add Medication

↓

Create Prescription (internally)

↓

Generate Report

↓

Restock Medicines

↓

Exit


Development Documentation
Project Structure

MedicationTrackingSystem/

│
├── Main.java
├── MedicationTrackingSystem.java
├── Person.java
├── Doctor.java
├── Patient.java
├── Medication.java
├── Prescription.java
│
├── README.md


Source Code Description
Main.java

Application entry point.

Responsible for

Menu
User interaction
Calling system methods
MedicationTrackingSystem.java

Business logic layer.

Responsibilities

Store all data
Search objects
Generate reports
Manage prescriptions
Person.java

Superclass.

Provides reusable information for

Doctor
Patient
Doctor.java

Stores doctor-specific information.

Maintains

specialization
patients
Patient.java

Stores patient information.

Maintains

medications
prescriptions
Medication.java

Represents medicine inventory.

Provides

stock management
expiry checking
Prescription.java

Links together

Doctor
Patient
Medication


Proposed Database Design

Although the project currently stores data in memory using ArrayLists, it could be implemented using a relational database.

Person
Field	Type
PersonID	INT
Name	VARCHAR
Age	INT
Phone	VARCHAR
Doctor
Field	Type
DoctorID	INT
PersonID (FK)	INT
Specialization	VARCHAR
Patient
Field	Type
PatientID	INT
PersonID (FK)	INT
Medication
Field	Type
MedicationID	INT
Name	VARCHAR
Dose	VARCHAR
Quantity	INT
ExpiryDate	DATE
Prescription
Field	Type
PrescriptionID	INT
DoctorID (FK)	INT
PatientID (FK)	INT
MedicationID (FK)	INT
IssueDate	DATE
ExpiryDate	DATE


Entity Relationship Diagram (ERD)

Doctor
-------
DoctorID (PK)

        1
        |
        |
        | issues
        |
        *
Prescription
-------------
PrescriptionID (PK)
DoctorID (FK)
PatientID (FK)
MedicationID (FK)

        *
        |
        |
        |
        1
Patient
-------
PatientID (PK)

        *
        |
        |
        |
        1
Medication
----------
MedicationID (PK)