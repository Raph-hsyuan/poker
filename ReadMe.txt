@author GROUPE A
@version 2018-3-15

javac -d build/classes -cp build/classes src/poker/*.java
java -cp build/classes poker.Main

Sample input:

Player1: 2H 3D 5S 9C KD  
Player2: 2C 3H 4S 8C AH

Player1: 2H 4S 4C 2D 4H  
Player2: 2S 8S AS QS 3S

Player1: 2H 3D 5S 9C KD  
Player2: 2C 3H 4S 8C KH

Player1: 2H 3D 5S 9C KD  
Player2: 2D 3H 5C 9S KH


Sample output:

player2 win! High Card : AH 
player1 win! Full :4 over 2                      
player1 win! High Card : KD
tie.