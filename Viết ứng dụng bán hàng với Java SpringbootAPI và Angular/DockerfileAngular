# Base image, even version for production
FROM node:20-alpine3.17 AS builder
# Set the working directory
WORKDIR /app

# Copy the package.json and yarn.lock files
COPY ./shopapp-angular/package.json package.json
COPY ./shopapp-angular/yarn.lock yarn.lock

# Install dependencies using yarn
RUN yarn install --frozen-lockfile

# Copy the rest of the app's code excluding node_modules
COPY ./shopapp-angular/ .

# Build the Angular app in production mode
RUN yarn build:production

# Production-ready image
FROM nginx:alpine

# Copy the built app from the builder stage
COPY --from=builder /app/dist/shopapp-angular /usr/share/nginx/html

EXPOSE 80

# Start Nginx
CMD ["nginx", "-g", "daemon off;"]
#docker build -t shopapp-angular:1.0.0 -f DockerfileAngular .
#docker login
#create sunlight4d/shopapp-angular:1.0.0 repository on DockerHub
#docker tag shopapp-angular:1.0.0 sunlight4d/shopapp-angular:1.0.0
#docker push sunlight4d/shopapp-angular:1.0.0