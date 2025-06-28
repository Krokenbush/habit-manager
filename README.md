# habit-manager
# Иерархия проекта habit-manager

habit-manager/ ├── src/ │ ├── main/ │ │ ├── java/ │ │ │ └── com/ │ │ │ └── krokenbush/ │ │ │ └── habitmanager/ │ │ │ ├── config/ # Конфигурационные классы │ │ │ ├── controller/ # Контроллеры │ │ │ ├── dto/ # Data Transfer Objects │ │ │ ├── model/ # Модели данных (сущности) │ │ │ ├── repository/ # Репозитории JPA │ │ │ ├── security/ # Безопасность и конфигурации Spring Security │ │ │ └── HabitManagerApplication.java # Главный класс приложения │ │ └── resources/ │ │ ├── static/ # Статические ресурсы (CSS, JS, изображения) │ │ ├── templates/ # Шаблоны Thymeleaf │ │ └── application.properties # Конфигурационные файлы │ └── test/ # Тесты ├── .gitignore ├── pom.xml # Файл сборки Maven └── README.md # Документация проекта
