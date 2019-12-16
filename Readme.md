# Application API Twitch

## Présentation

Projet android utilisant  l'API REST (Nodejs) de mon projet web. Ce projet implémente le pattern MVC et un singleton dans l'interface service API.
Un système d'authentification a été mis en place (Inscription et connexion)

Cette application affiche un liste de compte Minecraft récupéré depuis une base de donnée mysql via une API en Nodejs.
Le but étant de pouvoir connecter ces comptes pour qu'ils soient AFK sur un serveur donné (non fonctionnel ici).

## Consignes respectées : 

- Architecture MVC
- Appels REST
- Ecrans : 4 activités
- Affichage d'une liste dans un RecyclerView (Liste des comptes Minecraft)
- Persistence des données (comptes minecraft et comptes utilisateurs) via une base de données mysql
- Transition entre les deux activités
- Context Menu (en restant appuyé sur un item de la liste)
- Fonctions supplémentaires :
	- Deux fragments
  - Possibilité de supprimer ou de modifier un compte en restant appuyé sur un item
	- Swipe possible entre les deux fragments (ViewPager)


## Fonctionnalités: 

### Première activité

- Ecran de connexion (Affichage d'un Toast qui indique si la connexion est réussi ou si le mot de passe est incorrect)

<img src="premier.png" alt="streamer" width="30%">

### Deuxième activité 

- Ecran d'inscription

<img src="deuxieme.png" alt="stream details" width="30%">

### Premier fragment

- Affichage des comptes minecraft

### Deuxième fragment

- Je n'ai pas eu le temps de l'implementer. Je comptais afficher la liste des utilisateurs

