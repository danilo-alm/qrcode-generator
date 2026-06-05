Experiment for learning Java and Spring. Kept for archival purposes.

# QR Code Generator

This is a simple QR Code generator service that accepts a JSON payload with a `"text"` field, generates a QR code image from the given text, and uploads it to an AWS S3 bucket.

## Features

- Accepts JSON input with a `"text"` field.
- Generates a QR code image for the provided text.
- Saves the generated image to an AWS S3 bucket.
- Built with Docker for easy deployment.

## Requirements

- Docker
- AWS S3 bucket & Credentials

## Configuration

- Bucket name and AWS region can be modified directly in the Dockerfile.
- AWS credentials are provided via an .env file.

## Usage

### Build the Docker Image

```bash
docker build -t qrcode-generator:1.0 .
```

### Create a `.env` File

Create a `.env` file in the root directory with the following content:

```
AWS_ACCESS_KEY_ID=your-access-key-id
AWS_SECRET_ACCESS_KEY=your-secret-access-key
```

### Run the Application

```bash
docker run --env-file .env -p 8080:8080 qrcode-generator:1.0
```

### API Example

**Request**

```http
POST /generate
Content-Type: application/json

{
  "text": "https://www.youtube.com/watch?v=dQw4w9WgXcQ"
}
```

**Response**

```json
{
  "url": "https://your-s3-bucket.s3.region.amazonaws.com/file_UUID"
}
```
