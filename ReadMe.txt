@author GROUPE A
@version 2018-3-17
javac -d build/classes -cp build/classes src/poker/*.java
java -cp build/classes poker.Main

#######################
#PRESANTATION DE CLASS#
#######################
#   Deux Class d'Enum : Suit et Rank qui présents tous les valeurs et couleurs;
#   Class de Card: une carte contient une valeur et une couleur;
#   Class de Hand: un main contient 5 cartes et il est vide au début, une fois il va tirer autre 5 cartes, il se vide;
#   Class de Judge:  un judge connaît tous les règles de joue, il peut comparer deux mains en détectant le type de main (paire, brelan, full, etc) (choisir le maximum) et donner une ***note*** de à chaque main, après la comparaison il sait qui a gagné le joue et comment gagné le joue;
#   Class de Croupier: un croupier obtient deux String de stdin et il les transforme à deux listes de carte dans deux mains, ensuite il utilise un judge (en utilisant judger(main1,main2)) pour savoir qui est le gagnant et proclamer le résultat;
 
                ***note**
#######################
## STANDARD DE NOTER  ##
#######################
#   Les notes sont composès par sept chiffre, le première chiffre montre la classe de 5 carte : paire=1, deux paire=2, brelan=3. suite=4, couleur=5, fulle=6, carrè=7, Quinte Flush=8;
#   Chaque carte a son SHORTVALUE et LONGVALUE
#   ShortValue:A=14, R=13. D=12, V=11........3=3, 2=2;
#   LongValue: A=4096, R=2048, D=1024, V=512.......3=2, 2=1;

   Quinte Flush  POINT = 8ABCDEF;   ABCD=0000;   EF=ShortValue de plus haute carte dans le suit;
   Carrè POINT = 7ABCDEF;    AB=ShortValue de carte de Carré;   CDEF=LongValue de carte restant;
   Fulle POINT = 6ABCDEF;    AB=ShortValue de 3 cartes;   CDEF=ShortValue de 2 cartes;
   Couleur POINT = 5ABCDEF;   AB=00;    CDEF=somme de LongValue de tous les 5 cartes de mème couleur;
   Suite POINT = 4ABCDEF;    ABCD=0000;   EF=ShortValue de plus haute carte dans le suit;
   Brelan POINT = 3ABCDEF;    AB=ShortValue de 3 cartes;    CDEF=somme de LongValue de cartes restants;
   Deux paires POINT = 2ABCDEF;   ABCD=somme de LongValue de cartes de deux paires;   EF= ShortValue de carte restant;
   Paire POINT = 1ABCDEF;    AB=ShortValue de carte de paires;   CDEF=somme de LongValue de cartes restants;

#######################
##### ALGORITHME  ####
#######################
   On appele les méthodes de Detector de tous les classes un par un, haut à bas, une fois il obtient un non-zéro point il est le résultat;
   l'algorithme de Detector de class bas ne sera pas dérangé par les types de classe plus haut;
 
   qfDetector: faire appel à colorDetector , si le point est non-zéro, faire appel à suitDetector;
   carreDetector: double boucle, chaque carte de 5 cartes chercher dans les 5 cartes pour vérifier s'il y a 4 carte de mème valeur;
   fullDetector: on a un Map dont les 'keys' sont valeur de carte, les 'values' sont le nombre de chaque valeur, vérifier s'il y a 2 'keys' avec 'values' 2 et 3;
   colorDetector: vérifier si tous les cartes sont mème couleur;
   suitDetector: utiliser tri à bulles à mettre les cartes en ordre, et puis vérifier s'il est suite;
   brelanDetector: double boucle, chaque carte de 5 cartes chercher dans les 5 cartes pour vérifier s'il y a 3 carte de mème valeur;
   paire2Detector: double boucle, chaque carte de 5 cartes chercher dans les 5 cartes pour vérifier s'il y a 4 carte de 2 mème valeur;
   paire: double boucle, chaque carte de 5 cartes chercher dans les 5 cartes pour vérifier s'il y a 2 carte de mème valeur;