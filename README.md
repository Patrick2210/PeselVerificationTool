# PESEL Verification Tool

This repository contains an application for verifying PESEL numbers, implemented in Java using Spring Boot.

## Description

The PESEL Verification Tool is a simple Spring Boot application that provides an API endpoint for validating PESEL numbers. PESEL is a national identification number used in Poland. The application exposes a RESTful API endpoint that takes a PESEL number as input and returns a response indicating whether the provided number is valid or not.

## Installation

To run the application, you need to have Java and Maven installed on your system. Follow these steps:

1. Clone the repository:


2. Navigate to the project directory:


3. Build the project using Maven:


4. Run the application:


The application will start, and you can access the API endpoint at `http://localhost:8080/api/verify-pesel`.

## API Documentation

### Verify PESEL Number

**URL:** `/api/verify-pesel`

**Method:** `POST`

**Request Body:** 

- `numberPesel` (String): The PESEL number to be validated.

**Response:**

- Status Code 200: If the provided PESEL number is valid.
- Status Code 400: If the provided PESEL number is not valid.

## Usage

Send a POST request to the `/api/verify-pesel` endpoint with the PESEL number in the request body to validate it. The server will respond with the appropriate status code indicating whether the provided number is valid or not.

Example request:

POST /api/verify-pesel
Content-Type: application/json

{
"numberPesel": "85031412345"
}


Example response:

HTTP/1.1 200 OK

## Contributors

- [Patryk Szaruga]
