# eBanking 🏦

eBanking est une application de gestion bancaire qui permet aux utilisateurs de gérer leurs comptes, de consulter leurs soldes, de changer leurs mots de passe et aux administrateurs de gérer les utilisateurs.

## Table des matières 📚

- [Fonctionnalités](#fonctionnalités)
- [Technologies utilisées](#technologies-utilisées)
- [Installation](#installation)
- [Utilisation](#utilisation)
- [Configuration](#configuration)
- [Contributions](#contributions)

## Fonctionnalités ✨

- Inscription des utilisateurs
- Gestion des utilisateurs par les administrateurs
- Consultation des informations de compte
- Changement de mot de passe
- Gestion des rôles des utilisateurs

## Technologies utilisées ⚙️

- Java 21
- Spring Boot 3.4.0
- Spring Security
- PostgreSQL
- Lombok
- JPA/Hibernate

## Installation 🚀

1. Clonez le dépôt :
   ```bash
   git clone https://github.com/nabilettihadi/eBanking.git
   cd eBanking
   ```

2. Assurez-vous d'avoir [Maven](https://maven.apache.org/install.html)
   et [PostgreSQL](https://www.postgresql.org/download/) installés.

3. Créez une base de données PostgreSQL nommée `ebanking`.

4. Modifiez le fichier `src/main/resources/application.properties` pour configurer les informations de connexion à votre
   base de données.

5. Exécutez la commande suivante pour construire le projet :
   ```bash
   mvn clean install
   ```

## Utilisation 💻

Pour démarrer l'application, exécutez la commande suivante :

```bash
mvn spring-boot:run
```

L'application sera accessible à l'adresse `http://localhost:8080`.

## Configuration ⚙️

Les paramètres de configuration de l'application se trouvent dans le fichier
`src/main/resources/application.properties`. Vous pouvez y configurer les informations de connexion à la base de données
et d'autres paramètres.

## Contributions 🤝

Les contributions sont les bienvenues ! Veuillez soumettre un pull request pour toute amélioration ou correction.