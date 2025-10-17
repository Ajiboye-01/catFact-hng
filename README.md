# Cat Fact API (HNG 13 Task)

A simple Spring Boot application that fetches random cat facts from the [CatFact API](https://catfact.ninja/fact) and returns it along with user information and a UTC timestamp.

---

## Features

- Fetches random cat facts from an external API
- Graceful error handling for network failures, timeouts, and API errors
- Returns clean JSON responses with `status`, `user`, `timestamp`, and `fact`
- Environment-based configuration (`CATFACT_API_URL`)
- CORS enabled for external calls
- Basic logging with SLF4J
- Configurable API timeout (default: 5 seconds)

---
## Requirements

- **Java 17+**
- **Maven 3.8+**
- **Internet connection** (needed to fetch cat facts)

---

## Installation & Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/Ajiboye-01/catFact-hng.git
   cd catFact-hng
2. **Build the project**
    ```bash
   mvn clean install
3. **Run the application**
   ```bash
    mvn spring-boot:run

## Example Response

**Endpoint:** `GET /me`

```json
{
  "status": "success",
  "user": {
    "email": "aariyo111@gmail.com",
    "name": "Ajiboye",
    "language": "java"
  },
  "timestamp": "2025-10-16T12:35:21.120Z",
  "fact": "Cats sleep 70% of their lives."
}
