# superheroes


1. Install [leiningen] (https://leiningen.org/)

## Compiling / Building

You can build the project with `lein uberjar`. The jar file will be generated under
the subdirectory `target/uberjar/`

## Usage

You should provide the names of two characters, e.g.: 

```
$ java -jar target/uberjar/superheroes-0.1.0-SNAPSHOT-standalone.jar Thor Joker
{:name Thor, :score 9.2, :type hero}
```

Alternatively you can just run it with leiningen:
```
$ lein run Batman Gamora
{:name Gamora, :score 8.4, :type hero}
```

```
$ lein run Batman Joker
{:name Joker, :score 8.2, :type villain}
```
## Excersize

Superheroes and supervillains are always battling it out, but how do we know who wins? This repo contains an API that gives us that answer. The API contains a /battle endpoint which takes a hero and a villain and returns the character that wins.

The characters and their stats are stored in a json file stored in AWS S3 - https://s3.eu-west-2.amazonaws.com/build-circle/characters.json

Our BattleController pulls the json file from S3 and works out the winner by comparing the scores from the json.

### Battle endpoint

Have a look in the /src endpoint. How would you make this better? Currently we only have the functions for some of the business logic. We should implement a REST API that exposes an ```/battle``` endpoint. (See acceptence tests below)

How would you improve the tests in ```./test/superheroes```  ?

### Weaknesses

Some superheroes are particularly weak against certain supervillains. If a hero has a villain specifed in their weakness field then they have 1 point knocked off their score when fighting that villain. This can affect the outcome of the battle.

Change the ```/battle``` endpoint to support this functionality.

### Validation

Superheroes can obviously only fight supervillains and vice versa. Add some validation to make sure that this requirement is met and that the opposite is not possible.

### Acceptance tests

Run the application.
1. Should return Joker - http://localhost:5000/battle?hero=Batman&villain=Joker
2. Should return Superman - http://localhost:5000/battle?hero=Superman&villain=Lex%20Luthor
