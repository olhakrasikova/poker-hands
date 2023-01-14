# poker-hands

Hi, 
so my solution is divided to two components: model and engine. 
Model contains description of card, suit and player. Player class calculates all the possible hands for a player and get a score. 
Engine class reads the file, that contains cards for both players. And pushes the information about the cards to player class.
I tried to make solution as easy and understandable as possible. As there are many possible options of cards possible I used single-responsibility principle and tried to make their calculation to be clean. I used unit tests to check the correctness of calculations.  
What I like about my solution is that I think this code is quite clean and easy to understand/extend, also to other developers (hopefully :) ). What I don't like is that my code is not protected from invalid input + not good at handling the situation where two players have equal score. 
I don't think there was any new methods and technologies for me in this task. But I really enjoyed the task and writing in plain Java and had an opportunity to revise streams API as at work and my last studying I was mostly focused on learning Spring framework and writing different kinds of services, controllers, api's etc. 
