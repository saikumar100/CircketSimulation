# CircketSimulation
A Basic game simulation runs on weighted random number generation based on probability
Project gives the match simulation between cricket teams within specified overs limit.
#Tested for 4 overs with 4 wickets in hand

The main core program lies in generating weighted random number generation
based on probability to determine the runs scored per ball.

Pre-requisites:
1)Java 1.8 or more
2)Maven 3.0 or more

INSTRUCTIONS TO RUN:

1)Edit DriverClass in your favourite IDE/textEditor.
    -->(filePath:circket-simulation/src/main/java/com/cricketsim/driverclass/DriverClass.java)
    
2)Change your team-name/players probability of hitting scores,number of overs left, 
  number of runsNeededtoWin etc.,accordingly
  
    ----->Example: /* 4-represents number of overs left
		 * 40-represents number of runs need to win
		 * */
		SimulateCricketMatch scm = new SimulateCricketMatch(players,scoresArray,4,40);
---------------------------------------------------------------


3)Inorder to run the application goto-> project directory -> open terminal -> ($> mvn clean install)

Now you will see some o/p like below:

[INFO] ------------------------------------------------------------------------ 

[INFO] BUILD SUCCESS 

[INFO] ------------------------------------------------------------------------ 

[INFO] Total time: 2.092 s 

[INFO] Finished at: 2019-11-28T01:50:43+05:30 

[INFO] Final Memory: 18M/210M 

[INFO] ------------------------------------------------------------------------ 


4) Once build gets success -> goto target directory -> then run below command:
$> java -jar circket-simulation-0.0.1-SNAPSHOT.jar
then if everything goes correct then you will see below output:

>>SCENARIO WHEN TEAM-X LOST:

4 Overs left. 40 to win
-----------------------------------------------------------
N.S Nodhi scores 4 runs

N.S Nodhi scores 1 runs

Kirat Boli scores 1 runs

N.S Nodhi scores 2 runs

N.S Nodhi scores 1 runs

Kirat Boli scores 2 runs

3 Overs left. 29 to win
-----------------------------------------------------------
N.S Nodhi scores 1 runs

Kirat Boli is out....!!!

R Rumrah scores 1 runs

N.S Nodhi scores 1 runs

R Rumrah is out....!!!

Shashi Henra scores 0 runs

Shashi Henra scores 0 runs

Shashi Henra is out....!!!



Banglore lost......!!!


Match summary.........

Kirat Boli scored :3 runs & played: 3 balls & batting status: out

-----------------------

Match summary.........

N.S Nodhi scored :10 runs & played: 6 balls & batting status: not out

-----------------------
Match summary.........

R Rumrah scored :1 runs & played: 2 balls & batting status: out

-----------------------
Match summary.........

Shashi Henra scored :0 runs & played: 3 balls & batting status: out

-----------------------


>>SCENARIO WHEN TEAM-X WINS:

4 Overs left. 40 to win
-----------------------------------------------------------
N.S Nodhi scores 1 runs

Kirat Boli scores 2 runs

Kirat Boli scores 2 runs

Kirat Boli scores 2 runs

Kirat Boli scores 2 runs

Kirat Boli scores 3 runs

3 Overs left. 28 to win
-----------------------------------------------------------
Kirat Boli scores 6 runs

Kirat Boli scores 6 runs

Kirat Boli scores 4 runs

Kirat Boli scores 4 runs

Kirat Boli scores 3 runs

N.S Nodhi scores 2 runs

2 Overs left. 3 to win
-----------------------------------------------------------
Kirat Boli scores 1 runs

N.S Nodhi scores 4 runs



Banglore won......!!!


Match summary.........

Kirat Boli scored :35 runs & played: 11 balls & batting status: not out

-----------------------
Match summary.........

N.S Nodhi scored :7 runs & played: 3 balls & batting status: not out

-----------------------
Match summary.........

R Rumrah scored :0 runs & played: 0 balls & batting status: not out

-----------------------
Match summary.........

Shashi Henra scored :0 runs & played: 0 balls & batting status: not out

-----------------------



