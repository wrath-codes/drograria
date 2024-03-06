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
        RESTAURANT ||--|| ADDRESS : has
        RESTAURANT ||--|| OPEN-HOURS : has
        OPEN-HOURS ||--|{ DAY-HOURS : has
        MENU ||--|{ MENU-ITEM : contains
        MENU-ITEM ||--|{ INGREDIENT : uses
        MENU-ITEM ||--|| CATEGORY : has
        ORDER ||--|{ MENU-ITEM : contains
        CHECK ||--|{ ORDER : has
        CUSTOMER ||--|{ ORDER : places
        TABLE ||--|{ CUSTOMER : has
        TABLE ||--|| WAITER : serves
        WAITER ||--|{ ORDER : takes
        WAITER ||--|{ TABLE : serves
        WAITER ||--|{ CHECK : delivers
        CHEF ||--|{ ORDER : prepares


        RESTAURANT {
            int id PK
            string name 
            int address_id FK
            int hours_id FK
            string phone
            int capacity
        }
        
        ADDRESS {
            int id PK
            int restaurant_id FK
            int number
            string street
            string city
            string state
            string zip
            string complement
        }
        
        DAY-HOURS {
            int id PK
            string name
            timestamp open
            timestamp close
        }
        
        OPEN-HOURS {
            int id PK
            int restaurant_id FK
            int[] day_id FK
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
        
        WAITER {
            int id PK
            int restaurant_id FK
            string name
            int[] table_id FK
        }
        
        ORDER {
            int id PK
            int customer_id FK
            int waiter_id FK
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
            int[] order_id FK
        }

        CHEF {
            int id PK
            string name
            int[] order_id FK
        }
    ```
