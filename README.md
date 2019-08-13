# Toy Robot

## Intro

Welcome to ToyRobot, a simple application that allows you to interact with a robot placed in a 5 x 5 squared table.

## High Level Design Solution

ToyRobotApplication uses SpringBoot to take advantage of the IoC capabilities of the framework. It is a simple command line application that captures text from standard input and passes it down to an adapter class. 

The choice for an adapter was to keep ToyRobot as clean as possible and elegant as possible. ToyRobotAdapter evaluates string input and translates it into ToyRobot commands. Inside the application package you will find the ToyRobot and ToyRobot Adapter interfaces alongside their respective implementations.

 Inside the model package you can find POJO models for the Board and the Robot as well as other smaller classes/enums that allow for better expression of the models.

## Running it

Run the command below to start off the application

```
mvn spring-boot:run
```

## Interacting with it

The first command you need to submit is the PLACE command along with X and Y coordinates and a facing cardinal direction. Example:

```
PLACE 3 3 WEST
```

After that any of the following commands is valid:

- MOVE - will move the robot forward by one unit, depending on the direction
- PLACE X Y F - where X and Y are integers greater or equal to 0 and F is the facing cardinal direction
- LEFT - turns robot left
- RIGHT - turns robot right
- REPORT - reports position the robot on the board

## Testing

Inside the test package there are multiple unit tests and ToyRobotImplApplicationTests contains integration tests, checking that the whole chain of commands executes as expected.

To run tests, run:

```
mvn clean package
```

## Possible improvements

- More integration tests
- Implement commands to interact with ToyRobot