# Devoir_microservices_jee

Ce projet a été développé par Hajar Tarrih & Lina Abousalim 5iir2

Objectifs : 
 Use cas 1 :
  
* Créer un microservice commande avec sa configuration gérée au niveau de Spring Cloud et Github;
* Appliquer le Spring Actuator;
*   Personnaliser le service « health »  

 Use cas 2 :

* Créer un autre microservice produits
* Enregistrer les deux microservices auprès de Eureka
* Implémenter une API Gateway comme point d’accès unique à l’application (Zuul API Gateway)
* Simuler un Timeout d’un des deux microservices, et implémenter un mécanisme de de contournement pour protéger le microservice appelant avec Hystrix.

Screenshots: 

** La configuration des microservices via le microservice "config-server" comme étant un serveur de configuration : 


![image](https://github.com/Hayuri12/Devoir_microservices_jee/assets/105930314/ca9bfa30-947b-48d1-8f67-c611e323ab3d)

* Au niveau du github " https://github.com/Hayuri12/config-repo.git ": 
                                         
![image](https://github.com/Hayuri12/Devoir_microservices_jee/assets/105930314/fb629b77-1f6f-49fa-a964-68efd2bf56b4)





* Visualisation de la base de donnée h2 du commande :
  
![h2 console commandes](https://github.com/Hayuri12/Devoir_microservices_jee/assets/105930314/d3ac10e5-01e4-45b8-a41f-7e7fe5d64a8c)

* Lister toutes les commandes avec la propriété personnalisé "mes-config-ms.commandes-last = 10"
  
  ![list all cmds](https://github.com/Hayuri12/Devoir_microservices_jee/assets/105930314/316bac65-991f-4598-82b7-bb7f1eea2241)

* Afficher une commande par son "ID"
  
  ![list by id](https://github.com/Hayuri12/Devoir_microservices_jee/assets/105930314/7955a502-99df-44de-bfab-074671e26dd7)
  

* Supprimer une commande via son "ID"
  
  ![delete cmd by id](https://github.com/Hayuri12/Devoir_microservices_jee/assets/105930314/60724fcc-7e17-4272-b37a-367f414c846e)
  
 * Au niveau de la console
   
![log info for delete](https://github.com/Hayuri12/Devoir_microservices_jee/assets/105930314/54061862-f2e7-4232-920c-4de14101305d)

* Afficher l'état de santé du microservice-commandes
  
![actuator health](https://github.com/Hayuri12/Devoir_microservices_jee/assets/105930314/4af182ef-d1a7-4357-ada2-1deed97f1e6f)

*  Vérifier que les trois microservice Commande, Produit et Zuul sont enregistrés au niveau de Eureka
   ![eureka](https://github.com/Hayuri12/Devoir_microservices_jee/assets/105930314/e4b73af7-1f48-430e-937c-71aa8a68512e)

* Accéder directement au microservice commandes en passant par le Gateway Zuul
  ![zuul](https://github.com/Hayuri12/Devoir_microservices_jee/assets/105930314/806de201-6751-4608-82c3-b6f11fb9abd8)




  



