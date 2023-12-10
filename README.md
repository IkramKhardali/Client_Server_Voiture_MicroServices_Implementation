# Client_Server_Voiture_MicroServices_Implementation
Ce projet explore les microservices, couvrant leur création, l'utilisation de la base H2 in-memory, un microservice Gateway et la communication via OPENFEIGN. Il divise l'appli en services, utilise l'API Gateway pour les requêtes et Eureka pour enregistrer les microservices.

# Objectif
Ce projet vise à développer une compréhension approfondie de l'architecture micro-service. Les axes centraux de cet apprentissage englobent la création et l'enregistrement de micro-services, la connexion à une base de données In-memory H2, l'établissement d'un micro-service Gateway, et l'implémentation d'une communication synchrone entre les micro-services en utilisant l'outil OPENFEIGN
Dans ce projet, nous adopterons une architecture basée sur les microservices, caractérisée par la décomposition d'une application en de petits services indépendants. Au cœur de cette structure se situent les microservices clients, des entités autonomes qui interagissent pour fournir une fonctionnalité complète. L'API Gateway agit en tant que point d'entrée centralisé, simplifiant la gestion des requêtes en dirigeant le trafic vers les microservices appropriés. Le serveur de découverte Eureka revêt un rôle crucial en permettant à chaque microservice de s'enregistrer de manière dynamique, formant ainsi un annuaire décentralisé des services disponibles.


![image](https://github.com/IkramKhardali/Client_Server_Voiture_MicroServices_Implementation/assets/127056219/ffae7650-39de-4d88-9cac-7c607e4d06c8)

Pour créer le service de découverte Eureka, suivez ces étapes :

# Initialisation du projet :

Créez un nouveau projet sur Spring Initializr.
Ajoutez la dépendance Eureka Server.
## Configuration du serveur Eureka :

Dans les ressources, ajoutez les lignes de configuration pour le port et les paramètres Eureka.
Ajoutez l'annotation @EnableEurekaServer sur la classe principale du serveur.
Exécution et vérification :

![image](https://github.com/IkramKhardali/Client_Server_Voiture_MicroServices_Implementation/assets/127056219/c0d3b9c6-94fe-4476-ab21-317035d4913e)

Lancez le projet et accédez à l'URL http://localhost:8761/.
Cette page confirme la création réussie du service Discovery Eureka.
Pour créer le service client connecté à Eureka :

## Nouveau projet et dépendances :

- Créez un nouveau projet Spring Initializr.
- Ajoutez les dépendances requises telles que Spring Boot Actuator, Eureka Discovery Client, H2, Spring Data JPA, Spring Web, etc.
## Configuration du service client :

- Ajoutez les annotations @EnableEurekaClient et @SpringBootApplication sur la classe principale.
- Définissez le port et le nom du service dans les ressources.
- Vérification du bon fonctionnement :

Accédez à l'URL http://localhost:8088/ pour voir si le service client est accessible.
Vérifiez l'enregistrement du service dans Eureka via l'URL http://localhost:8761/.
Pour connecter le micro-service à une base de données H2 :

![image](https://github.com/IkramKhardali/Client_Server_Voiture_MicroServices_Implementation/assets/127056219/8bd988be-c310-4dcd-9365-23da0bb29060)


## Architecture multi-couches :

- Créez des packages pour les modèles, les repositories, les contrôleurs et les services.
Modélisation des données :

- Créez la classe Client avec des attributs tels que Id, Nom, Prénom et Age, annotée avec @Entity.
Utilisez Lombok pour générer les getters, setters et constructeurs.
Gestion de la base de données :

- Créez une interface ClientRepository étendant JpaRepository pour effectuer des opérations CRUD sur la base de données.
Annotez cette interface avec @Repository.
Contrôleur pour l'accès aux données :

- Créez un contrôleur avec des méthodes pour récupérer tous les clients ou un client spécifique en utilisant des annotations @GetMapping.
Enregistrement des clients dans H2 :

- Utilisez CommandLineRunner pour insérer des clients dans la base H2 lors du démarrage de l'application.
Sauvegardez les objets Client à l'aide de clientRepository.save().
Vérification du bon fonctionnement :

- Accédez à l'URL http://localhost:8088/clients pour voir si les données sont récupérées avec succès depuis la base de données H2.
Vérifiez l'accès à un client spécifique via l'URL http://localhost:8088/client/1.
Ces étapes permettent de créer et de connecter un service Eureka, un service client, et de configurer l'accès à une base de données H2 pour stocker et récupérer des données clients.

![image](https://github.com/IkramKhardali/Client_Server_Voiture_MicroServices_Implementation/assets/127056219/9c3832bc-9ee1-4e73-9502-0c358dca8b1c)

![image](https://github.com/IkramKhardali/Client_Server_Voiture_MicroServices_Implementation/assets/127056219/37d89146-1dba-4a96-9c63-9ecb88250e0b)

# Création du service Gateway
## Configuration Statique :
- Création d'un projet Spring Initializr.
- Ajout des dépendances pour Spring Cloud Routing Gateway, Spring Boot Actuator, Eureka Discovery Client.
- Configuration via des fichiers YAML et de propriétés pour définir les routes vers les microservices.
- Configuration Dynamique :
- Réactivation de l'enregistrement des services dans Eureka.
- Configuration de la Gateway pour rediriger les requêtes vers les microservices en utilisant le nom du service.
# Architecture de l'Application
# Transformation du diagramme de classes en code Java.
![image](https://github.com/IkramKhardali/Client_Server_Voiture_MicroServices_Implementation/assets/127056219/34e5a48a-18ff-47cb-8236-e7df8889d2e3)

# Création d'un nouveau service ("service-voiture") en suivant les étapes similaires à la création du service-client.
- Ajout des dépendances Feign et hateoas.
- Définition de la classe Client dans le package de l'application "Voiture".
- Annotation des classes Voiture et Client avec des annotations pour la persistance et les associations (@Entity, @ManyToOne).
- Configuration du service-voiture pour la découverte dans Eureka.
- Création de commandes CommandLineRunner pour insérer des données dans la base H2.
- Création d'une interface ClientService avec @FeignClient pour se connecter au service-client via REST.
- Mise en place d'une méthode clientById pour récupérer les détails du client à partir du service-client.
- Modification du CommandLineRunner pour récupérer des clients du service-client et sauvegarder des voitures avec ces clients associés dans la base de données H2.
# Vérification
Après avoir exécuté tous les microservices, vous pouvez tester en accédant aux endpoints correspondants, tels que http://localhost:8089/voitures, pour vérifier le bon fonctionnement de l'ensemble de l'architecture.

![image](https://github.com/IkramKhardali/Client_Server_Voiture_MicroServices_Implementation/assets/127056219/87c86e1f-4641-49de-8a73-e496900a00aa)











