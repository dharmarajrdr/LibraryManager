## 📘 Library Manager

**Base URL:** `http://localhost:8080/api/v1`

This API provides CRUD operations for managing books.

---

## **Endpoints**

### **1️⃣ Create a Book**

- **URL:** `POST /create/book`
- **Description:** Adds a new book to the system.
- **Request Body:**
  ```json
  {
    "title": "Apples are Square",
    "genre": "Motivational",
    "author": "Dharma"
  }
  ```
- **Response:**
  ```json
  {
    "message": "Book created successfully.",
    "responseStatus": "SUCCESS",
    "book": {
      "id": 1,
      "title": "Apples are Square",
      "genre": "Motivational",
      "author": "Dharma"
    }
  }
  ```
- **Status Codes:**
  - `201 Created` – Successfully created
  - `400 Bad Request` – Invalid input
  - `409 Conflict` – Book already exists

---

### **2️⃣ Get a Book by ID**

- **URL:** `GET /book/{id}`
- **Description:** Fetches details of a book by its ID.
- **Path Parameter:**
  - `id` (integer) – The ID of the book to retrieve.
- **Response:**
  ```json
  {
    "responseStatus": "SUCCESS",
    "data": {
      "id": 1,
      "title": "Apples are Square",
      "genre": "Motivational",
      "author": "Dharma"
    }
  }
  ```
- **Status Codes:**
  - `200 OK` – Book found
  - `404 Not Found` – Book does not exist

---

### **3️⃣ Get All Books**

- **URL:** `GET /book`
- **Description:** Retrieves a list of all books.
- **Response:**
  ```json
  {
    "responseStatus": "SUCCESS",
    "data": [
      {
        "id": 1,
        "title": "Apples are Square",
        "genre": "Motivational",
        "author": "Dharma"
      },
      {
        "id": 2,
        "title": "Mindset Shift",
        "genre": "Self-Help",
        "author": "James Clear"
      }
    ]
  }
  ```
- **Status Codes:**
  - `200 OK` – Successfully retrieved
  - `404 Not Found` – No books available

---

### **4️⃣ Update a Book by ID**

- **URL:** `PUT /book/{id}`
- **Description:** Updates details of an existing book.
- **Path Parameter:**
  - `id` (integer) – The ID of the book to update.
- **Request Body:**
  ```json
  {
    "title": "Apples are Round",
    "genre": "Motivational",
    "author": "Dharma"
  }
  ```
- **Response:**
  ```json
  {
    "responseStatus": "SUCCESS",
    "data": {
      "id": 1,
      "title": "Apples are Round",
      "genre": "Motivational",
      "author": "Dharma"
    }
  }
  ```
- **Status Codes:**
  - `200 OK` – Successfully updated
  - `400 Bad Request` – Invalid input
  - `404 Not Found` – Book does not exist

---

### **5️⃣ Delete a Book by ID**

- **URL:** `DELETE /book/{id}`
- **Description:** Deletes a book by its ID.
- **Path Parameter:**
  - `id` (integer) – The ID of the book to delete.
- **Response:**
  ```json
  {
    "responseStatus": "SUCCESS",
    "message": "Book with id '1' has been successfully deleted."
  }
  ```
- **Status Codes:**
  - `200 OK` – Successfully deleted
  - `404 Not Found` – Book does not exist
