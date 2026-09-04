# 🚀 Employee Data Sync using SAP CPI

## 📌 Overview

This project demonstrates a real-time integration scenario built using **SAP Cloud Platform Integration (SAP CPI)**.

It fetches employee data from a public API, processes it, filters records, transforms the structure, and sends it to a target system.


## 🧩 Integration Flow Architecture

HTTPS Sender
     ↓
Content Modifier
     ↓
Request Reply (GET API)
     ↓
Groovy Script (Processing)
     ↓
JSON → XML Converter
     ↓
Splitter
     ↓
Router (Filter: "Leanne")
     ↓
Message Mapping
     ↓
Gather
     ↓
Request Reply (POST)
     ↓
End

## 🔄 Flow Explanation

### 🔹 1. HTTPS Sender

* Endpoint: `/EmployeeSync`
* Triggered via Postman

### 🔹 2. Content Modifier

* Sets headers and properties for tracking

### 🔹 3. Request Reply (GET)

* Fetches employee data from:
  https://jsonplaceholder.typicode.com/users

### 🔹 4. Groovy Script

* Processes JSON data
* Structures records for transformation

### 🔹 5. JSON to XML Converter

* Converts payload to XML format

### 🔹 6. Splitter

* Splits employee records into individual messages

### 🔹 7. Router

* Filters employees where name contains:
  `Leanne`

### 🔹 8. Message Mapping

Transforms:

id → empId  
name → fullName  
email → emailId  


### 🔹 9. Gather

* Combines processed records into a single payload

### 🔹 10. Request Reply (POST)

* Sends output to:
  https://httpbin.org/post

## ⚙️ Technologies Used

* SAP CPI (Integration Suite)
* Groovy Scripting
* JSON & XML Processing
* Message Mapping
* REST APIs

## 💡 Key Features

✔ Real-time API integration
✔ JSON → XML transformation
✔ Splitter & Gather pattern
✔ Conditional Routing
✔ Exception Handling

## ⚠️ Error Handling

Implemented using **Exception Subprocess**:

* Captures runtime errors
* Returns structured failure response


## 👨‍💻 Author
Odugu Kula Sekhar
