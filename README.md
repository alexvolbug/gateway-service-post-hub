# Gateway Service [POST_HUB]

The **gateway-service** acts as the single entry point to all microservices in the project. It receives external requests and routes them to the appropriate service — IAM-service, UTILS-service, and others

## What this service does

- Routes requests to appropriate microservices
- Validates JWT tokens at the gateway level
- Adds internal headers and logs requests
- Combines Swagger UI from all services into one interface
- Uses Consul for automatic service discovery

## Main routes

| Path                | Destination     | Access Control      |
|---------------------|-----------------|----------------------|
| `/auth/**`          | IAM-service     | Public               |
| `/users/**`         | IAM-service     | Token validation     |
| `/posts/**`         | IAM-service     | Token validation     |
| `/comments/**`      | IAM-service     | Token validation     |
| `/actionLogs/**`    | UTILS-service   | Token validation     |

## Swagger UI

Unified API documentation for all services is available at:

http://localhost:8100/webjars/swagger-ui/index.html

You can switch between documentation groups for `iam-service`, `utils-service`, and `gateway-service`