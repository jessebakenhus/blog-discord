<div align="center">
    <h1>blog discord bot 🤖</h1>
</div>

## Usage

Download the repository and run the following commands

### Set discord token as environment variable
```sh
export default DISCORD_TOKEN={YOUR_DISCORD_TOKEN}
```

### Run spring boot application

```
mvn spring-boot:run
```

### Send a notification
```sh
 curl -X POST localhost:8080/notify -H 'Content-type:application/json' -d '{"title": "Test","description": "Test","url": "https://google.com"}'
```

## Project structure
* 📁 `src`
    * 📁 `.../configurations`: Configurations for Settings and Discord Gateway
    * 📁 `.../controller`: Rest controllers for http routes
    * 📁 `.../converter`: Persistence DTO converters
    * 📁 `.../models`: All contained objects
    * 📄 `Application.java`: Spring boot application
