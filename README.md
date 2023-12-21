## Notification-API

## Description

This application provides utility APIs to send Email & SMS Notifications through various providers.

## Getting Started 

### Manually:
- Installation:
  - Java Version: `17`
  - Build Tool: `Maven`
  - Database: `Postgresql:15`

- Run Application:
  * Test: `mvn clean test`
  * Build: `mvn clean install` 
  * Run application file: `NotificationApiApplication.java`

### Using Docker-Compose:
- Installation:
  * Docker Desktop for `Mac / Windows / Linux`

- Start Application:
  * Build Application: `mvn clean install`
  * Start Application: `docker compose up --build`
  * Terminate Application and Delete Containers: `docker compose down`

- Clean Up:
  1. Remove Volumes & Images : `docker compose down -v --rmi all`

## Documentation
- [Swagger - API Documentation](http://localhost:9090/swagger-ui/index.html)

## Support

* Contact: [Email](info@digiborn.in) | [Phone](+919727184324)

## Roadmap

#### Completed:
- Email Notification:
  - [x] `JAVA MAIL CLIENT`

#### WIP:
- Email Notifications:
  - [ ] `SES`
  - [ ] `SENDGRID`

#### Future:
- SMS Notifications:
  - [ ] `Twilio` 
  - [ ] `Message91`

## Contributing

* Any contribution is highly appreciated. 
* Steps:
  1. Take a fork
  2. Make changes
  3. Create a PR
  4. Author will review and push to `main`

## Authors and acknowledgment

* Authors:
  * [Bhavesh Shah](shah27bhavesh@gmail.com)

## License

Open Source: `MIT`