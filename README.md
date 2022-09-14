![Kotlin](https://img.shields.io/badge/Kotlin-1.7.10-blue?logo=kotlin&link=https://kotlinlang.org/)
![DiscordKt](https://img.shields.io/badge/DiscordKt-0.23.4-blue?logo=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACgAAAAoCAYAAACM/rhtAAAABmJLR0QA/wD/AP+gvaeTAAAEvElEQVRYw+2Yy2seVRiHn3Ob756kiWlrq7ZqDSJUsSqoK4srQXHjRnShf4ILl/4FrkVcKLgS1FW3FRR05b1IMVXbNG2SJvny5ct3nZkz5+IitpW2giYOFskLA7M4Z+Y57/m9P857YC92F+Lqy/T0M/F2Atvc/EIAyNs9g3uAuw3974lZMFc9jsJwLj+Dj+72ATxSO8KrB1/nHjOHd5q1rM3Hm+/zc/b9f1vFTV3npbuf49k7ThJ9gisM3ulrz5nBj3zSfY+u39hxFe8IUCA4efgRXjv2PA05iXeaiGHyiRa2L+l87SnsNmRaBE53T3F68CnuH2z7jgHvm5rljRPPMTdxz7VMVeemOPTyYSp3JgCMzlt+fWdA71zEO41zmqV0hY823mPBzpcHeKg1wYcvvEJCDe8V1GpMv3iM5qMzN42NEdpfjFn4YETakXinyQt4e/ktLtvz5Rj1s/cfpVWPmEpO88Emh988cUs4ACFg/8k6j707w+wT23NqVc+Tk0+X54ONisBUcnRiqT9/P157vPd/OT7GiFM5B16SJJWcpJJTM6o8m6lVBCaxSBmIaU5sVXGFxXuB1gYpr/48YnNLlmYgInISTDVDFoZ6mYB3tAw6sUjlQVyXbAyRwlqUUiAEaZoSQ7imcCEiSSXHK89krVoeoNEek1i8V3hxc01577F5QSTcIMhtDUrlSYwrD3CyLrcz6BUBzy3LPsuham7gu57BZjUpr0jqFYE2BdoUmIX5bS+5ack3fDKC+2ENnVhMJadqYnkZbA9ztCkIMiCWziJ7bewjTxFmD17nUX8CXB/gv7pAuDTCJBrvFZ1sUB5gp+9Z35LMTjm0CsjxKuarUxQH7iV/+ElivQFCIEYp6odzhF9WiU5jEo2QnvZajc1RiRo0JtIbw3CkmZkKTLX+yGb7POqzRYqDx1AuIi5dIRSCkGikDPQtLK9VGI8jifHlAQ5zi1YFISjWupLeSLN/2lE1AekDanWe4BVBK7xQZCGy1jV0uooQLcoERn5YogZHGd3UMtXQaKmwXnLpimKiEZmddmgp8TIQRaDT1bTbGlsEjLE4qehmlp4dlQfoY6CfFgxTz76mpllVSKkYZprhkqHViOAl3X5CnguEdhgiQ+9pDwNpIfEyLw/w4sYYj0NIxcYwMBgrZiY0iY5EL+mPFdFHoijQJuKjY3Mo2RpFolBECYuD1fJ8sJ85Pp/f4EpvjFKBAsdyz9IeWKJyaO1QxiGVo59nLG9ljIscpR1bdsB36xdJfVZmkXhSF/lmsc++dsrxuxrsq1VIi8jlTqBZUcQg6I8FtpAorcl9wfzGgKWtETEKBkVa4hZ3Uu6cSjg6U6U7Lvjy1x5376vw0KEGiTQMck8MEoREKMFCZ8C59SHOgZSSy70Ri71u+U3T/omEx4+2mKprQJBIwYOHGhyZrkFULG9Zzi6NGeWeGCVjG/hppcul7t+3mF01TVcnHp2t8tiRFonePuNJISAIfIQYBD4IfmuP+Gmlh/NhR13djvviCCy0M1a6OcfvavLAgfr2IUtEBLDSt3y32GeY766B33XjnrvItxcH/LaeMXewipaCC+2M1Z69va4+tsYFX18o9m639gD/d4B7sdv4Hc8YdmfiizvVAAAAAElFTkSuQmCC&link=https://github.com/JakeJMattson/DiscordKt)
![License](https://img.shields.io/github/license/abzylicious/unitebraverybot)

# UniteBraveryBot 🎲

> A Discord bot heavily inpired by [Ultimate Bravery](https://www.ultimate-bravery.net) to spice up your Pokemon Unite experience.

## Required Permissions 🧰

- View Channels
- Send Messages
- Embed Links
- Read Message History

## Features 🚀

- Ultimate Bravery for Pokemon Unite
  - Get a random Pokemon you have to pick in your next match
  - Get a random lane you have to play on in your next match (if enabled for the guild)
  - Get randomized Held Items you have to pick for the given Pokemon (if enabled for the guild)
  - Get a random Battle Item you have to use in your next match (if enabled for the guild)
  - Get a randomized move set you have to use in your next match (if enabled for the guild)
  - Go shiny! For each roll there's the chance to get the shiny Pokemon sprite&#185; (chance **1:4096**)
- A permission system protects UniteBraveryBot to be abused by your members
- Command invocations are logged (given a configured logging channel)
- Multi Guild support
  - Easy initial guild configuration via a conversation
  - Each guild can configure its own bot prefix
  - Each guild can configure UniteBraveryBot's permission system to work with its respective `Admin` role
  - Each guild can configure its respective logging channel
  - Each guild can configure its own randomization options
- Dockerize the bot easily via the provided **Dockerfile** and **docker-compose.yml** file

&#185; Sprites are provided by [https://pokemondb.net](https://pokemondb.net/sprites)

## Commands 🤖

Refer to [commands.md](commands.md) for a general list and explanation of all available commands. To learn about commands during runtime, use the `help` command!

## Getting Started ⚙️

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Requirements

- Java
- Docker
- Docker-Compose (compatible with docker-compose version 3.8)

Get the Docker version you need [here](https://hub.docker.com/search?q=docker&type=edition&offering=community)!

### Setup

Since this bot has a [docker-compose.yml](docker-compose.yml) file and is hosted on [DockerHub](https://hub.docker.com/repository/docker/abzylicious/unitebraverybot), all you need to start your own version of UniteBraveryBot locally is to `clone` this repository and set up the **.env** file.

The **.env** file is used to configure the bot token and the bot default prefix, in the following format:

```
BOT_TOKEN=<insert-bot-token>
DEFAULT_PREFIX=brave!
```

#### For **Linux** and **Mac** run

```console
$ cp .env.example .env
```

#### For **Windows** run

```powershell
> Copy-Item .env.example .env
```

Edit the **.env** file with your favourite editor, filling out the following properties:

- **BOT_TOKEN** (you can find the bot token under `https://discord.com/developers/applications/{application-id}/bot` for an overview of all your bots visit https://discord.com/developers/applications)
- **DEFAULT_PREFIX** (the default prefix is **brave!**)

Run the bot via `docker-compose`

```console
$ docker-compose up --build --detach
```

## Versioning 🏷️

This project uses [Semantic Versioning](http://semver.org/) for versioning. For the versions available, see the [tags](https://github.com/Abzylicious/UniteBraveryBot/tags/) on this repository.

## Author 👤

**Alexander Deledda**

- Github: [@Abzylicious](https://github.com/Abzylicious)

See also the list of [contributors](https://github.com/Abzylicious/UniteBraveryBot/graphs/contributors) who participated in this project.

## Contributing 🤝

Contributions, issues and feature requests are welcome! Feel free to check the [issues page](https://github.com/Abzylicious/UniteBraveryBot/issues).

## Setup development environment 🛠️

For development, you don't necessarily need **Docker** and **Docker-Compose** but **Java**

- `clone` this repository
- Open the project in your favourite Java / Kotlin IDE (JetBrains [IntelliJ IDEA](https://www.jetbrains.com/idea/) is the recommended IDE for Kotlin projects)
- For running the bot within your IDE you need to add your bot token as `program argument` or `environment variable` (You might have to figure out how to do that in your IDE. **IntelliJ** let's you do that under `Run -> Edit Configurations...`)

## Show your support ⭐️

Give a ⭐️ if this project helped you!

## License 📝

Copyright © 2022 [Alexander Deledda](https://github.com/Abzylicious)<br>
This project is [MIT](LICENSE) licensed.
