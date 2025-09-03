## 📰 News Aggregator

A full-stack News Aggregator platform that compiles and displays the latest news articles from multiple sources in a single interface.

## Features
🌍 Browse top headlines and country-specific news

💾 Persistent storage with MySQL

🎨 Responsive React frontend
🏗️ Tech Stack
## Backend
Java 21
Spring Boot 3.2.x (Web, JPA)
MySQL Database
Maven for build & dependency management

## Frontend

React + Vite

React Router DOM

Axios for API calls

TailwindCSS (if styling applied)

## 🚀 Getting Started
Prerequisites
Java 21
Node.js 18+
MySQL running locally 
Maven
Git

### Prerequisites

- Node.js and npm installed on your machine
- A NewsAPI.org API key

### Installation

1. Fork the repository on GitHub.
2. Clone the repository to your local machine.
3. Navigate to the server directory and create a new file named `.env`.
4. Add your NewsAPI.org API key to the `.env` file in the following format: `API_KEY=your_news_api_key`.
5. In the server directory, run `npm install` to install the necessary dependencies.
6. Start the server by running `node index.js`.
7. Navigate to the client directory and run `npm install` to install the necessary dependencies.
8. Start the client by running `npm run dev`

🔧 Setup
1️⃣ Clone the repo
git clone https://github.com/<your-username>/news-aggregator.git
cd news-aggregator

2️⃣ Backend Setup
cd spring_backend/app
mvn clean install
mvn spring-boot:run
Backend runs at: http://localhost:8080
Swagger UI: http://localhost:8080/swagger-ui.html

3️⃣ Frontend Setup
cd react-frontend
npm install
npm run dev

Frontend runs at: http://localhost:5173
