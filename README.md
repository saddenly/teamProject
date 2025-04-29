# 📡 ArmataVR - RESTful API Documentation

Welcome to the official documentation for **ArmataVR API**, a RESTful web service that allows developers to access and manage user data, authentication, and more.

## 🌐 Base URL

```
To be implemented...
```

---

## 📚 Table of Contents

- [Authentication](#authentication)
- [Endpoints](#-endpoints)
  - [User Login](#-user-login)
  - [Get User Progress](#-get-user-progress)
  - [Update User Progress](#-update-user-progress)
  - [Save Score](#-save-score)
  - [Get User Scores](#-get-user-scores)
  - [Get Level Scores](#-get-level-scores)
- [Response Format](#-response-format)
- [Error Handling](#-error-handling)

---

## 🔐 Authentication

This API uses **JWT (JSON Web Tokens)** for authentication. Include the token in the `Authorization` header for protected routes.

```
Authorization: Bearer <your_token_here>
```

---

## 📦 Endpoints

### 🔹 User Login

**POST** `/api/auth/login`

Returns a JWT token upon successful login.

#### Request Body
```json
{
  "username": "<string>"
}
```

#### Response
```json
{
  "token": "<your_jwt_token>"
}
```

---

### 🔹 Get User Progress

**GET** `/api/game/progress`

Returns information about progress in the current user context.

#### Response
```json
{
  "id": "<string>",
  "username": "<string>",
  "levelsCompleted": 0,
  "money": 0,
  "createdAt": "<string>",
  "scores": []
}
```

---

### 🔹 Update User Progress

**PATCH** `/api/game/progress`

Updates current user's progress. Must include either `levelsCompleted` or `money` field.

#### Request body
```json
{
  "levelsCompleted": 0,
  "money": 0
}
```

---

### 🔹 Save Score

**POST** `/api/game/scores`

Saves score. Must include both `levelNumber` and `score` fields.

#### Request body
```json
{
  "levelNumber": 0,
  "score": 0
}
```

---

### 🔹 Get User Scores

**GET** `/api/game/scores`

Returns a list of scores in the current user context.

#### Response
```json
[
  {
    "id": "<string>",
    "levelNumber": 0,
    "score": 0,
    "timestamp": "<string>"
  }
]
```

---

### 🔹 Get Level Scores

**GET** `/api/game/scores/{level}`

Returns a list of scores for the given level in the current user context.

#### Response
```json
[
  {
    "id": "<string>",
    "levelNumber": 0,
    "score": 0,
    "timestamp": "<string>"
  }
]
```

---

## 🧾 Response Format

All responses are returned in JSON format.

```json
{
  "data": { ... },
  "message": "Optional message"
}
```

---

## 🚨 Error Handling

Errors follow this format:

```json
{
  "field": "Error message here"
}
```

Common status codes:
- `400 Bad Request`
- `401 Unauthorized`
- `500 Internal Server Error`

---

**Happy coding! 🚀**