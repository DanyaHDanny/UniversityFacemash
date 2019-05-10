### Инспектирование проекта на наличие технического долга:
| **Принципы** | **Статус** | **Способ решения/Причина отсуствия** |
|:--|:--|:--|
| Непонятный / нечитабельный код| +- | При написании кода выполняется соблюдение Code Convention. Небольшие исключения составляет код front-end части приложения|
| Дублирующийся код | - | Отстутствует. Повторяющийся код вынесен в методы классов | 
| Запутанная архитектура и ненужные сложные зависимости | - | Использование паттерна MVC позволяет делать архитектуру простой и понятной |
| Отсутствие автоматизации (тестов, сборки, развёртывания)| + | Тестирование выполняется мануально |
| Медленные / неэффективные средства | - | Построение приложения в специльной среде, предназначенной для создания подобных приложений |
| Незакоммиченый код / долгоживущие ветки | +- | Проект постоянно обновляется и комитится. Возникают конфликты слияния веток из-за одновременноой работы над одним участком проекта |
| Отсутствие / несоответствие технической документации | + | Отсутствие отчета о проектировании архитектурного решения. Устаревшие мокапы.|
| Отсутствие тестовой среды | + | При написании данного приложения достаточно ручного тестирования |
| Длинные циклы интеграции / отсутствие непрерывной интеграции | - | При каждом существенном обновлении приложения происходит проверка работоспособности всей системы |

### План мероприятий:

1. Проведение рефакторинга front-end части приложения (~2 часа).
2. Сделать отчет о исследовании архитектурного решения (~2 часа).
3. Написание тестов для некоторых блоков приложения, при обновлении которых проверка работоспособности всей системы не стоит своих затрат (~2 часа).
4. Навести порядок в ветках, смержить их в одну, обновив тем самым версию приложения (~ 1 час).

### Объём долга:

2+2+2+1 = 5 часов

### Объём недоимплементированных фич = 20 часов:

### Вывод:
На текущий момент проект находится на финальном этапе разработки. Наиболее важные невыполненные задачи: 1) Возможность запроса пользователя на изменение пароля; 2) Возможность пользователей просматривать профили других пользователей (студентов и преподователей)
Исходя из опыта выполнения прошлых спринтов команда способна адекватно оценить предстоящие задачи и временные затраты на них. Кроме того в проекте накопился технический долг, который необходимо устранить в финальном спринте.