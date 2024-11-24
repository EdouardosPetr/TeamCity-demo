const http = require('http');
const fs = require('fs');

const PORT = process.env.PORT || 3000;

// Serve an HTML page with inline CSS
const server = http.createServer((req, res) => {
    if (req.url === "/") {
        // Respond with HTML and CSS
        res.writeHead(200, { 'Content-Type': 'text/html' });
        res.end(`
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>TeamCity Demo</title>
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        background-color: #f4f4f9;
                        margin: 0;
                        padding: 0;
                        display: flex;
                        justify-content: center;
                        align-items: center;
                        height: 100vh;
                        color: #333;
                    }
                    .container {
                        text-align: center;
                        background: #fff;
                        padding: 2rem;
                        border-radius: 8px;
                        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
                    }
                    h1 {
                        color: #0073e6;
                    }
                    p {
                        font-size: 1.2rem;
                        margin: 1rem 0;
                    }
                    .timestamp {
                        color: #555;
                        font-style: italic;
                    }
                </style>
            </head>
            <body>
                <div class="container">
                    <h1>Welcome to the TeamCity Demo!</h1>
                    <p class="message">Message: "Hello, TeamCity!"</p>
                    <p class="timestamp">Timestamp: ${new Date().toISOString()}</p>
                    <p class="path">Path: "${req.url}"</p>
                </div>
            </body>
            </html>
        `);
    } else {
        // Handle 404 for other routes
        res.writeHead(404, { 'Content-Type': 'text/plain' });
        res.end("404 Not Found");
    }
});

server.listen(PORT, () => {
    console.log(`Server running at http://localhost:${PORT}/`);
});
