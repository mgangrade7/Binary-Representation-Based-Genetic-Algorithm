# Final Project : INFO6205 Program Structure & Algorithms - Spring 2018
### Project Topic : Binary-Representation-Based-Genetic-Algorithm
#### Submitted by : Dhruv Sharma (001825027), Mayank Gangrade (001837520)

### PROBLEM STATEMENT
To develop a Binary-Representation-Based-Genetic-Algorithm to Generate Matching String using the concept of Population Evolution, Crossover
and mutation.

### SOLUTION APPROACH
* Define cost function, cost, variables 
* Select GA parameters
* Generate initial population
* Decode chromosomes
* Find cost for each chromosome
* Select mates
* Mating and Mutation
* Convergence Check
* loop the entire process until optimum solution achieved

### POJO Classes
* **Individual :** This class mainly focusses on generating genes for an individual. 
* **Population :** This class mainly focusses on the collection of individuals and find the fittest Individual among all. 
* **FitnessCalculation :** This class mainly focusses on setting the solution and calculating the fitness with succeeding generations.
* **Algorithm :** This class mainly contains functions like population Evolution, Crossover, Mutate and Tournament Selection.
* **ParallelProcess :** This class mainly focusses on generating multiple threads using CompletableFuture (in-built class provided by
Java),
which process five different thread parallelly for a given population.
* **RandomGeneration_GA :** This is the main class from where the execution of the program takes place, which displays output of all the threads in ascending order and the most efficient solution.

### COMPONENTS OF A BINARY GENETIC ALGORITHM
#### Selecting the Variables and the Cost Function
The GA begins by defining a chromosome or an array of variable values to be optimized. If the chromosome has N variables given by p1, p2, . . . , , then the chromosome is written
as an N element row vector.
                        **chromosome = [p1p2p3.....pn]**

#### Variable Encoding and Decoding (Gene Expression)
Since the variable values are represented in binary, there must be a way of converting continuous values into binary, and visa versa.
To encode a string each character of string converted into the 8-bit binary number and at the time of decode eight-digit binary number converted into
it's equivalent character.

Character Representation : Binary Equivalent 

A : 01000001

L : 01001100

G : 01000111

O : 01001111

#### The Population
The GA starts with a group of chromosomes known as the population. The population has N chromosomes and is a 1 * N matrix filled with
random ones and zeros generated using encoding function.

#### Crossover (Evolution  Mechanism)
For generating a new solution two fittest genes are used. For the generation of a new solution, a random number generator is used and a uniform rate is maintained if the generated random number is less than or equal to uniform rate then gene of the first fittest solution is considered while in another case gene of second fittest solution considered.
```java
    private static Individual crossover(Individual i1, Individual i2) {
        Individual newSol = new Individual();

        for (int i = 0; i < i1.size(); i++) {

            if (Math.random() <= 0.5) {  // Maintaining uniform rate
                newSol.setGene(i, i1.getGene(i));
            } else {
                newSol.setGene(i, i2.getGene(i));
            }
        }
        BinaryToString(newSol.toString());
        return newSol;
    }
```

#### Mutation
For getting diversity in succeeding generation from the previous generation mutation is used. For generating diverse population a constant
mutation rate is compared with randomly generated number and individual genes are modified.
```java
    private static void mutate(Individual indiv) {

        for (int i = 0; i < indiv.size(); i++) {
            if (Math.random() <= rate_Mutation) {
                // Create random gene
                byte gene = (byte) Math.round(Math.random());
                indiv.setGene(i, gene);
            }
        }
    }
```

#### Fitness Calculation Function
Fitness Function evaluates how close a given solution is to the optimum solution of the desired problem. It determines how to fit a 
solution is. As the desired solution already sat at the beginning of the execution so every time individual gene compared with our candidate
solution gone and the fittest solution is considered when maximum matching between generated solution and candidate.
```java
    static int getFitness(Individual individual) {
        int fitness = 0;
        // Camparing individual gene with our candidate solution

        for (int i = 0; i < individual.size() && i < solution.length; i++) {
            if (individual.getGene(i) == solution[i]) {
                ++fitness;
            }
        }

        return fitness;
    }
```

