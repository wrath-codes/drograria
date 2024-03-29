# Class Diagram for the Project

- Criação do diagrama de classes para o projeto de um sistema de restaurante.
  - O diagrama foi criado utilizando a ferramenta [Mermaid](https://mermaid-js.github.io/mermaid/#/).
  - Criação de uma entidade genérica para representar o ID de cada entidade.

    ```mermaid
        erDiagram
        Generic-Domain
    ```

    - Criação das entidades do sistema.

    ```mermaid
        erDiagram
        RESTAURANT ||--|{ MENU : has
        MENU ||--|{ MENU-ITEM : contains
        MENU-ITEM ||--|{ INGREDIENT : uses
        MENU-ITEM ||--|| CATEGORY : has
        ORDER-ITEM ||--|{ MENU-ITEM : contains
        CHECK ||--|{ CUSTOMER : has
        CUSTOMER ||--|{ ORDER-ITEM : places
        TABLE ||--|{ CUSTOMER : has


        RESTAURANT {
            int id PK
            string name 
        }
        
        
        MENU {
            int id PK
            string name
            int restaurant_id FK
            string season
            string description
        }
        
        MENU-ITEM {
            int id PK
            int menu_id FK
            int category_id FK
            int[] ingredient_id FK
            string name
            double price
            string description
        }
        
        INGREDIENT {
            int id PK
            string name
            string description
        }
        
        CATEGORY {
            int id PK
            string name
            string description
        }
        
        TABLE {
            int id PK
            int restaurant_id FK
            int number
            int capacity
            int[] order_id FK
        }
        
        
        ORDER-ITEM {
            int id PK
            int customer_id FK
            int[] menu_item_id FK
            timestamp time
            string status
        }
        
        CUSTOMER {
            int id PK
            int table_id FK
            string name
            int[] order_id FK
        }
        
        CHECK {
            int id PK
            double total
            int customer_id FK
        }


    ```
